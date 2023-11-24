package com.example.beesang.composes.game

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.beesang.R
import com.example.beesang.composes.FarmBackground
import com.example.beesang.retrofit.getUserInfo
import com.example.beesang.retrofit.growCrops
import com.example.beesang.retrofit.readFarm
import com.example.beesang.retrofit.response.FarmReadResponse
import com.example.beesang.retrofit.response.FarmUserInfoResponse
import com.google.relay.compose.BoxScopeInstance.boxAlign
import com.google.relay.compose.BoxScopeInstanceImpl.align
import com.google.relay.compose.ColumnScopeInstance.boxAlign
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.tappable
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
    bg: Int,
    farmType: String
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

            if(farmType == "TOMATO" || farmType == "SWEET_POTATO") {
                val result2 = remember { mutableStateOf<FarmReadResponse?>(null) }
                scope.launch { result2.value = readFarm(applicationContext, farmType) }

                result2.value?.let {
                    Row(
                        modifier = modifier
                            .align(Alignment.BottomCenter)
                            .offset(
                                x = 0.0.dp,
                                y = 220.0.dp
                            )
                            .fillMaxWidth(1.0f)
                            .requiredHeight(159.0.dp)
                            .padding(start = 40.0.dp, end = 40.0.dp)
                    ) {
                        Crops(
                            modifier.offset(x = 0.0.dp, y = getOffset(it.crops1)),
                            crops = it.crops1,
                            farmType = farmType,
                            farmId = it.farmId)
                        Spacer(Modifier.weight(1.0f))
                        Crops(
                            modifier.offset(x = 0.0.dp, y = getOffset(it.crops2)),
                            crops = it.crops2,
                            farmType = farmType,
                            farmId = it.farmId)
                        Spacer(Modifier.weight(1.0f))
                        Crops(
                            modifier.offset(x = 0.0.dp, y = getOffset(it.crops3)),
                            crops = it.crops3,
                            farmType = farmType,
                            farmId = it.farmId)
                    }
                }
            }

            if(farmType == "MANGO" || farmType == "LETTUCE") {

            }

            //뒤로가기 버튼을 위한 공간.. activity 백 하면 가장 좋은데..
        }
    }
}

@Composable
fun Crops(
    modifier: Modifier = Modifier,
    farmId: Long,
    farmType: String,
    crops: Int
) {
    RelayImage(
        image = painterResource(getFarmImage(crops, farmType)),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .tappable(onTap = { /*버튼 생성*/ })
            .requiredWidth(44.0.dp)
            .requiredHeight(getHeight(crops))
        //요청 보내고 activity 새로고침
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

fun getFarmImage(count: Int, farmType: String): Int {
    if("TOMATO" == farmType) {
        if(count == 1) return R.drawable.ingame_tomato_tomato1
        if(count == 2) return R.drawable.ingame_tomato_tomato2
        if(count == 3) return R.drawable.ingame_tomato_tomato3
    }
    if("SWEET_POTATO" == farmType) {
        if(count == 1) return R.drawable.ingame_sweet_potato_sweet_potato1
        if(count == 2) return R.drawable.ingame_sweet_potato_sweet_potato2
        if(count == 3) return R.drawable.ingame_sweet_potato_sweet_potato3
    }

    return 0
}

fun getHeight(count: Int): Dp {
    if(count == 1) return 46.0.dp
    if(count == 2) return 96.0.dp
    if(count == 3) return 159.0.dp
    return 46.0.dp
}

fun getOffset(count: Int): Dp {
    if(count == 1) return 113.0.dp
    if(count == 2) return 63.0.dp
    if(count == 3) return 0.0.dp
    return 0.0.dp
}