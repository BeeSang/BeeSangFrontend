package com.example.beesang.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.beesang.composes.lecture.ChapterCompose
import com.example.beesang.ui.theme.BeeSangTheme

class ChapterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeeSangTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val week = intent.getIntExtra("week", 0)
                    val title = intent.getStringExtra("title")

                    ChapterCompose(
                        week,
                        title
                    )
                }
            }
        }
    }
}