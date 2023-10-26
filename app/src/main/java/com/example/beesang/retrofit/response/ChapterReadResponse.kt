package com.example.beesang.retrofit.response

data class ChapterReadResponse (
    val chapters: List<ChapterInfo>
)

data class ChapterInfo (
    val week: Int,
    val title: String
)