package com.example.beesang.composes.game

import com.example.beesang.game.notoSansKR

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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
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
 * Game Home Screen V1
 *
 * This composable was generated from the UI Package 'game'.
 * Generated code; do not edit directly
 */
@Composable
fun GameHeader(
    modifier: Modifier = Modifier,
    username: String,
    coin: Int,
    bees: Int,
    level: Int
) {
    TopLevel(modifier = modifier) {
        GameHeader(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 14.0.dp,
                    y = 10.0.dp
                )
            )
        ) {
            GameHeaderUserinfo {
                GameHeaderUserinfoTitle(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopCenter,
                        offset = DpOffset(
                            x = 22.5.dp,
                            y = 13.0.dp
                        )
                    ),
                    username = username
                )
                GameHeaderUserinfoLevel(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopCenter,
                        offset = DpOffset(
                            x = 27.0.dp,
                            y = 30.0.dp
                        )
                    ),
                    level = level
                )
                GameHeaderUserinfoBg()
            }
            GameHeaderBee(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 261.0.dp,
                        y = 17.0.dp
                    )
                )
            ) {
                GameHeaderBeeBg()
                GameHeaderBeeCoin(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 31.0.dp,
                            y = 2.0.dp
                        )
                    ),
                    bees = bees
                )
            }
            GameHeaderCoin(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 174.0.dp,
                        y = 9.0.dp
                    )
                )
            ) {
                GameHeaderCoinBg()
                GameHeaderCoinCoin(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 29.0.dp,
                            y = 10.0.dp
                        )
                    ),
                    coin = coin
                )
            }
        }
    }
}

//@Preview(widthDp = 375, heightDp = 812)
//@Composable
//private fun GamePreview() {
//    MaterialTheme {
//        RelayContainer {
//            GameHeader(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
//        }
//    }
//}

@Composable
fun GameHeaderUserinfoTitle(modifier: Modifier = Modifier, username: String) {
    RelayText(
        content = buildAnnotatedString {
            withStyle(style = SpanStyle(fontSize = 12.0.sp)) {
                append(username)
            }
            withStyle(
                style = SpanStyle(
                    color = Color(
                        alpha = 255,
                        red = 138,
                        green = 107,
                        blue = 80
                    ),
                    fontSize = 10.0.sp
                )
            ) {
                append("님의 농장")
            }
        },
        fontSize = 12.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 83,
            green = 38,
            blue = 0
        ),
        height = 1.4479999542236328.em,
        fontWeight = FontWeight(700.0.toInt()),
        modifier = modifier
    )
}

@Composable
fun GameHeaderUserinfoLevel(modifier: Modifier = Modifier, level: Int) {
    RelayText(
        content = "level $level",
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.4479999542236328.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(78.0.dp)
    )
}

@Composable
fun GameHeaderUserinfoBg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.game_game_header_userinfo_bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(168.0.dp).requiredHeight(69.0.dp)
    )
}

@Composable
fun GameHeaderUserinfo(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(168.0.dp).requiredHeight(69.0.dp)
    )
}

@Composable
fun GameHeaderBeeBg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.game_game_header_bee_bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(83.0.dp).requiredHeight(29.0.dp)
    )
}

@Composable
fun GameHeaderBeeCoin(modifier: Modifier = Modifier, bees: Int) {
    RelayText(
        content = "$bees",
        fontSize = 15.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 80,
            green = 61,
            blue = 38
        ),
        height = 1.4479999542236328.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(40.0.dp)
    )
}

@Composable
fun GameHeaderBee(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(83.0.dp).requiredHeight(29.0.dp)
    )
}

@Composable
fun GameHeaderCoinBg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.game_game_header_coin_bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(78.0.dp).requiredHeight(37.0.dp)
    )
}

@Composable
fun GameHeaderCoinCoin(modifier: Modifier = Modifier, coin: Int) {
    RelayText(
        content = "$coin",
        fontSize = 15.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 80,
            green = 61,
            blue = 38
        ),
        height = 1.4479999542236328.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(38.0.dp)
    )
}

@Composable
fun GameHeaderCoin(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(78.0.dp).requiredHeight(37.0.dp)
    )
}

@Composable
fun GameHeader(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(344.0.dp).requiredHeight(69.0.dp)
    )
}

@Composable
fun TopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(100.0.dp)
    )
}
