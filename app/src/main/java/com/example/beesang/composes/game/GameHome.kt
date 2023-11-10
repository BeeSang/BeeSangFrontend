package com.example.beesang.composes.game

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.beesang.composes.BackgroundImg
import com.example.beesang.composes.TopLevel
import com.example.beesang.register.Register
import com.google.relay.compose.RelayContainer

@Composable
fun GameHome(
    modifier: Modifier = Modifier
) {
    TopLevel {
        BackgroundImg()
        Column(
            modifier = modifier
                .padding(16.dp)
        ) {
            GameHeader()
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                GameBoard() //방울토마토, 이미지
                GameBoard() //망고
                GameBoard() //상추
                GameBoard() //고구마
            }

        }
    }
}

@Preview(widthDp = 430, heightDp = 932)
@Composable
private fun GameHomePreview() {
    MaterialTheme {
        RelayContainer {
            GameHome()
        }
    }
}