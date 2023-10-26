package com.example.beesang.composes.lecture

import android.util.Log
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beesang.composes.NavigationBar
import com.example.beesang.composes.TopLevel
import com.example.beesang.composes.layout.BackgroundImg
import com.example.beesang.login.notoSansKR
import com.example.beesang.retrofit.ApiObject
import com.example.beesang.retrofit.response.ChapterReadResponse
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun LectureCompose(
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
                content = "강의듣기",
                fontSize = 34.0.sp,
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
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                val call = ApiObject.getRetrofitService.chapterReadRequest()
                call.enqueue(object : Callback<ChapterReadResponse> {
                    override fun onResponse(call: Call<ChapterReadResponse>, response: Response<ChapterReadResponse>) {
                        if(response.isSuccessful) {
                            Log.i("Response", "Success")
                            repeat(response.body()?.chapters?.size!!) {
                                Log.i("Response", response.body()?.chapters?.get(it)?.title.toString())
                            }
                        } else {
                            Log.i("ERROR!!!", response.code().toString())
                            Log.i("ERROR!!!", response.message().toString())
                        }
                    }
                    override fun onFailure(call: Call<ChapterReadResponse>, t: Throwable) {
                        Log.e("Error", t.toString())
                    }
                })
                Log.i("Response", "End")
                repeat(10) {
                    LectureWeekCard()
                    Spacer(modifier = Modifier.height(50.0.dp))
                }
            }
        }

    }
}

@Preview(widthDp = 430, heightDp = 927)
@Composable
private fun LecturePreview() {
    MaterialTheme {
        RelayContainer {
            LectureCompose(
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            )
        }
    }
}