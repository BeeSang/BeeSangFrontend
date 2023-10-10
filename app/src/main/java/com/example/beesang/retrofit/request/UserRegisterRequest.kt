package com.example.beesang.retrofit.request

data class UserRegisterRequest(
    val id: String,
    val password: String,
    val name: String,
    val school: String,
    val schoolId: String
)