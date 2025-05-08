package com.itvo.checkin


import java.time.LocalDate
import java.time.LocalTime


data class CheckInOut(
    val employee: Employee,
    val date: LocalDate,
    val checkIn: LocalTime,
    val checkOut: LocalTime
)
