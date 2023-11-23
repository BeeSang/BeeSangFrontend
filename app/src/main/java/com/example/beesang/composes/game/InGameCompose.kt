package com.example.beesang.composes.game

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.beesang.R
import com.example.beesang.composes.FarmBackground
import com.example.beesang.retrofit.getUserInfo
import com.example.beesang.retrofit.response.FarmUserInfoResponse
import com.google.relay.compose.ColumnScopeInstance.boxAlign
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * In game tomato screen V1
 *
 * This composable was generated from the UI Package 'ingame_tomato'.
 * Generated code; do not edit directly
 */
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun InGameCompose(
    modifier: Modifier = Modifier,
    applicationContext: Context,
    bg: Int
) {
    InGameTopLevel(modifier = modifier) {
        FarmBackground(bg = bg)
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
        }
//        Crops(
//            modifier = Modifier.boxAlign(
//                alignment = Alignment.TopStart,
//                offset = DpOffset(
//                    x = 65.0.dp,
//                    y = 436.0.dp
//                )
//            ),
//            crops = R.drawable.ingame_tomato_tomato1
//        )
    }
}

@Composable
fun Crops(
    modifier: Modifier = Modifier,
    crops: Int
) {
    RelayImage(
        image = painterResource(crops),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxHeight(1.0f)
            .fillMaxWidth(1.0f)
    )
}

@Composable
fun InGameTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 223,
            green = 255,
            blue = 253
        ),
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}