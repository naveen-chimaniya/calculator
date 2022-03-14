package com.example.calculatorassignment.data.repositories

import com.example.calculatorassignment.data.firebase.FirebaseSource
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val firebase: FirebaseSource
){
    fun login(email: String, password: String) = firebase.login(email, password)

    fun currentUser() = firebase.currentUser()

}