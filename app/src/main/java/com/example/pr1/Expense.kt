package com.example.pr1

import java.text.SimpleDateFormat
import java.util.*

data class Expense(val amount: Double, val category: String, val date: Date) {
    fun displayInfo() {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        println("Expense: $amount | Category: $category | Date: ${dateFormat.format(date)}")
    }
}

class ExpenseManager {
    private val expenses = mutableListOf<Expense>()


    fun addExpense(amount: Double, category: String, date: Date) {
        expenses.add(Expense(amount, category, date))
    }

    fun showAllExpenses() {
        if (expenses.isEmpty()) {
            println("No expenses recorded.")
        } else {
            for (expense in expenses) {
                expense.displayInfo()
            }
        }
    }

    fun calculateTotalByCategory(): Map<String, Double> {
        val totalsByCategory = mutableMapOf<String, Double>()
        for (expense in expenses) {
            totalsByCategory[expense.category] = totalsByCategory.getOrDefault(expense.category, 0.0) + expense.amount
        }
        return totalsByCategory
    }
}
