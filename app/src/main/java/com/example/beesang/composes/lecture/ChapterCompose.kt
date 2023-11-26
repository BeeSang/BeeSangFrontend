package com.example.beesang.composes.lecture

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.nfc.Tag
import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.beesang.composes.lecture.board.LectureBoard
import com.example.beesang.login.notoSansKR
import com.example.beesang.retrofit.ApiObject
import com.example.beesang.retrofit.response.ChapterReadResponse
import com.example.beesang.retrofit.response.LectureReadResponse
import com.example.beesang.retrofit.response.QuizReadResponse
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
    onLectureBoardTapped: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TopLevel(modifier = modifier) {
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            var isColumnVisible by remember { mutableStateOf(true) }
            var color1: Color
            var color2: Color
            if(isColumnVisible) {
                color1 = Color(
                    alpha = 255,
                    red = 255,
                    green = 198,
                    blue = 0
                )
                color2 = Color(
                    alpha = 255,
                    red = 205,
                    green = 205,
                    blue = 205
                )
            } else {
                color1 = Color(
                    alpha = 255,
                    red = 205,
                    green = 205,
                    blue = 205
                )
                color2 = Color(
                    alpha = 255,
                    red = 255,
                    green = 198,
                    blue = 0
                )
            }

            RelayContainer(backgroundColor = Color(alpha = 255, red = 255, green = 251, blue = 238)) {
                NavigationBar(onBackBtnTapped, onHomeBtnTapped)
                Spacer(modifier = Modifier.height(10.0.dp))
                Text(
                    text = week.toString() + "주차: " + title,
                    fontSize = 18.0.sp,
                    fontWeight = FontWeight(700.0.toInt()),
                    fontFamily = notoSansKR,
                    color = Color(
                        alpha = 255,
                        red = 109,
                        green = 85,
                        blue = 0
                    ),
                    textAlign = TextAlign.Center,
                    lineHeight = 18.0.sp,
                    modifier = modifier
                        .fillMaxWidth(1.0f)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1.0f)
                ) {
                    TextButton(
                        onClick = {isColumnVisible = true},
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .drawBehind {
                                val strokeWidth = 2.0f
                                val y = size.height - strokeWidth / 2

                                drawLine(
                                    color = color1,
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
                            color = color1,
                            lineHeight = 20.0.sp,
                        )
                    }
                    TextButton(
                        onClick = {isColumnVisible = false},
                        modifier = Modifier
                            .fillMaxWidth(1.0f)
                            .drawBehind {
                                val strokeWidth = 2.0f
                                val y = size.height - strokeWidth / 2

                                drawLine(
                                    color = color2,
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
                            color = color2,
                            lineHeight = 20.0.sp,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.0.dp))
            if(isColumnVisible) { //LECTURE
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                ) {
                    val scope = CoroutineScope(Dispatchers.IO)
                    val results = remember { mutableStateOf<List<LectureReadResponse>?>(null) }
                    scope.launch { results.value = getLectureData(week) }

                    results.value?.let {
                        for(i in it.indices) {
                            Log.d("lecture", it[i].title)
                            LectureBoard(time = it[i].time, title = it[i].title, videoLink = it[i].videoLink, onLectureBoardTapped = onLectureBoardTapped)
                            Spacer(modifier = Modifier.height(20.0.dp))
                        }
                    }
                }
            } else {
                //Quiz
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                ) {
                    val scope = CoroutineScope(Dispatchers.IO)
                    val results = remember { mutableStateOf<List<QuizReadResponse>?>(null) }
                    scope.launch { results.value = getQuizData(week) }

                    results.value?.let {
                        for(i in it.indices) {
                            QuizTimeCard(time = it[i].time, title = it[i].title, question = it[i].question, description = it[i].description, answer = it[i].answer)
                            Spacer(modifier = Modifier.height(30.0.dp))
                        }
                    }
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

suspend fun getQuizData(chapterId: Int): List<QuizReadResponse> = suspendCoroutine {
    val call = ApiObject.getRetrofitService.quizReadRequest(chapterId)
    call.enqueue(object : Callback<List<QuizReadResponse>> {
        override fun onResponse(call: Call<List<QuizReadResponse>>, response: Response<List<QuizReadResponse>>) {
            if(response.isSuccessful) {
                val responseBody = response.body()!!
                it.resume(responseBody)
            } else {
                it.resume(emptyList())
            }
        }
        override fun onFailure(call: Call<List<QuizReadResponse>>, t: Throwable) {
            Log.e("Error", t.toString())
            it.resume(emptyList())
        }
    })
}