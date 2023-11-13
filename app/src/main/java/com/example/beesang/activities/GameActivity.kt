package com.example.beesang.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.beesang.composes.game.GameHome
import com.example.beesang.composes.home.HomeCompose
import com.example.beesang.ui.theme.BeeSangTheme

class GameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeeSangTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameHome(
                        applicationContext = applicationContext,
                        onGameBoardTapped = { a -> gameBoardTapped(a) },
                        onCommunityBtnTapped = { onCommunityBtnTapped() },
                        onHomeBtnTapped = { onHomeBtnTapped() }
                    )
                }
            }
        }
    }

    private fun gameBoardTapped(a: Int) {
        //LectureActivity 참고
        val intent = Intent(this, ChapterActivity::class.java)
        intent.putExtra("a", a)
        startActivity(intent)
    }

    private fun onCommunityBtnTapped() {
        Intent(this, GameActivity::class.java).apply {
            startActivity(this)
        }
    }

    private fun onHomeBtnTapped() {
        Intent(this, HomeActivity::class.java).apply {
            startActivity(this)
        }
    }
}