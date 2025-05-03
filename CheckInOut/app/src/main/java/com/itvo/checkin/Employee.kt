package com.itvo.checkin


import java.time.LocalDate
import java.time.Period

data class Employee(
    val employeeId: Int,
    val fullName: String,
    val academicDegree: AcademicDegree,
    val curp: String,
    val dateOfHire: LocalDate,
    val budgetKey: String
) {
    fun calculateSeniority(): Int {
        val currentDate = LocalDate.now()
        return Period.between(this.dateOfHire, currentDate).years
    }

    fun getGender()= curp[10]

}
