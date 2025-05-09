package com.itvo.salary

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate


class WorkerTest{
    @Test
    fun `test calculateSeniority when hired over a year ago`() {
        // Datos de entrada: trabajador con fecha de contratación hace 3 años
        val worker = Worker(
            fullName = "Juan Pérez",
            curp = "JUAP901231HDFRRR04",
            dateOfHire = LocalDate.of(2020, 2, 14),
            category = Category.UNO
        )

        // Valor esperado: La antigüedad debe ser 3 años (2023 - 2020)
        val expectedSeniority = 5

        // Verificación
        assertEquals(expectedSeniority, worker.calculateSeniority())
    }

    @Test
    fun `test calculateSeniority when hired less than a year ago`() {
        // Datos de entrada: trabajador con fecha de contratación hace 6 meses
        val worker = Worker(
            fullName = "Ana Gómez",
            curp = "ANAG940612MDFLRS07",
            dateOfHire = LocalDate.of(2024, 8, 13),
            category = Category.DOS
        )

        // Valor esperado: La antigüedad debe ser 0 años (2025 - 2024)
        val expectedSeniority = 0

        // Verificación
        assertEquals(expectedSeniority, worker.calculateSeniority())
    }

    @Test
    fun `test calculateSeniority when hired exactly a year ago`() {
        // Datos de entrada: trabajador con fecha de contratación hace exactamente un año
        val worker = Worker(
            fullName = "Luis Pérez",
            curp = "LUIP800402HDFLSR03",
            dateOfHire = LocalDate.of(2024, 2, 13),
            category = Category.TRES
        )

        // Valor esperado: La antigüedad debe ser 1 año (2025 - 2024)
        val expectedSeniority = 1

        // Verificación
        assertEquals(expectedSeniority, worker.calculateSeniority())
    }

    @Test
    fun `test calculateSeniority when hired on the leap year`() {
        // Datos de entrada: trabajador contratado el 29 de febrero de un año bisiesto (2020)
        val worker = Worker(
            fullName = "Carlos Martínez",
            curp = "CARL770101HDFRNT08",
            dateOfHire = LocalDate.of(2020, 2, 29),
            category = Category.UNO
        )

        // Valor esperado: La antigüedad debe ser 5 años (2025 - 2020)
        val expectedSeniority = 4

        // Verificación
        assertEquals(expectedSeniority, worker.calculateSeniority())
    }
}


//---










