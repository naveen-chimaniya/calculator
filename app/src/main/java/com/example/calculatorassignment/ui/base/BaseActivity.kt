package com.example.calculatorassignment.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    lateinit var binding: T

    fun setBindingView(layoutId: Int) {
        binding = DataBindingUtil.setContentView(this, layoutId)
    }

}