package com.itvo.salary

data class Payroll(
    val worker: Worker,
    val hoursWorked: Int
){
    fun calculateHourlyRate(): Double {
        val normalHourlyRate = 90.0
        return when (this.worker.category){
            Category.UNO -> normalHourlyRate * 1.45
            Category.DOS -> normalHourlyRate * 1.25
            Category.TRES -> normalHourlyRate
        }
    }

    fun calculateOvertime(): Int {
        return 0.coerceAtLeast(hoursWorked - 40)
    }

    fun calculateOvertimePay(): Double {
        val overtime =  this.calculateOvertime()
        val overtimePay = when (overtime){
            in 0..10 ->{
                overtime * calculateHourlyRate() * 1.5
            }
            in 11..20 ->{
                overtime * calculateHourlyRate() * 1.4
            }
            else -> {overtime * calculateHourlyRate() * 1.2}
        }
        return  overtimePay
    }
    fun calculateBasePay (): Double {
        return calculateHourlyRate() * this.hoursWorked.coerceAtMost(40)
    }
    fun calculatePayWithOvertime(): Double{
        return  this.calculateBasePay() +
                this.calculateOvertimePay()
    }
}