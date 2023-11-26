package com.example.beesang.retrofit.response

data class AssignmentReadAllResponse (
    val assignmentId: Long,
    val week: Int,
    val title: String,
    val description: String,
)