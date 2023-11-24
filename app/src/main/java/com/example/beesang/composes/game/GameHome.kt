package com.example.beesang.composes.game

import GameBottomBar
import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.beesang.R
import com.example.beesang.composes.BackgroundImg
import com.example.beesang.composes.TopLevel
import com.example.beesang.composes.lecture.getChapterData
import com.example.beesang.register.Register
import com.example.beesang.retrofit.ApiObject
import com.example.beesang.retrofit.TokenStorage
import com.example.beesang.retrofit.getUserInfo
import com.example.beesang.retrofit.response.ChapterReadResponse
import com.example.beesang.retrofit.response.FarmUserInfoResponse
import com.google.relay.compose.BoxScopeInstanceImpl.align
import com.google.relay.compose.ColumnScopeInstance.boxAlign
import com.google.relay.compose.RelayContainer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun GameHome(
    modifier: Modifier = Modifier,
    applicationContext: Context,
    onGameBoardTapped: (Int) -> Unit = {},
    onCommunityBtnTapped: () -> Unit = {},
    onHomeBtnTapped: () -> Unit = {},
) {
    TopLevel {
        BackgroundImg()
        Column(
            modifier = modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            val scope = CoroutineScope(Dispatchers.IO)
            val result = remember { mutableStateOf<FarmUserInfoResponse?>(null) }
            scope.launch { result.value = getUserInfo(applicationContext) }

            result.value?.let {
                GameHeader(
                    username = it.username,
                    coin = it.coin,
                    bees = it.bees,
                    level = it.level
                )
            }
            Box {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                ) {
                    GameBoard(crops = "방울토마토", bg = R.drawable.game2_game_room_bg, onGameBoardTapped = onGameBoardTapped)
//                    GameBoard(crops = "망고", bg = R.drawable.game2_game_room_bg2, onGameBoardTapped = onGameBoardTapped)
//                    GameBoard(crops = "상추", bg = R.drawable.game2_game_room_bg3, onGameBoardTapped = onGameBoardTapped)
                    GameBoard(crops = "고구마", bg = R.drawable.game2_game_room_bg4, onGameBoardTapped = onGameBoardTapped)
                }
                GameBottomBar(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 20.dp),
                    onCommunityBtnTapped = { onCommunityBtnTapped() },
                    onHomeBtnTapped = { onHomeBtnTapped() }
                )
            }
//            GameBottomBar(
//                modifier = Modifier
//                    .align(Alignment.BottomCenter)
//                    .padding(bottom = 20.dp),
//                onCommunityBtnTapped = { onCommunityBtnTapped() },
//                onHomeBtnTapped = { onHomeBtnTapped() }
//            )
        }
    }
}

fun onBackBtnTapped() {

}