package com.Itvo.taxpropety

import com.Itvo.taxpropety.Person
import java.time.LocalDate
import java.time.Month

data class Tax(
    val properties: List<Property>,
    val owner: Person,
    val datePayment: LocalDate
) {
    fun total() = properties.filter { it.owner == owner }.sumOf { it.tax() }
    fun calculateDiscount(): Double {
        val total = this.total()
        val SEVENTY_YEARS = 70
        val discount = if (owner.getAge() >= SEVENTY_YEARS ||
            owner.maritalState == MaritalState.Single){
            if (datePayment.month<= Month.FEBRUARY){
                total * 0.70
            } else total * 0.50
        } else {
            if (datePayment.month<= Month.FEBRUARY){
                total * 0.40
            } else 0.0
        }
        return discount
    }

    fun calculateNetTotal() = total()-calculateDiscount()

}

/*
    fun calculateDiscunt(): Double {
        val total = this.total()
        val SEVENTY_YEARS = 70
        val discount = if (owner.getAge() >= SEVENTY_YEARS ||
            owner.MaritalState == MaritalState.Single
        ) {
            if (datePayment.month <= Month.FEBRUARY) {
                total * 0.70
            } else {
                total * 0.50
            }
        } else {
            if (datePayment.month <= Month.FEBRUARY) {
                total * 0.40
            } else {
                total * 0.0
            }
        }
        return discount
    }
}
*/