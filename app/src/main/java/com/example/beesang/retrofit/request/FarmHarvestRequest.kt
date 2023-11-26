package com.example.beesang.retrofit.request

data class FarmHarvestRequest(
    val crops1: Int,
    val crops2: Int,
    val crops3: Int,
    val harvestCount: Int
)