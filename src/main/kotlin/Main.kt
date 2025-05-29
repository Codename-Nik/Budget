package org.example

import org.example.model.Budget
import org.example.service.BudgetService
import org.example.ui.ConsoleUI

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val budget = Budget()
    val budgetService = BudgetService(budget)
    val ui = ConsoleUI(budgetService)
    ui.run()
}