package com.example.calexample.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.calexample.ui.state.CalUiState
import kotlin.math.pow

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalUiState())
        private set

    fun onButtonClick(btn: String) {
        state.equationText.let {
            when (btn) {
                "AC"          -> {
                    state = state.copy(
                        equationText = "",
                        resultText = "0"
                    )
                    return
                }

                "Enter"       -> {
                    state = state.copy(equationText = "$it ")
                    return
                }

                "C"           -> {
                    if (it.isNotEmpty()) {
                        state = state.copy(
                            equationText = it.substring(0, it.length - 1)
                        )
                    }
                    return
                }

                "+", "/", "*", "^" -> {
                    if (it.isNotEmpty()) {
                        state = state.copy(
                            equationText = "$it $btn"
                        )
                    }
                    return
                }

                "="           -> {
                    state = state.copy(
                        equationText = "$it ",
                        resultText = calculate(
                            state.equationText
                        ).toString().take(5)
                    )
                }

                else          -> {
                    state = state.copy(
                        equationText = it + btn
                    )
                }
            }
        }
    }

    fun calculate(expr: String): Double {
        if (expr.isEmpty()) throw IllegalArgumentException("Expression cannot be empty")
        val tokens = expr.split(' ').filter { it != "" }
        val stack = mutableListOf<Double>()
        for (token in tokens) {
            val d = token.toDoubleOrNull()
            if (d != null) {
                stack.add(d)
            } else if ((token.length > 1) || (token !in "+-*/^")) {
                throw IllegalArgumentException("$token is not a valid token")
            } else if (stack.size < 2) {
                throw IllegalArgumentException("Stack contains too few operands")
            } else {
                val d1 = stack.removeAt(stack.lastIndex)
                val d2 = stack.removeAt(stack.lastIndex)
                stack.add(
                    when (token) {
                        "+"  -> d2 + d1
                        "-"  -> d2 - d1
                        "*"  -> d2 * d1
                        "/"  -> d2 / d1
                        else -> d2.pow(d1)

                    }
                )
            }
        }
        return stack[0]
    }
}


