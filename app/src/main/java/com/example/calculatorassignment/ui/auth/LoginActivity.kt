package com.example.calculatorassignment.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.calculatorassignment.R
import com.example.calculatorassignment.databinding.ActivityLoginxBinding
import com.example.calculatorassignment.ui.base.BaseActivity
import com.example.calculatorassignment.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivityX : BaseActivity<ActivityLoginxBinding>(),AuthListener{

    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBindingView(R.layout.activity_loginx)
        viewModel.authListener = this
        binding.buttonSignIn.setOnClickListener {
            viewModel.login(binding.etEmail.text.toString(),binding.etPasswords.text.toString())
        }
    }

    override fun onStarted() {
        binding.progressbar.visibility = View.VISIBLE
    }

    override fun onSuccess() {
        binding.progressbar.visibility = View.GONE
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun onFailure(message: String) {
        binding.progressbar.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}
