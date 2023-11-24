package com.example.beesang.retrofit.response

data class FarmReadResponse (
    val farmType: String,
    val farmId: Long,
    val crops1: Int,
    val crops2: Int,
    val crops3: Int
)