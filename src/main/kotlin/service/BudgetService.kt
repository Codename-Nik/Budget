package org.example.service

import org.example.model.Budget
import org.example.model.BudgetItem
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.YearMonth

class BudgetService(private val budget: Budget) {

    fun addBudgetItem(item: BudgetItem) {
        budget.addItem(item)
    }

    fun getTotalBalance(): Double {
        return budget.getItems().sumOf { it.amount }
    }

    fun getMonthlyExpenses(yearMonth: YearMonth): Double {
        return budget.getItems()
            .filter { YearMonth.from(it.date) == yearMonth && it.amount < 0}
            .sumOf { it.amount }
    }

    fun getMonthlyIncome(yearMonth: YearMonth): Double {
        return budget.getItems()
            .filter { YearMonth.from(it.date) == yearMonth && it.amount > 0}
            .sumOf { it.amount }
    }

    fun getAverageExpense(): Double {
        val expenses = budget.getItems().filter { it.amount < 0 }
        if (expenses.isEmpty()) return 0.0

        val average = expenses.map { it.amount }.average()
        return BigDecimal(average).setScale(2, RoundingMode.HALF_UP).toDouble()
    }

    fun getExpensesByCategory(yearMonth: YearMonth): Map<String, Double> {
        return budget.getItems()
            .filter { YearMonth.from(it.date) == yearMonth && it.amount < 0}
            .groupBy { it.category }
            .mapValues { entry -> BigDecimal(entry.value.sumOf { it.amount }).setScale(2, RoundingMode.HALF_UP).toDouble() }
    }

    fun getExpensesForPeriod(startDate: java.time.LocalDate, endDate: java.time.LocalDate): Double {
        return  budget.getItems()
            .filter { it.date >= startDate && it.date <= endDate && it.amount < 0 }
            .sumOf { it.amount }
    }

    fun getIncomeForPeriod(startDate: java.time.LocalDate, endDate: java.time.LocalDate): Double {
        return  budget.getItems()
            .filter { it.date >= startDate && it.date <= endDate && it.amount > 0 }
            .sumOf { it.amount }
    }
}