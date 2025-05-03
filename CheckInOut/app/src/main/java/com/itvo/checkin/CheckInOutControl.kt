package com.itvo.checkin

import java.time.temporal.ChronoUnit

class CheckInOutControl() {
    private val checkInOuts = mutableListOf<CheckInOut>()
    private val schedules = mutableListOf<Schedule>()
    private val permissions = mutableListOf<Permission>()

    fun addSchedule(schedule: Schedule) {
        schedules.add(schedule)
    }

    fun registerCheckInOut(checkInOut: CheckInOut) {
        checkInOuts.add(checkInOut)
    }

    fun registerPermission(permission: Permission) {
        permissions.add(
            permission
        )
    }

    private fun isDelay(checkInOut: CheckInOut, schedule: Schedule?): Boolean {
        val minutesDifference =
            ChronoUnit.MINUTES.between(schedule!!.checkInTime, checkInOut.checkIn)
        return (minutesDifference in 11..20)
    }

    private fun isAbsence(checkInOut: CheckInOut, schedule: Schedule?): Boolean {
        val minutesDifference =
            ChronoUnit.MINUTES.between(schedule!!.checkInTime, checkInOut.checkIn)

        return (checkInOut.checkOut.isBefore(schedule.checkOutTime) ||
                minutesDifference > 20)
    }

    private fun countPermissions(
        employee: Employee,
        period: Period
    ): Int {
        val filteredPermissions = permissions.filter {
            it.date in period.initialDate..period.finalDate && it.employee == employee
        }
        return filteredPermissions.count()
    }


    fun calculateIncidenceForPeriod(employee: Employee, period: Period): Incidence {
        val filteredCheckInOuts = checkInOuts.filter {
            it.employee == employee && it.date in period.initialDate..period.finalDate
        }

        val employeeSchedules = schedules.filter {
            it.employee == employee &&
                    period.initialDate >= it.period.initialDate &&
                    period.initialDate <= it.period.finalDate
        }
        var delays = 0
        var absences = 0

        for (checkInOut in filteredCheckInOuts) {
            val schedule = employeeSchedules.find { it.dayOfWeek == checkInOut.date.dayOfWeek }
            delays += if (isDelay(checkInOut, schedule)) 1 else 0
            absences += if (isAbsence(checkInOut, schedule)) 1 else 0
        }

        //--- Convert delays to absences if applicable
        val seniority = employee.calculateSeniority()
        if (seniority < 10) {
            absences += delays / 3
            delays %= 3
        }

        return Incidence(
            delays = delays,
            absences = absences,
            permissions = countPermissions(
                employee = employee,
                period = period
            )
        )
    }

}
