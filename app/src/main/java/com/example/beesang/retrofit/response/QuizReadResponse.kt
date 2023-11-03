package com.example.beesang.retrofit.response

data class QuizReadResponse (
    val week: Int,
    val title: String,
    val question: String,
    val answer: String,
)