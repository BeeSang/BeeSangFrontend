package com.example.beesang.retrofit.request

data class UserRegisterRequest(
    val schoolName: String,
    val studentId: String,
    val userEmail: String,
    val password: String,
    val username: String,
)