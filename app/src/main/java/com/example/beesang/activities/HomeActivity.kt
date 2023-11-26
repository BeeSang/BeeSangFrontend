package com.example.beesang.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.beesang.composes.home.HomeCompose
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
                        onGameBtnTapped = { onGameBtnTapped() },
                        onAssignBtnTapped = { onAssignBtnTapped() },
                        onMyPageBtnTapped = { onMyPageBtnTapped() },
                        onLogoutBtnTapped = { logoutBtnTapped() }
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

    private fun onGameBtnTapped() {
        Intent(this, GameActivity::class.java).apply {
            startActivity(this)
        }
    }

    private fun onAssignBtnTapped() {
        Intent(this, AssignmentActivity::class.java).apply {
            startActivity(this)
        }
    }

    private fun onMyPageBtnTapped() {
        Intent(this, MyPageActivity::class.java).apply {
            startActivity(this)
        }
    }

    private fun logoutBtnTapped() {
        finish()
    }
}