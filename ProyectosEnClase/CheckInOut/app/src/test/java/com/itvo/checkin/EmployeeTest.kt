package com.itvo.checkin





import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate


class EmployeeTest {

    @Test
    fun calculateSeniority_should_ReturnCorrectYears() {
        // Given
        val hireDate = LocalDate.now().minusYears(5) // Contratado hace 5 años
        val employee = Employee(
            employeeId = 1,
            fullName = "Juan Pérez",
            academicDegree = AcademicDegree.BACHELOR,
            curp = "XEXX010101HNEXXXA4", // H: Hombre
            dateOfHire = hireDate,
            budgetKey = "ABC123"
        )

        // When
        val seniority = employee.calculateSeniority()

        // Then
        assertEquals(5, seniority, "La antigüedad debe ser 5 años")
    }

    @Test
    fun getGenre_shouldReturnCorrectGender() {
        // Given
        val employee = Employee(
            employeeId = 2,
            fullName = "Maria López",
            academicDegree = AcademicDegree.MASTER,
            curp = "XEXX010101MNEXXXA5", // M: Mujer
            dateOfHire = LocalDate.now().minusYears(3),
            budgetKey = "XYZ789"
        )

        // When
        val genre = employee.getGender()

        // Then
        assertEquals('M', genre, "El género debe ser M (Mujer)")
    }

    @Test
    fun getGender_should_ReturnCorrectGenderForMale() {
        // Given
        val employee = Employee(
            employeeId = 3,
            fullName = "Carlos García",
            academicDegree = AcademicDegree.DOCTORATE,
            curp = "XEXX010101HNEXXXA6", // H: Hombre
            dateOfHire = LocalDate.now().minusYears(7),
            budgetKey = "LMN456"
        )

        // When
        val genre = employee.getGender()

        // Then
        assertEquals('H', genre, "El género debe ser H (Hombre)")
    }
}

