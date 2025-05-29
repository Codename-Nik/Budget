package org.example.ui

import org.example.model.BudgetItem
import org.example.service.BudgetService
import java.time.YearMonth
import java.util.Scanner

class ConsoleUI(private val budgetService: BudgetService) {

    private val scanner = Scanner(System.`in`)

    fun run() {
        while (true) {
            println("\n Budget App Menu:")
            println("1. Add Budget Item")
            println("2. View Total Balance")
            println("3. View Monthly Expenses")
            println("4. View Monthly Income")
            println("5. View Average Expense")
            println("6. View Expenses by Category")
            println("7. View Expenses for Period")
            println("8. Income for Period")
            println("9. Exit")
            print("Enter your choice: ")
            when (scanner.nextLine()) {
                "1" -> addBudgetItem()
                "2" -> viewTotalBalance()
                "3" -> viewMonthlyExpenses()
                "4" -> viewMonthlyIncome()
                "5" -> viewAverageExpense()
                "6" -> viewExpensesByCategory()
                "7" -> viewExpensesForPeriod()
                "8" -> viewIncomeForPeriod()
                "9" -> {
                    println("Exiting...")
                    return
                }

                else -> println("Invalid choice. Please try again.")
            }
        }
    }

    private fun addBudgetItem() {
        try {
            print("Enter date(yyyy-MM-dd): ")
            val dateString = scanner.nextLine()
            val date = BudgetItem.parseDate(dateString)
            print("Enter category: ")
            val category = scanner.nextLine()
            print("Enter amount (positive for income, negative for expense):")
            val amount = scanner.nextDouble()
            scanner.nextLine()
            print("Enter description (optional): ")
            val description = scanner.nextLine()
            val item = BudgetItem(date, category, amount, description)
            budgetService.addBudgetItem(item)
            println("Budget item added successfully.")
        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}")
        } catch (e: NumberFormatException) {
            println("Invalid amount format. Please enter a number.")
        } catch (e: Exception) {
            println("An unexpected error occurred: ${e.message}")
        }
    }

    private fun viewTotalBalance() {
        val balance = budgetService.getTotalBalance()
        println("Total Balance: $balance")
    }

    private fun viewMonthlyExpenses() {
        try {
            print("Enter year and month:(yyyy-MM): ")
            val yearMonthString = scanner.nextLine()
            val yearMonth = YearMonth.parse(yearMonthString)
            val expenses = budgetService.getMonthlyExpenses(yearMonth)
            println("Mouthly Expenses for $yearMonth: $expenses")
        } catch (e: Exception) {
            println("Invalid year-month format. Please use yyyy-MM.")
        }
    }

    private fun viewMonthlyIncome() {
        try {
            print("Enter year and month:(yyyy-MM): ")
            val yearMonthString = scanner.nextLine()
            val yearMonth = YearMonth.parse(yearMonthString)
            val income = budgetService.getMonthlyIncome(yearMonth)
            println("Mouthly Expenses for $yearMonth: $income")
        } catch (e: Exception) {
            println("Invalid year-month format. Please use yyyy-MM.")
        }
    }

    private fun viewAverageExpense() {
        val average = budgetService.getAverageExpense()
        println("Average Expense: $average")
    }

    private fun viewExpensesByCategory() {
        try {
            print("Enter year and month:(yyyy-MM): ")
            val yearMonthString = scanner.nextLine()
            val yearMonth = YearMonth.parse(yearMonthString)
            val expensesByCategory = budgetService.getExpensesByCategory(yearMonth)
            println("Expenses by Category for $yearMonth:")
            expensesByCategory.forEach { (category, amount) ->
                println("$category: $amount")
            }
        } catch (e: Exception) {
            println("Invalid year-month format. Please use yyyy-MM.")
        }
    }

    private fun viewExpensesForPeriod() {
        try {
            print("Enter start date (yyyy-MM-dd): ")
            val startDateString = scanner.nextLine()
            val startDate = BudgetItem.parseDate(startDateString)
            print("Enter end date (yyyy-MM-dd): ")
            val endDateString = scanner.nextLine()
            val endDate = BudgetItem.parseDate(endDateString)
            val expenses = budgetService.getExpensesForPeriod(startDate, endDate)
            println("Expenses for the period from $startDate to $endDate: $expenses")
        } catch (e: IllegalArgumentException) {
            println("Error:${e.message}")
        } catch (e: Exception) {
            println("An unexpected error occurred: ${e.message}")
        }
    }

    private fun viewIncomeForPeriod() {
        try {
            print("Enter start date (yyyy-MM-dd): ")
            val startDateString = scanner.nextLine()
            val startDate = BudgetItem.parseDate(startDateString)
            print("Enter end date (yyyy-MM-dd): ")
            val endDateString = scanner.nextLine()
            val endDate = BudgetItem.parseDate(endDateString)
            val expenses = budgetService.getIncomeForPeriod(startDate, endDate)
            println("Expenses for the period from $startDate to $endDate: $expenses")
        } catch (e: IllegalArgumentException) {
            println("Error:${e.message}")
        } catch (e: Exception) {
            println("An unexpected error occurred: ${e.message}")
        }
    }
}