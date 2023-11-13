package com.example.beesang.composes.game

import com.example.beesang.game2.notoSansKR

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
 * Game Screen2 V2
 *
 * This composable was generated from the UI Package 'game2'.
 * Generated code; do not edit directly
 */
@Composable
fun GameBoard(
    modifier: Modifier = Modifier,
    crops: String,
    bg: Int,
    onGameBoardTapped: (Int) -> Unit = {},
) {
    GameBoardTopLevel(modifier = modifier) {
        GameRoom(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
        ) {
            GameRoomBg(bg = bg)
            GameRoomBoard(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 110.0.dp,
                        y = 23.0.dp
                    )
                )
            ) {
                GameRoomBoardBg()
                GameRoomBoardTitle(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopCenter,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 15.0.dp
                        )
                    ),
                    crops = crops
                )
            }
        }
    }
}

//@Preview(widthDp = 375, heightDp = 812)
//@Composable
//private fun GameBoardPreview() {
//    MaterialTheme {
//        RelayContainer {
//            GameBoard(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
//        }
//    }
//}

@Composable
fun GameRoomBg(modifier: Modifier = Modifier, bg: Int) {
    RelayImage(
        image = painterResource(bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(333.0.dp).requiredHeight(235.0.dp)
    )
}

@Composable
fun GameRoomBoardBg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.game2_game_room_board_bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(114.0.dp).requiredHeight(35.0.dp)
    )
}

@Composable
fun GameRoomBoardTitle(modifier: Modifier = Modifier, crops: String) {
    RelayText(
        content = "$crops 농장",
        fontSize = 6.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.4479999542236328.em,
        fontWeight = FontWeight(700.0.toInt()),
        modifier = modifier
    )
}

@Composable
fun GameRoomBoard(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(114.0.dp).requiredHeight(35.0.dp)
    )
}

@Composable
fun GameRoom(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(333.0.dp).requiredHeight(235.0.dp)
    )
}

@Composable
fun GameBoardTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(220.0.dp)
    )
}
