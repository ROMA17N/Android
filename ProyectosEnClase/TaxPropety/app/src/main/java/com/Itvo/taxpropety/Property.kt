package com.Itvo.taxpropety

data class Property(
    val extension: Double,
    val zone: Zone,
    val owner: Person
) {
    fun tax() = this.extension * this.zone.costForSquareMeter
}

