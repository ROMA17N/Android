package com.Itvo.taxpropety

import java.time.LocalDate
import java.util.Date

data class Person(
    val name: String,
    val birthdate: LocalDate,
    val genre: String,
    val maritalState: MaritalState
) {

    fun getAge(): Int {
        return LocalDate.now().year - birthdate.year
    }
}

