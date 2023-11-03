package com.example.beesang.retrofit

import com.example.beesang.retrofit.request.UserLoginRequest
import com.example.beesang.retrofit.request.UserRegisterRequest
import com.example.beesang.retrofit.response.ChapterReadResponse
import com.example.beesang.retrofit.response.LectureReadResponse
import com.example.beesang.retrofit.response.QuizReadResponse
import com.example.beesang.retrofit.response.UserLoginResponse
import com.example.beesang.retrofit.response.UserRegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BeesangAPI {

    @POST("user/login")
    fun userLoginRequest(@Body jsonParams: UserLoginRequest): Call<UserLoginResponse>

    @POST("user/register")
    fun userRegisterRequest(@Body jsonParams: UserRegisterRequest): Call<UserRegisterResponse>

    @GET("study/chapter/readAll")
    fun chapterReadRequest(): Call<List<ChapterReadResponse>>

    @GET("study/lecture/readAll/{chapterId}")
    fun lectureReadRequest(@Path(value = "chapterId") chapterId: Int): Call<List<LectureReadResponse>>

    @GET("study/quiz/readAll/{chapterId}")
    fun quizReadRequest(@Path(value = "chapterId") chapterId: Int): Call<List<QuizReadResponse>>
}