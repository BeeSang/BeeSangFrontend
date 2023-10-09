package com.example.beesang.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiObject {
    val BASE_URL = "http://13.124.169.108:5000/"
    val gson = GsonBuilder().setLenient().create()

    private val getRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val getRetrofitService: BeesangAPI by lazy { getRetrofit.create(BeesangAPI::class.java) }
}