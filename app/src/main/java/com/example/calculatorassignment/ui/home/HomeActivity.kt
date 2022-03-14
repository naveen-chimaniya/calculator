package com.example.calculatorassignment.ui.home

import android.os.Bundle
import android.util.Log
import com.example.calculatorassignment.R
import com.example.calculatorassignment.databinding.ActivityMainBinding
import com.example.calculatorassignment.ui.base.BaseActivity
import com.example.calculatorassignment.util.Arithmetic
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityMainBinding>() {

    private var resultList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBindingView(R.layout.activity_main)
        initListener()
    }

    private fun initListener() {
        binding.apply {
            tvNum0.setOnClickListener { prepareExpression("0", false) }
            tvNum1.setOnClickListener { prepareExpression("1", false) }
            tvNum2.setOnClickListener { prepareExpression("2", false) }
            tvNum3.setOnClickListener { prepareExpression("3", false) }
            tvNum4.setOnClickListener { prepareExpression("4", false) }
            tvNum5.setOnClickListener { prepareExpression("5", false) }
            tvNum6.setOnClickListener { prepareExpression("6", false) }
            tvNum7.setOnClickListener { prepareExpression("7", false) }
            tvNum8.setOnClickListener { prepareExpression("8", false) }
            tvNum9.setOnClickListener { prepareExpression("9", false) }
            //Operators
            clear.setOnClickListener { prepareExpression("", true) }
            actionDivide.setOnClickListener { prepareExpression(" / ", false) }
            actionMultiply.setOnClickListener { prepareExpression(" * ", false) }
            actionMinus.setOnClickListener { prepareExpression(" - ", false) }
            actionAdd.setOnClickListener { prepareExpression(" + ", false) }
            actionBack.setOnClickListener {
                val expression = placeholder.text.toString()
                if (expression.isNotEmpty()) {
                    placeholder.text = expression.substring(0, expression.length - 1)
                }
            }
            actionEquals.setOnClickListener {
                val arithmetic = Arithmetic()
                Log.d("Result", arithmetic.evaluate(placeholder.text.toString().trim()).toString())
                answer.text = arithmetic.evaluate(placeholder.text.toString().trim()).toString()
                if (resultList.size < 10) {
                    resultList.add(
                        placeholder.text.toString().trim() +"= "+answer.text
                    )
                } else {
                    resultList.removeAt(0)
                    resultList.add(
                        placeholder.text.toString().trim() +"= "+answer.text
                    )
                }

            }

            tvHistory.setOnClickListener {
                if (resultList.isNotEmpty()) {
                    HistoryListFragment.createInstance(resultList)
                        .show(supportFragmentManager, "history")
                }
            }
        }
    }

    private fun prepareExpression(string: String, isClear: Boolean) {
        if (isClear) {
            binding.placeholder.text = ""
            binding.answer.text = ""
        } else {
            binding.placeholder.append(string)
        }
    }

}