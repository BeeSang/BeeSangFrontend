package com.example.beesang.retrofit

import com.example.beesang.retrofit.request.FarmHarvestRequest
import com.example.beesang.retrofit.request.FarmUpdateRequest
import com.example.beesang.retrofit.request.UserLoginRequest
import com.example.beesang.retrofit.request.UserRegisterRequest
import com.example.beesang.retrofit.response.ChapterReadResponse
import com.example.beesang.retrofit.response.FarmReadResponse
import com.example.beesang.retrofit.response.FarmUpdateResponse
import com.example.beesang.retrofit.response.FarmUserInfoResponse
import com.example.beesang.retrofit.response.LectureReadResponse
import com.example.beesang.retrofit.response.QuizReadResponse
import com.example.beesang.retrofit.response.UserLoginResponse
import com.example.beesang.retrofit.response.UserRegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

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

    // GAME
    @GET("api/farm/user")
    fun gameUserInfoRequest(@Header("Authorization") token: String): Call<FarmUserInfoResponse>

    @GET("api/farm/read")
    fun farmReadRequest(@Query("farmType") farmType: String, @Header("Authorization") token: String): Call<FarmReadResponse>

    @POST("api/farm/grow/{farmId}")
    fun farmGrowRequest(@Path(value = "farmId") farmId: Long, @Body jsonParams: FarmUpdateRequest, @Header("Authorization") token: String): Call<FarmUpdateResponse>

    @POST("api/farm/harvest/{farmId}")
    fun farmHarvestRequest(@Path(value = "farmId") farmId: Long, @Body jsonParams: FarmHarvestRequest, @Header("Authorization") token: String): Call<FarmUpdateResponse>
}