package org.example.model

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class BudgetItem(
    val date: LocalDate,
    val category: String,
    val amount: Double,
    val description: String = ""
) {
    init {
        require(category.isNotBlank())
        require(amount != 0.0)
    }

    companion object {
        private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

        fun parseDate(dateString: String): LocalDate {
            return try {
                LocalDate.parse(dateString, dateFormatter)
            } catch (e: DateTimeParseException ) {
                throw IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd.")
            }
        }
    }
}