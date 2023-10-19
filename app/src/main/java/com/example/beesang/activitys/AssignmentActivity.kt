package com.example.beesang.activitys

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.beesang.composes.assignment.AssignmentCompose
import com.example.beesang.composes.lecture.LectureCompose
import com.example.beesang.ui.theme.BeeSangTheme

class AssignmentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeeSangTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AssignmentCompose(
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