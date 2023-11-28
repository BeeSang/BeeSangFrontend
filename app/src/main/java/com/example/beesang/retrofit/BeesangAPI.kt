package com.example.beesang.retrofit

import com.example.beesang.retrofit.request.FarmHarvestRequest
import com.example.beesang.retrofit.request.FarmUpdateRequest
import com.example.beesang.retrofit.request.UserLoginRequest
import com.example.beesang.retrofit.request.UserRegisterRequest
import com.example.beesang.retrofit.response.AssignmentReadAllResponse
import com.example.beesang.retrofit.response.ChapterReadResponse
import com.example.beesang.retrofit.response.FarmReadResponse
import com.example.beesang.retrofit.response.FarmUpdateResponse
import com.example.beesang.retrofit.response.FarmUserInfoResponse
import com.example.beesang.retrofit.response.LectureReadResponse
import com.example.beesang.retrofit.response.MyAssignmentReadResponse
import com.example.beesang.retrofit.response.QuizReadResponse
import com.example.beesang.retrofit.response.UserLoginResponse
import com.example.beesang.retrofit.response.UserReadResponse
import com.example.beesang.retrofit.response.UserRegisterResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
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

    @GET("assignment/readAll")
    fun assignmentReadAllRequest(): Call<List<AssignmentReadAllResponse>>

    @Multipart
    @POST("assignment/upload/{assignmentId}")
    fun uploadAssignmentImage(@Header("Authorization") token: String, @Path(value = "assignmentId") assignmentId: Long, @Part file: MultipartBody.Part): Call<Unit>

    @GET("assignment/readMyAssignment/{assignmentId}")
    fun myAssignmentReadRequest(@Path(value = "assignmentId") assignmentId: Long, @Header("Authorization") token: String): Call<MyAssignmentReadResponse>

    @GET("user")
    fun userReadRequest(@Header("Authorization") token: String): Call<UserReadResponse>

    @Multipart
    @POST("user/profile/upload")
    fun userProfileUpload(@Header("Authorization") token: String, @Part file: MultipartBody.Part): Call<Unit>
}