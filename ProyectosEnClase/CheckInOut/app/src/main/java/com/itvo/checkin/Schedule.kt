package com.itvo.checkin


import java.time.DayOfWeek
import java.time.LocalTime

data class Schedule(
    val employee: Employee,
    val period: Period,
    val dayOfWeek: DayOfWeek,
    val checkInTime: LocalTime,
    val checkOutTime: LocalTime
)

