package com.example.beesang.activitys

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.beesang.composes.lecture.LectureCompose
import com.example.beesang.home.Home
import com.example.beesang.retrofit.ApiObject
import com.example.beesang.retrofit.response.ChapterReadResponse
import com.example.beesang.ui.theme.BeeSangTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LectureActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeeSangTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LectureCompose(
                        onBackBtnTapped = { onBackBtnTapped() },
                        onHomeBtnTapped = { onHomeBtnTapped() }
                    )
                }
            }
        }
    }

    private fun onBackBtnTapped() {
        Intent(this, HomeActivity::class.java).apply {
            startActivity(this)
        }
    }
    private fun onHomeBtnTapped() {
        Intent(this, HomeActivity::class.java).apply {
            startActivity(this)
        }
    }
}