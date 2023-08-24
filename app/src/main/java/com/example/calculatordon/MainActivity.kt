package com.example.calculatordon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var number1: EditText
    private lateinit var number2: EditText
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        result = findViewById(R.id.result)

        val addButton: Button = findViewById(R.id.add_button)
        addButton.setOnClickListener { performOperation(Operation.ADD) }

        val subtractButton: Button = findViewById(R.id.subtract_button)
        subtractButton.setOnClickListener { performOperation(Operation.SUBTRACT) }

        val multiplyButton: Button = findViewById(R.id.multiply_button)
        multiplyButton.setOnClickListener { performOperation(Operation.MULTIPLY) }

        val divideButton: Button = findViewById(R.id.divide_button)
        divideButton.setOnClickListener { performOperation(Operation.DIVIDE) }
    }

    private fun performOperation(operation: Operation) {
        val num1 = number1.text.toString().toDouble()
        val num2 = number2.text.toString().toDouble()
        var resultValue: Double = 0.0

        when (operation) {
            Operation.ADD -> resultValue = num1 + num2
            Operation.SUBTRACT -> resultValue = num1 - num2
            Operation.MULTIPLY -> resultValue = num1 * num2
            Operation.DIVIDE -> {
                if (num2 != 0.0) {
                    resultValue = num1 / num2
                } else {
                    result.text = "Cannot divide by zero"
                    return
                }
            }
        }

        result.text = "Result: $resultValue"
    }

    enum class Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}
