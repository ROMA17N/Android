package com.itvo.salary

import java.time.LocalDate

fun main(){
    val workers = listOf(
        Worker(fullName = "Ambrosio Cardoso",
            curp = "CAJA741207HOCRMM06",
            dateOfHire = LocalDate.parse("2009-05-16"),
            category = Category.UNO
        ),
        Worker(fullName = "Rosa Maria Lopez",
            curp = "LOSR990817MOCSRS01",
            dateOfHire = LocalDate.parse("2024-08-16"),
            category = Category.TRES
        ),
    )
    val payroll =  Payroll (
        worker = workers[0],
        hoursWorked = 45
    )

    println("${workers[0].fullName} recibe \n" +
            "pago base: ${payroll.calculateBasePay()} \n" +
            "horas extras: ${payroll.calculateOvertimePay()} \n" +
            "TOTAL: ${payroll.calculatePayWithOvertime()}"
    )
}
