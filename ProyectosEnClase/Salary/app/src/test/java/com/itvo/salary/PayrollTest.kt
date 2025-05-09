package com.itvo.salary


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate


class PayrollTest {

    private val workerUno = Worker(
        "Juan",
        curp = "CAJA741207HOCRMM06",
        dateOfHire = LocalDate.parse("2000-01-01"),
        category = Category.UNO
    )
    private val workerDos = Worker(
        "Maria",
        curp = "CAJA741207HOCRMM06",
        dateOfHire = LocalDate.parse("1950-01-01"),
        Category.DOS
    )
    private val workerTres = Worker(
        "Pedro",
        curp = "CAJA741207HOCRMM06",
        dateOfHire = LocalDate.parse("1974-01-01"),
        Category.TRES
    )

    @Test
    fun `test calculateHourlyRate should return correct rate based on category`() {
        assertEquals(130.5, Payroll(workerUno, 40).calculateHourlyRate(), 0.01)
        assertEquals(112.5, Payroll(workerDos, 40).calculateHourlyRate(), 0.01)
        assertEquals(90.0, Payroll(workerTres, 40).calculateHourlyRate(), 0.01)
    }

    @Test
    fun `test calculateOvertime should return correct overtime hours`() {
        assertEquals(0, Payroll(workerUno, 30).calculateOvertime())
        assertEquals(0, Payroll(workerUno, 40).calculateOvertime())
        assertEquals(5, Payroll(workerUno, 45).calculateOvertime())
        assertEquals(15, Payroll(workerUno, 55).calculateOvertime())
    }

    @Test
    fun `test calculateOvertimePay should return correct amount`() {
        assertEquals(0.0, Payroll(workerUno, 40).calculateOvertimePay(), 0.01)
        assertEquals(
            130.5 * 1.5 * 5,
            Payroll(workerUno, 45).calculateOvertimePay(),
            0.01
        )  // 5 horas extra (factor 1.5)
        assertEquals(
            130.5 * 1.4 * 15,
            Payroll(workerUno, 55).calculateOvertimePay(),
            0.01
        ) // 15 horas extra (factor 1.4)
        assertEquals(
            130.5 * 1.2 * 25,
            Payroll(workerUno, 65).calculateOvertimePay(),
            0.01
        ) // 25 horas extra (factor 1.2)
    }

    @Test
    fun `test calculateBasePay should return correct base pay`() {
        assertEquals(130.5 * 30, Payroll(workerUno, 30).calculateBasePay(), 0.01)
        assertEquals(130.5 * 40, Payroll(workerUno, 40).calculateBasePay(), 0.01)
        assertEquals(130.5 * 40, Payroll(workerUno, 50).calculateBasePay(), 0.01) // Máximo 40 horas base
    }

    @Test
    fun `test calculatePayWithOvertime should return correct total pay`() {
        assertEquals(130.5 * 40, Payroll(workerUno, 40).calculatePayWithOvertime(), 0.01)
        assertEquals((130.5 * 40) + (130.5 * 1.5 * 5), Payroll(workerUno, 45).calculatePayWithOvertime(), 0.01)
        assertEquals((130.5 * 40) + (130.5 * 1.4 * 15), Payroll(workerUno, 55).calculatePayWithOvertime(), 0.01)
        assertEquals((130.5 * 40) + (130.5 * 1.2 * 25), Payroll(workerUno, 65).calculatePayWithOvertime(), 0.01)
    }
}

