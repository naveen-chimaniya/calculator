package com.example.calculatorassignment.util;

import java.lang.Exception
import java.lang.StringBuilder
import java.util.*


public class Arithmetic {
//    - M (*) > A(+) > D(/) > S(-). H
    var opss = charArrayOf('*', '+', '/', '-')
    var precedence = intArrayOf(0, 1, 2, 3)

    private fun isOperator(t: Char): Boolean {
        var i: Int = 0
        return opss.contains(t)
//        while (i < opss.size) {
//            if (t == opss[i]) return true
//            i++
//        }
//        return false
    }

    fun evaluate(expression: String): Float {
        return try {
            val tokens = expression.toCharArray()
            val values: Stack<Float> = Stack<Float>()
            val ops: Stack<Char> = Stack<Char>()
            var i = 0
            while (i < tokens.size) {
                if (tokens[i] == ' ') {
                    i++
                    continue
                }
                if (!isOperator(tokens[i])) {
                    val s = StringBuilder()
                    while (i < tokens.size && tokens[i] != ' ' && !isOperator(tokens[i])) s.append(
                        tokens[i++]
                    )
                    values.push(s.toString().toFloat())
                } else if (isOperator(tokens[i])) {
                    while (!ops.empty() && hasPrecedence(
                            tokens[i],
                            ops.peek()
                        )
                    ) values.push(applyOp(ops.pop(), values.pop(), values.pop()))
                    ops.push(tokens[i])
                }
                i++
            }
            while (!ops.empty()) values.push(applyOp(ops.pop(), values.pop(), values.pop()))
            values.pop()
        } catch (ee: Exception) {
            (-1).toFloat()
        }
    }

   private fun hasPrecedence(op1: Char, op2: Char): Boolean {
        val op1p: Int = getPrecedence(op1)
        val op2p: Int = getPrecedence(op2)
        return op2p <= op1p
    }

   private fun applyOp(op: Char, b: Float, a: Float): Float {
        when (op) {
            '+' -> return a + b
            '-' -> return a - b
            '*' -> return a * b
            '/' -> return a / b
        }
        return 0f
    }

   private fun getPrecedence(c: Char): Int {
        return precedence[opss.indexOf(c)]
    }


}