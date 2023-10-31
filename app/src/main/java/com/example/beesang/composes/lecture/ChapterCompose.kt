package com.example.beesang.composes.lecture

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.nfc.Tag
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beesang.composes.NavigationBar
import com.example.beesang.composes.TopLevel
import com.example.beesang.composes.layout.BackgroundImg
import com.example.beesang.login.notoSansKR
import com.example.beesang.retrofit.ApiObject
import com.example.beesang.retrofit.response.ChapterReadResponse
import com.example.beesang.retrofit.response.LectureReadResponse
import com.google.relay.compose.RelayText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ChapterCompose(
    week: Int,
    title: String?,
    onBackBtnTapped: () -> Unit = {},
    onHomeBtnTapped: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    TopLevel(modifier = modifier) {
        BackgroundImg()
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            NavigationBar(
                onBackBtnTapped,
                onHomeBtnTapped
            )
            Spacer(modifier = Modifier.height(20.0.dp))
            RelayText(
                content = week.toString() + "주차:" + title,
                fontSize = 24.0.sp,
                fontWeight = FontWeight(700.0.toInt()),
                fontFamily = notoSansKR,
                color = Color(
                    alpha = 255,
                    red = 115,
                    green = 115,
                    blue = 115
                ),
                textAlign = TextAlign.Center,
                modifier = modifier.fillMaxWidth(1.0f)
            )
            Spacer(modifier = Modifier.height(50.0.dp))

            val scope = CoroutineScope(Dispatchers.IO)
            val results = remember { mutableStateOf<List<LectureReadResponse>?>(null) }
            scope.launch { results.value = getLectureData(week) }

            Log.d(TAG, "jasl;dkfjkl;asdjflk;asdjkl;fjaksdl;")
            results.value?.let {
                for(i in it.indices) {
                    Log.d("lecture", it[i].title)
//                    LectureWeekCard(onCardTapped, it[i].week, it[i].title)
//                    Spacer(modifier = Modifier.height(20.0.dp))
                }
            }
        }
    }
}

suspend fun getLectureData(chapterId: Int): List<LectureReadResponse> = suspendCoroutine {
    val call = ApiObject.getRetrofitService.lectureReadRequest(chapterId)
    call.enqueue(object : Callback<List<LectureReadResponse>> {
        override fun onResponse(call: Call<List<LectureReadResponse>>, response: Response<List<LectureReadResponse>>) {
            if(response.isSuccessful) {
                val responseBody = response.body()!!
                it.resume(responseBody)
            } else {
                it.resume(emptyList())
            }
        }
        override fun onFailure(call: Call<List<LectureReadResponse>>, t: Throwable) {
            Log.e("Error", t.toString())
            it.resume(emptyList())
        }
    })
}