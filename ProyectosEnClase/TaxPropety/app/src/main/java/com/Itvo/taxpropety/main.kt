package com.Itvo.taxpropety

import java.time.LocalDate

fun main() {
    val owner1 = Person(
        name = "JOSE JOSE",
        birthdate = LocalDate.parse("1950-01-01"),
        genre = "H",
        MaritalState.Single
    )
    val owner2 = Person(
        name = "Maria Belen",
        birthdate = LocalDate.parse("1980-01-01"),
        genre = "M",
        MaritalState.Married
    )

    val ruralZone = Zone(key = "RUR", "Zona Rural", 10.00)
    val marginalZone = Zone(key = "MAR", "Zona Marginada", 2.00)
    val residentialZone = Zone(key = "RES", "Zona Residencial", 25.00)

    val properties = listOf<Property>(
        Property(extension = 500.0, zone = ruralZone, owner1),
        Property(extension = 1000.0, zone = residentialZone, owner1),
        Property(extension = 200.0, zone = marginalZone, owner2)
    )
    val taxOwner1 = Tax(
        properties = properties,
        datePayment = LocalDate.now(),
        owner = owner1
    )
    val taxOwner2 = Tax(
        properties = properties,
        datePayment = LocalDate.now(),
        owner = owner2
    )

    println("${owner1.name} => Total: ${taxOwner1.total()}, Discount: ${taxOwner1.calculateDiscount()}, Net total: ${taxOwner1.calculateNetTotal()}")

    println("${owner2.name} => Total: ${taxOwner2.total()}, Discount: ${taxOwner2.calculateDiscount()}, Net total: ${taxOwner2.calculateNetTotal()}")


}