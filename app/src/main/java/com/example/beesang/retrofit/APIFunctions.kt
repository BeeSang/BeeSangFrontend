package com.example.beesang.retrofit

import android.content.Context
import android.util.Log
import com.example.beesang.retrofit.request.FarmHarvestRequest
import com.example.beesang.retrofit.request.FarmUpdateRequest
import com.example.beesang.retrofit.response.AssignmentReadAllResponse
import com.example.beesang.retrofit.response.FarmReadResponse
import com.example.beesang.retrofit.response.FarmUpdateResponse
import com.example.beesang.retrofit.response.FarmUserInfoResponse
import com.example.beesang.retrofit.response.MyAssignmentReadResponse
import okhttp3.MultipartBody
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

suspend fun growCrops(applicationContext: Context, crops1: Int, crops2: Int, crops3: Int, farmId: Long): FarmUpdateResponse = suspendCoroutine {
    val token = TokenStorage.getToken(applicationContext)
    val data = FarmUpdateRequest(crops1, crops2, crops3)
    val call = ApiObject.getRetrofitService.farmGrowRequest(farmId, data, "Bearer $token")
    call.enqueue(object : Callback<FarmUpdateResponse> {
        override fun onResponse(call: Call<FarmUpdateResponse>, response: Response<FarmUpdateResponse>) {
            if(response.isSuccessful) {
                val responseBody = response.body()!!
                it.resume(responseBody)
            } else {
//                it.resume()
            }
        }
        override fun onFailure(call: Call<FarmUpdateResponse>, t: Throwable) {
            Log.e("Error", t.toString())
        }
    })
}

suspend fun harvestCrops(applicationContext: Context, crops1: Int, crops2: Int, crops3: Int, harvestCount:Int, farmId: Long): FarmUpdateResponse = suspendCoroutine {
    val token = TokenStorage.getToken(applicationContext)
    val data = FarmHarvestRequest(crops1, crops2, crops3, harvestCount)
    val call = ApiObject.getRetrofitService.farmHarvestRequest(farmId, data, "Bearer $token")
    call.enqueue(object : Callback<FarmUpdateResponse> {
        override fun onResponse(call: Call<FarmUpdateResponse>, response: Response<FarmUpdateResponse>) {
            if(response.isSuccessful) {
                val responseBody = response.body()!!
                it.resume(responseBody)
            } else {
//                it.resume()
            }
        }
        override fun onFailure(call: Call<FarmUpdateResponse>, t: Throwable) {
            Log.e("Error", t.toString())
        }
    })
}

suspend fun getAssignments(): List<AssignmentReadAllResponse> = suspendCoroutine {
    val call = ApiObject.getRetrofitService.assignmentReadAllRequest()
    call.enqueue(object : Callback<List<AssignmentReadAllResponse>> {
        override fun onResponse(call: Call<List<AssignmentReadAllResponse>>, response: Response<List<AssignmentReadAllResponse>>) {
            if (response.isSuccessful) {
                val responseBody = response.body()!!
                it.resume(responseBody)
            } else {
//                it.resume()
            }
        }

        override fun onFailure(call: Call<List<AssignmentReadAllResponse>>, t: Throwable) {
            Log.e("Error", t.toString())
        }
    })
}

suspend fun uploadAssignmentImage(applicationContext: Context, body: MultipartBody.Part, assignmentId: Long) = suspendCoroutine {
    val token = TokenStorage.getToken(applicationContext)
    val call = ApiObject.getRetrofitService.uploadAssignmentImage("Bearer $token", assignmentId, body)
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

suspend fun myAssignmentRead(applicationContext: Context, assignmentId: Long): MyAssignmentReadResponse = suspendCoroutine {
    val token = TokenStorage.getToken(applicationContext)
    val call = ApiObject.getRetrofitService.myAssignmentReadRequest(assignmentId, "Bearer $token")
    call.enqueue(object : Callback<MyAssignmentReadResponse> {
        override fun onResponse(call: Call<MyAssignmentReadResponse>, response: Response<MyAssignmentReadResponse>) {
            if(response.isSuccessful) {
                val responseBody = response.body()!!
                it.resume(responseBody)
            } else {
//                it.resume()
            }
        }
        override fun onFailure(call: Call<MyAssignmentReadResponse>, t: Throwable) {
            Log.e("Error", t.toString())
        }
    })
}