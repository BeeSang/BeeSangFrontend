package com.example.beesang.retrofit

import android.content.Context
import android.util.Log
import com.example.beesang.retrofit.request.FarmUpdateRequest
import com.example.beesang.retrofit.response.FarmReadResponse
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

suspend fun readFarm(applicationContext: Context, farmType: String): FarmReadResponse = suspendCoroutine {
    val token = TokenStorage.getToken(applicationContext)
    val call = ApiObject.getRetrofitService.farmReadRequest(farmType, "Bearer $token")
    call.enqueue(object : Callback<FarmReadResponse> {
        override fun onResponse(call: Call<FarmReadResponse>, response: Response<FarmReadResponse>) {
            if(response.isSuccessful) {
                val responseBody = response.body()!!
                it.resume(responseBody)
            } else {
//                it.resume()
            }
        }
        override fun onFailure(call: Call<FarmReadResponse>, t: Throwable) {
            Log.e("Error", t.toString())
        }
    })
}

suspend fun growCrops(applicationContext: Context, crops1: Int, crops2: Int, crops3: Int,farmId: Int): Unit = suspendCoroutine {
    val token = TokenStorage.getToken(applicationContext)
    val data = FarmUpdateRequest(crops1, crops2, crops3)
    val call = ApiObject.getRetrofitService.farmGrowRequest(farmId, data, "Bearer $token")
    call.enqueue(object : Callback<Unit> {
        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
            if(response.isSuccessful) {
                val responseBody = response.body()!!
                it.resume(responseBody)
            } else {
//                it.resume()
            }
        }
        override fun onFailure(call: Call<Unit>, t: Throwable) {
            Log.e("Error", t.toString())
        }
    })
}

suspend fun harvestCrops(applicationContext: Context, crops1: Int, crops2: Int, crops3: Int,farmId: Int): Unit = suspendCoroutine {
    val token = TokenStorage.getToken(applicationContext)
    val data = FarmUpdateRequest(crops1, crops2, crops3)
    val call = ApiObject.getRetrofitService.farmHarvestRequest(farmId, data, "Bearer $token")
    call.enqueue(object : Callback<Unit> {
        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
            if(response.isSuccessful) {
                val responseBody = response.body()!!
                it.resume(responseBody)
            } else {
//                it.resume()
            }
        }
        override fun onFailure(call: Call<Unit>, t: Throwable) {
            Log.e("Error", t.toString())
        }
    })
}