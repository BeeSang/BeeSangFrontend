package com.example.beesang.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.beesang.composes.lecture.LectureCompose
import com.example.beesang.ui.theme.BeeSangTheme

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
                        onCardTapped = { week -> onCardTapped(week)},
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

    private fun onCardTapped(week: Int) {
        val intent = Intent(this, ChapterActivity::class.java)
        intent.putExtra("week", week)
        startActivity(intent)
    }
}