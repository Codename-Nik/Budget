package org.example.model

class Budget {

    private val items: MutableList<BudgetItem> = mutableListOf()

    fun addItem(item: BudgetItem) {
        items.add(item)
    }

    fun getItems(): List<BudgetItem> {
        return items.toList()
    }
}