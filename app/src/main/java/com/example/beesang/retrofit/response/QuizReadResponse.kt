package com.example.beesang.retrofit.response

data class QuizReadResponse (
    val time: Int,
    val title: String,
    val question: String,
    val description: String,
    val answer: Boolean,
)