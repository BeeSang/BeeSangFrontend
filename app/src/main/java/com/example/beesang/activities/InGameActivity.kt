package com.example.beesang.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.beesang.R
import com.example.beesang.composes.game.InGameCompose
import com.example.beesang.ui.theme.BeeSangTheme


class InGameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeeSangTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val bg = intent.getIntExtra("bg", 0)
                    var inGameBg = 0
                    var farmType = ""
                    if(bg == R.drawable.game2_game_room_bg) {
                        inGameBg = R.drawable.ingame_tomato_tomato_bg
                        farmType = "TOMATO"
                    }
                    if(bg == R.drawable.game2_game_room_bg2) {
                        inGameBg = R.drawable.ingame_mango_mango_bg
                        farmType = "MANGO"
                    }
                    if(bg == R.drawable.game2_game_room_bg3) {
                        inGameBg = R.drawable.ingame_lettuce_lettuce_bg
                        farmType = "LETTUCE"
                    }
                    if(bg == R.drawable.game2_game_room_bg4) {
                        inGameBg = R.drawable.ingame_sweet_potato_sweet_potato_bg
                        farmType = "SWEET_POTATO"
                    }

                    InGameCompose(
                        applicationContext = applicationContext,
                        bg = inGameBg,
                        farmType = farmType,
                        onBackButtonTapped = { onBackButtonTapped() },
                        refreshActivity = { refreshActivity() }
                    )
                }
            }
        }
    }

    private fun onBackButtonTapped() {
        finish()
    }
    private fun refreshActivity() {
        finish()
        overridePendingTransition(0, 0)
        val intent = intent
        startActivity(intent)
        overridePendingTransition(0, 0)
    }
}