package com.itvo.checkin

//------------------------- TEST 3 RETARDOS = 1 FALTA ------------------------------------------

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime

class CheckInOutControlTest3 {
    val checkInOutControl = CheckInOutControl()
    val employee = Employee(
        employeeId = 3,
        fullName = "Rosario Martinez Gomez",
        academicDegree = AcademicDegree.MASTER,
        curp = "XXXX200101MOCRSDC",
        dateOfHire = LocalDate.of(2015, 5, 16),
        budgetKey = "123ABC"
    )
    val period = Period(
        initialDate = LocalDate.of(2025, 1, 1),
        finalDate = LocalDate.of(2025, 12, 31)
    )


    fun testAddSchedule() {
        checkInOutControl.addSchedule(
            Schedule(
                employee = employee,
                period = period,
                dayOfWeek = DayOfWeek.MONDAY,
                checkInTime = LocalTime.of(8, 0, 0),
                checkOutTime = LocalTime.of(15, 0, 0)
            )
        )
        checkInOutControl.addSchedule(
            Schedule(
                employee = employee,
                period = period,
                dayOfWeek = DayOfWeek.TUESDAY,
                checkInTime = LocalTime.of(8, 0, 0),
                checkOutTime = LocalTime.of(15, 0, 0)
            )
        )
        checkInOutControl.addSchedule(
            Schedule(
                employee = employee,
                period = period,
                dayOfWeek = DayOfWeek.FRIDAY,
                checkInTime = LocalTime.of(8, 0, 0),
                checkOutTime = LocalTime.of(15, 0, 0)
            )
        )
    }


    fun testRegisterCheckInOut() {
        checkInOutControl.registerCheckInOut(
            CheckInOut(
                employee = employee,
                date = LocalDate.of(2025, 2, 11),
                checkIn = LocalTime.of(8, 19, 0),
                checkOut = LocalTime.of(15, 0, 0)
            )
        )
        checkInOutControl.registerCheckInOut(
            CheckInOut(
                employee = employee,
                date = LocalDate.of(2025, 2, 14),
                checkIn = LocalTime.of(8, 13, 0),
                checkOut = LocalTime.of(15, 6, 0)
            )
        )
        checkInOutControl.registerCheckInOut(
            CheckInOut(
                employee = employee,
                date = LocalDate.of(2025, 2, 10),
                checkIn = LocalTime.of(8, 16, 0),
                checkOut = LocalTime.of(15, 0, 0)
            )
        )
    }


    //------------------------- TEST 3 RETARDOS = 1 FALTA ------------------------------------------

    @Test
    fun testCalculateIncidenceForPeriodShouldReturnOneabsences() {
        testAddSchedule()
        testRegisterCheckInOut()
        val incidence = checkInOutControl.calculateIncidenceForPeriod(
            employee = employee,
            period = Period(
                initialDate = LocalDate.of(2025, 2, 1),
                finalDate = LocalDate.of(2025, 2, 15)
            )
        )
        assertEquals(1, incidence.absences)
    }
}

