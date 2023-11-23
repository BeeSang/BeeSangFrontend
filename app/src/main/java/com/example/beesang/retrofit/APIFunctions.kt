package com.example.beesang.retrofit

import android.content.Context
import android.util.Log
import com.example.beesang.retrofit.response.FarmUserInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun getUserInfo(applicationContext: Context): FarmUserInfoResponse = suspendCoroutine {
    val token = TokenStorage.getToken(applicationContext)
    val call = ApiObject.getRetrofitService.gameUserInfoRequest("Bearer $token")
    call.enqueue(object : Callback<FarmUserInfoResponse> {
        override fun onResponse(call: Call<FarmUserInfoResponse>, response: Response<FarmUserInfoResponse>) {
            if(response.isSuccessful) {
                val responseBody = response.body()!!
                it.resume(responseBody)
            } else {
//                it.resume()
            }
        }
        override fun onFailure(call: Call<FarmUserInfoResponse>, t: Throwable) {
            Log.e("Error", t.toString())
        }
    })
}