package com.example.beesang.retrofit

import com.example.beesang.retrofit.request.UserPostDto
import com.example.beesang.retrofit.response.UserInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface BeesangAPI {

    @GET("user/info")
    fun getUserInfo(): Call<UserInfo>

    @POST("user/info")
    fun postUserInfo3(@Body jsonParams: UserPostDto): Call<UserInfo>
}