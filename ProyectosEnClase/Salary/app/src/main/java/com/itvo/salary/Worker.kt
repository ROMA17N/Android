package com.itvo.salary

import java.time.LocalDate
import java.time.Period

data class Worker (
    val fullName: String,
    val curp: String,
    val dateOfHire: LocalDate,
    val category: Category
) {
    fun calculateSeniority(): Int {
        val currentDate = LocalDate.now()
        return Period.between(this.dateOfHire, currentDate).years
    }
}

