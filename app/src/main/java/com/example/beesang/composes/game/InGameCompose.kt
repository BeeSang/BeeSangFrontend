package com.example.beesang.composes.game

import GameBottomBar
import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.beesang.R
import com.example.beesang.composes.BackBtn
import com.example.beesang.composes.FarmBackground
import com.example.beesang.composes.game.buttons.MainButtonCompose
import com.example.beesang.composes.game.buttons.SecondButtonCompose
import com.example.beesang.composes.game.buttons.ThirdButtonCompose
import com.example.beesang.retrofit.getUserInfo
import com.example.beesang.retrofit.growCrops
import com.example.beesang.retrofit.harvestCrops
import com.example.beesang.retrofit.readFarm
import com.example.beesang.retrofit.response.FarmReadResponse
import com.example.beesang.retrofit.response.FarmUpdateResponse
import com.example.beesang.retrofit.response.FarmUserInfoResponse
import com.example.beesang.retrofit.response.UserReadResponse
import com.example.beesang.retrofit.userRead
import com.google.relay.compose.BoxScopeInstance.boxAlign
import com.google.relay.compose.BoxScopeInstance.scope
import com.google.relay.compose.BoxScopeInstanceImpl.align
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
    farmType: String,
    onBackButtonTapped: () -> Unit = {},
    refreshActivity: () -> Unit = {}
) {
    InGameTopLevel(modifier = modifier) {
        FarmBackground(bg = bg)
        Box {
            var coin by remember { mutableStateOf(0) }
            var bees by remember { mutableStateOf(0) }
            var level by remember { mutableStateOf(0) }

            val scope = CoroutineScope(Dispatchers.IO)
            var crops1 by remember { mutableStateOf(0) }
            var crops2 by remember { mutableStateOf(0) }
            var crops3 by remember { mutableStateOf(0) }
            var farmId by remember { mutableStateOf(0L) }

            var isFirstVisible by remember { mutableStateOf(false) }
            var isSecondVisible by remember { mutableStateOf(false) }
            var isThirdVisible by remember { mutableStateOf(false) }
            var selectedCrops by remember { mutableStateOf(0) }
            if (isFirstVisible) {
                MainButtonCompose(
                    modifier = Modifier
                        .offset(x = 0.0.dp, y = 220.0.dp),
                    onGrowBtnTapped = {
                        isFirstVisible = false
                        isSecondVisible = true
                    },
                    onHarvestBtnTapped = {
                        isFirstVisible = false
                        isThirdVisible = true
                    }
                )
            }
            val secondOK = remember { mutableStateOf<FarmUpdateResponse?>(null) }
            if(isSecondVisible) {
                SecondButtonCompose(
                    modifier = Modifier
                        .offset(x = 0.0.dp, y = 220.0.dp),
                    onNoBtnTapped = {
                        isSecondVisible = false
                        isFirstVisible = false
                    },
                    onOkBtnTapped = {
                        if(selectedCrops == 1) {
                            if(bees < 5) {
                                Toast.makeText(applicationContext, "벌이 부족해 식물을 키울 수 없습니다.", Toast.LENGTH_SHORT).show()
                                isSecondVisible = false
                                isFirstVisible = false
                            }
                            if(crops1 == 3) {
                                Toast.makeText(applicationContext, "식물을 더 이상 키울 수 없습니다.", Toast.LENGTH_SHORT).show()
                                isSecondVisible = false
                                isFirstVisible = false
                            }
                            if(crops1 < 3 && bees >= 5) {
                                scope.launch { secondOK.value = growCrops(applicationContext, crops1+1, crops2, crops3, farmId) }
                                refreshActivity()
                            }
                        }
                        if(selectedCrops == 2) {
                            if(bees < 5) {
                                Toast.makeText(applicationContext, "벌이 부족해 식물을 키울 수 없습니다.", Toast.LENGTH_SHORT).show()
                                isSecondVisible = false
                                isFirstVisible = false
                            }
                            if(crops2 == 3) {
                                Toast.makeText(applicationContext, "식물을 더 이상 키울 수 없습니다.", Toast.LENGTH_SHORT).show()
                                isSecondVisible = false
                                isFirstVisible = false
                            }
                            if(crops2 < 3 && bees >= 5) {
                                scope.launch { secondOK.value = growCrops(applicationContext, crops1, crops2+1, crops3, farmId) }
                                refreshActivity()
                            }
                        }
                        if(selectedCrops == 3) {
                            if(bees < 5) {
                                Toast.makeText(applicationContext, "벌이 부족해 식물을 키울 수 없습니다.", Toast.LENGTH_SHORT).show()
                                isSecondVisible = false
                                isFirstVisible = false
                            }
                            if(crops3 == 3) {
                                Toast.makeText(applicationContext, "식물을 더 이상 키울 수 없습니다.", Toast.LENGTH_SHORT).show()
                                isSecondVisible = false
                                isFirstVisible = false
                            }
                            if(crops3 < 3 && bees >= 5) {
                                scope.launch { secondOK.value = growCrops(applicationContext, crops1, crops2, crops3+1, farmId) }
                                refreshActivity()
                            }
                        }
                    }
                )
            }
            val thirdOk = remember { mutableStateOf<FarmUpdateResponse?>(null) }
            if(isThirdVisible) {
                ThirdButtonCompose(
                    modifier = Modifier
                        .offset(x = 0.0.dp, y = 220.0.dp),
                    total = 1,
                    onNoBtnTapped = {
                        isThirdVisible = false
                        isFirstVisible = false
                    },
                    onOkBtnTapped = {
                        //요청 보내기 -> 응답 받고 crops 값 바꿔주기
                        if(selectedCrops == 1) {
                            if(crops1 == 0) {
                                Toast.makeText(applicationContext, "재배할 수 없습니다.", Toast.LENGTH_SHORT).show()
                                isThirdVisible = false;
                                isFirstVisible = false
                            } else {
                                scope.launch { thirdOk.value = harvestCrops(applicationContext, 0, crops2, crops3, crops1, farmId) }
                                refreshActivity()
                            }
                        }
                        if(selectedCrops == 2) {
                            if(crops2 == 0) {
                                Toast.makeText(applicationContext, "재배할 수 없습니다.", Toast.LENGTH_SHORT).show()
                                isThirdVisible = false;
                                isFirstVisible = false
                            } else {
                                scope.launch { thirdOk.value = harvestCrops(applicationContext, crops1, 0, crops3, crops2, farmId) }
                                refreshActivity()
                            }
                        }
                        if(selectedCrops == 3) {
                            if(crops3 == 0) {
                                Toast.makeText(applicationContext, "재배할 수 없습니다.", Toast.LENGTH_SHORT).show()
                                isThirdVisible = false;
                                isFirstVisible = false
                            } else {
                                scope.launch { thirdOk.value = harvestCrops(applicationContext, crops1, crops2, 0, crops3, farmId) }
                                refreshActivity()
                            }
                        }
                    }
                )
            }

            Column(
                modifier = modifier
                    .padding(top = 16.dp)
            ) {
                val result = remember { mutableStateOf<FarmUserInfoResponse?>(null) }
                scope.launch { result.value = getUserInfo(applicationContext) }

                val results2 = remember { mutableStateOf<UserReadResponse?>(null) }
                scope.launch { results2.value = userRead(applicationContext) }

                var imgPath by remember { mutableStateOf("") }
                results2.value?.let {
                    imgPath = it.imgPath
                }

                result.value?.let {
                    coin = it.coin
                    bees = it.bees
//                    level = it.bees

                    GameHeader(
                        username = it.username,
                        coin = coin,
                        bees = bees,
                        level = it.level,
                        imgPath = imgPath
                    )
                }

                if (farmType == "TOMATO" || farmType == "SWEET_POTATO") {
                    val result2 = remember { mutableStateOf<FarmReadResponse?>(null) }
                    scope.launch { result2.value = readFarm(applicationContext, farmType) }

                    result2.value?.let {
                        crops1 = it.crops1
                        crops2 = it.crops2
                        crops3 = it.crops3
                        farmId = it.farmId

                        Row(
                            modifier = modifier
                                .offset(
                                    x = 0.0.dp,
                                    y = 220.0.dp
                                )
                                .fillMaxWidth(1.0f)
                                .requiredHeight(159.0.dp)
                                .padding(start = 40.0.dp, end = 40.0.dp)
                        ) {
                            Crops(
                                modifier
                                    .offset(x = 0.0.dp, y = getOffset(it.crops1))
                                    .tappable({
                                        isFirstVisible = true
                                        selectedCrops = 1
                                    }
                                    ),
                                crops = crops1,
                                farmType = farmType,
                                farmId = it.farmId)
                            Spacer(Modifier.weight(1.0f))
                            Crops(
                                modifier
                                    .offset(x = 0.0.dp, y = getOffset(it.crops2))
                                    .tappable({
                                        isFirstVisible = true
                                        selectedCrops = 2
                                    }
                                    ),
                                crops = crops2,
                                farmType = farmType,
                                farmId = it.farmId)
                            Spacer(Modifier.weight(1.0f))
                            Crops(
                                modifier
                                    .offset(x = 0.0.dp, y = getOffset(it.crops3))
                                    .tappable({
                                        isFirstVisible = true
                                        selectedCrops = 3
                                    }
                                    ),
                                crops = crops3,
                                farmType = farmType,
                                farmId = it.farmId)
                        }
                    }
                }

                if (farmType == "MANGO" || farmType == "LETTUCE") {

                }
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 20.dp, bottom = 20.dp)
        ) {
            BackBtn(
                onBackBtnTapped = { onBackButtonTapped() },
                modifier = Modifier
            )
            Spacer(Modifier.weight(1.0f))
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
            .requiredWidth(44.0.dp)
            .requiredHeight(getHeight(crops))
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
        if(count == 0) return R.drawable.ingame_tomato_tomato0
        if(count == 1) return R.drawable.ingame_tomato_tomato1
        if(count == 2) return R.drawable.ingame_tomato_tomato2
        if(count == 3) return R.drawable.ingame_tomato_tomato3
    }
    if("SWEET_POTATO" == farmType) {
        if(count == 0) return R.drawable.ingame_sweet_potato_sweet_potato0
        if(count == 1) return R.drawable.ingame_sweet_potato_sweet_potato1
        if(count == 2) return R.drawable.ingame_sweet_potato_sweet_potato2
        if(count == 3) return R.drawable.ingame_sweet_potato_sweet_potato3
    }

    return 0
}

fun getHeight(count: Int): Dp {
    if(count == 0) return 23.0.dp
    if(count == 1) return 46.0.dp
    if(count == 2) return 96.0.dp
    if(count == 3) return 159.0.dp
    return 46.0.dp
}

fun getOffset(count: Int): Dp {
    if(count == 0) return 136.0.dp
    if(count == 1) return 113.0.dp
    if(count == 2) return 63.0.dp
    if(count == 3) return 0.0.dp
    return 0.0.dp
}