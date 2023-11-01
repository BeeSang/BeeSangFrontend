package com.example.beesang.composes.lecture

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.nfc.Tag
import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beesang.composes.NavigationBar
import com.example.beesang.composes.TopLevel
import com.example.beesang.composes.layout.BackgroundImg
import com.example.beesang.login.notoSansKR
import com.example.beesang.retrofit.ApiObject
import com.example.beesang.retrofit.response.ChapterReadResponse
import com.example.beesang.retrofit.response.LectureReadResponse
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayText
import com.google.relay.compose.relayBorder
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
            Text(
                text = week.toString() + "주차:" + title,
                fontSize = 24.0.sp,
                fontWeight = FontWeight(700.0.toInt()),
                fontFamily = notoSansKR,
                color = Color(
                    alpha = 255,
                    red = 109,
                    green = 85,
                    blue = 0
                ),
                lineHeight = 24.0.sp,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth(1.0f)
                    .padding(start = 20.0.dp, end = 20.0.dp)
            )
//            Spacer(modifier = Modifier.height(50.0.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(1.0f)
            ) {
                TextButton(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .drawBehind {
                            val strokeWidth = 2.0f
                            val y = size.height - strokeWidth / 2

                            drawLine(
                                color = Color(
                                    alpha = 255,
                                    red = 255,
                                    green = 198,
                                    blue = 0
                                ),
                                Offset(0f, y),
                                Offset(size.width, y),
                                strokeWidth * 5
                            )
                        }
                ) {
                    Text(
                        text = "학습 하기",
                        fontSize = 20.0.sp,
                        fontWeight = FontWeight(700.0.toInt()),
                        fontFamily = notoSansKR,
                        color = Color(
                            alpha = 255,
                            red = 255,
                            green = 198,
                            blue = 0
                        ),
                        lineHeight = 20.0.sp,
                    )
                }
                TextButton(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth(1.0f)
                        .drawBehind {
                            val strokeWidth = 2.0f
                            val y = size.height - strokeWidth / 2

                            drawLine(
                                color = Color(
                                    alpha = 255,
                                    red = 205,
                                    green = 205,
                                    blue = 205
                                ),
                                Offset(0f, y),
                                Offset(size.width, y),
                                strokeWidth * 5
                            )
                        }
                ) {
                    Text(
                        text = "퀴즈 풀기",
                        fontSize = 20.0.sp,
                        fontWeight = FontWeight(700.0.toInt()),
                        fontFamily = notoSansKR,
                        color = Color(
                            alpha = 255,
                            red = 205,
                            green = 205,
                            blue = 205
                        ),
                        lineHeight = 20.0.sp,
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.0.dp))
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                val scope = CoroutineScope(Dispatchers.IO)
                val results = remember { mutableStateOf<List<LectureReadResponse>?>(null) }
                scope.launch { results.value = getLectureData(week) }

                ChapterTimeCard(time = 1, title = "기후발생의 발생과 원인", videoLink = "TEST")
                Spacer(modifier = Modifier.height(30.0.dp))
                ChapterTimeCard(time = 1, title = "기후발생의 발생과 원인", videoLink = "TEST")
                Spacer(modifier = Modifier.height(30.0.dp))
                ChapterTimeCard(time = 1, title = "기후발생의 발생과 원인", videoLink = "TEST")
                Spacer(modifier = Modifier.height(30.0.dp))
                ChapterTimeCard(time = 1, title = "기후발생의 발생과 원인", videoLink = "TEST")
                Spacer(modifier = Modifier.height(30.0.dp))
                ChapterTimeCard(time = 1, title = "기후발생의 발생과 원인", videoLink = "TEST")
                Spacer(modifier = Modifier.height(30.0.dp))


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
}

@Preview(widthDp = 430, heightDp = 927)
@Composable
private fun ChapterPreview() {
    MaterialTheme {
        RelayContainer {
            ChapterCompose(
                week = 1,
                title = "지구온난화로 인한 기후위기와 식량위기",
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            )
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