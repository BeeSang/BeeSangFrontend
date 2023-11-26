package com.example.beesang.composes.home

import com.example.beesang.hometoday.notoSansKR

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.beesang.R
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText

/**
 * home_today V1
 *
 * This composable was generated from the UI Package 'home_today'.
 * Generated code; do not edit directly
 */
@Composable
fun HomeBoard(modifier: Modifier = Modifier) {
    HomeBoardTopLevel(modifier = modifier) {
        HomeTodayToday(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.dp,
                    y = 0.dp
                )
            )
        ) {
            HomeTodayTodayBg()
            HomeTodayTodayTitle(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 35.0.dp,
                        y = 106.0.dp
                    )
                )
            )
            HomeTodayTodayTitle1(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 35.0.dp,
                        y = 67.0.dp
                    )
                )
            )
            HomeTodayTodayHeader(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 38.0.dp,
                        y = 34.0.dp
                    )
                )
            )
        }
    }
}

@Preview(widthDp = 430, heightDp = 927)
@Composable
private fun HomeBoardPreview() {
    MaterialTheme {
        RelayContainer {
            HomeBoard(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
    }
}

@Composable
fun HomeTodayTodayBg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.home_today_home_today_today_bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(330.0.dp).requiredHeight(188.571533203125.dp)
    )
}

@Composable
fun HomeTodayTodayTitle(modifier: Modifier = Modifier) {
    RelayText(
        content = "남은 음식으로 요리하기",
        fontSize = 22.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 138,
            green = 107,
            blue = 80
        ),
        height = 1.4479999542236328.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(247.0.dp).requiredHeight(32.0.dp)
    )
}

@Composable
fun HomeTodayTodayTitle1(modifier: Modifier = Modifier) {
    RelayText(
        content = "푸드 업사이클링",
        fontSize = 27.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 83,
            green = 38,
            blue = 0
        ),
        height = 1.4480000248661746.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(247.0.dp).requiredHeight(39.0.dp)
    )
}

@Composable
fun HomeTodayTodayHeader(modifier: Modifier = Modifier) {
    RelayText(
        content = "오늘의 과제",
        fontSize = 15.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 162,
            green = 160,
            blue = 156
        ),
        height = 1.4479999542236328.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(91.0.dp).requiredHeight(20.0.dp)
    )
}

@Composable
fun HomeTodayToday(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(330.0.dp).requiredHeight(188.571533203125.dp)
    )
}

@Composable
fun HomeBoardTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(190.dp)
    )
}
