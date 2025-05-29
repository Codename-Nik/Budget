package service

import org.example.model.Budget
import org.example.model.BudgetItem
import org.example.service.BudgetService
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.YearMonth

class BudgetServiceTest {
    @BeforeEach
    fun setUp() {
        TODO("Not yet implemented")
    }

    @AfterEach
    fun tearDown() {
        TODO("Not yet implemented")
    }

    @Test
    fun addBudgetItem() {
        val budget = Budget()
        val budgetService = BudgetService(budget)
        val item1 = BudgetItem(LocalDate.now(), "Food", -50.0)
        val item2 = BudgetItem(LocalDate.now(), "Salary", 2000.0)
        budgetService.addBudgetItem(item1)
        budgetService.addBudgetItem(item2)
        assertEquals(1950.0,budgetService.getTotalBalance())
    }

    @Test
    fun getMonthlyExpenses() {
        val budget = Budget()
        val budgetService = BudgetService(budget)
        val now = LocalDate.now()
        val item1 = BudgetItem(now, "Food", -50.0)
        val item2 = BudgetItem(now.minusMonths(1), "Rent", -1000.0)
        val item3 = BudgetItem(now, "Salary", 2000.0)
        budgetService.addBudgetItem(item1)
        budgetService.addBudgetItem(item2)
        budgetService.addBudgetItem(item3)
        assertEquals(-50.0, budgetService.getMonthlyExpenses(YearMonth.from(now)))
    }

    @Test
    fun getAverageExpense() {
        val budget = Budget()
        val budgetService = BudgetService(budget)
        val now = LocalDate.now()
        val item1 = BudgetItem(now, "Food", -50.0)
        val item2 = BudgetItem(now.minusMonths(1), "Rent", -100.0)
        val item3 = BudgetItem(now, "Entertainment", -25.0)
        budgetService.addBudgetItem(item1)
        budgetService.addBudgetItem(item2)
        budgetService.addBudgetItem(item3)
        assertEquals(-58.33, budgetService.getAverageExpense())
        val item4 = BudgetItem(now, "Salary", 2000.0)
        budgetService.addBudgetItem(item4)
        assertEquals(0.0, budgetService.getAverageExpense())
    }

    @Test
    fun getExpensesByCategory() {
        val budget = Budget()
        val budgetService = BudgetService(budget)
        val now = LocalDate.now()
        val item1 = BudgetItem(now, "Food", -50.0)
        val item2 = BudgetItem(now, "Food", -25.0)
        val item3 = BudgetItem(now, "Rent", -100.0)
        budgetService.addBudgetItem(item1)
        budgetService.addBudgetItem(item2)
        budgetService.addBudgetItem(item3)
        val expensesByCategory = budgetService.getExpensesByCategory(YearMonth.from(now))
        assertEquals(mapOf("Food" to -75.0, "Rent" to -100.0), expensesByCategory)
    }

    @Test
    fun getExpensesForPeriod() {
        val budget = Budget()
        val budgetService = BudgetService(budget)
        val now = LocalDate.now()
        val start = now.minusDays(7)
        val end = now.plusDays(7)
        val item1 = BudgetItem(now, "Food", -50.0)
        val item2 = BudgetItem(now.minusDays(10), "Food", -25.0)
        val item3 = BudgetItem(now.plusDays(5), "Rent", -100.0)
        budgetService.addBudgetItem(item1)
        budgetService.addBudgetItem(item2)
        budgetService.addBudgetItem(item3)
        assertEquals(-150.0, budgetService.getExpensesForPeriod(start, end))
    }

}