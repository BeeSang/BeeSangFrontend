package com.example.beesang.retrofit

import com.example.beesang.retrofit.request.UserLoginRequest
import com.example.beesang.retrofit.request.UserRegisterRequest
import com.example.beesang.retrofit.response.ChapterReadResponse
import com.example.beesang.retrofit.response.UserLoginResponse
import com.example.beesang.retrofit.response.UserRegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface BeesangAPI {

//    @GET("user/info")
//    fun getUserInfo(): Call<UserLoginResponse>

    @POST("user/login")
    fun userLoginRequest(@Body jsonParams: UserLoginRequest): Call<UserLoginResponse>

    @POST("user/register")
    fun userRegisterRequest(@Body jsonParams: UserRegisterRequest): Call<UserRegisterResponse>

    @GET("study/chapter/readAll")
    fun chapterReadRequest(): Call<ChapterReadResponse>
}