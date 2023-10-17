package com.example.beesang.activitys

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.beesang.composes.home.HomeCompose
import com.example.beesang.home.Home
import com.example.beesang.ui.theme.BeeSangTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeeSangTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeCompose(
                        onLectureBtnTapped= { onLectureBtnTapped() },
                        onGameBtnTapped = {},
                        onAssignBtnTapped = {},
                        onMypageBtnTapped = {},
                        onLogoutBtnTapped = {}
                    )
                }
            }
        }
    }

    private fun onLectureBtnTapped() {
        Intent(this, LectureActivity::class.java).apply {
            startActivity(this)
        }
    }
}