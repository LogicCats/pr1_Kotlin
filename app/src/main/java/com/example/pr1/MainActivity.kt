package com.example.pr1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Создание менеджера расходов
        val expenseManager = ExpenseManager()

        // Добавление нескольких расходов
        expenseManager.addExpense(100.0, "Food", Date())
        expenseManager.addExpense(200.0, "Transport", Date())
        expenseManager.addExpense(50.0, "Entertainment", Date())

        // Получение TextView из layout
        val textView: TextView = findViewById(R.id.mainTextView)

        // Вывод всех расходов
        val expensesInfo = StringBuilder()
        for ((category, total) in expenseManager.calculateTotalByCategory()) {
            expensesInfo.append("Category: $category, Total: $total\n")
        }

        textView.text = expensesInfo.toString()
    }
}
