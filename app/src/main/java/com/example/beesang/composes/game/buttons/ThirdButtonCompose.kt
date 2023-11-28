package com.example.beesang.composes.game.buttons

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
import com.example.beesang.intgamebuttons3.notoSansKR
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.tappable

@Composable
fun ThirdButtonCompose(
    modifier: Modifier = Modifier,
    total: Int,
    onNoBtnTapped: () -> Unit = {},
    onOkBtnTapped: () -> Unit = {}
) {
    ThirdButtonTopLevel(modifier = modifier) {
        IngameButtons3Btns(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
        ) {
            IngameButtons3No(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 4.0.dp,
                        y = 110.0.dp
                    )
                )
                    .tappable(onTap = onNoBtnTapped)
            )
            IngameButtons3Ok(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 169.0.dp,
                        y = 110.0.dp
                    )
                )
                    .tappable(onTap = onOkBtnTapped)
            )
            IngameButtons3Title()
            IngameButtons3Content(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 6.0.dp,
                        y = 21.0.dp
                    )
                )
            )
        }
    }
}

@Composable
fun IngameButtons3No(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.intgame_buttons3_ingame_buttons3_no),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(125.0.dp).requiredHeight(42.0.dp)
    )
}

@Composable
fun IngameButtons3Ok(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.intgame_buttons3_ingame_buttons3_ok),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(125.0.dp).requiredHeight(42.0.dp)
    )
}

//@Composable
//fun IngameButtons3Title(modifier: Modifier = Modifier) {
//    RelayImage(
//        image = painterResource(R.drawable.intgame_buttons3_ingame_buttons3_title),
//        contentScale = ContentScale.Crop,
//        modifier = modifier.requiredWidth(298.0.dp).requiredHeight(90.0.dp)
//    )
//}

@Composable
fun IngameButtons3Title(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.intgame_buttons3_ingame_buttons3_title),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(298.0.dp).requiredHeight(90.0.dp)
    )
}

@Composable
fun IngameButtons3Content(modifier: Modifier = Modifier) {
    RelayText(
        content = "식물이 초기화되고\n 코인이 증가합니다.",
        fontSize = 16.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.4479999542236328.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(287.0.dp).requiredHeight(47.0.dp)
    )
}

@Composable
fun IngameButtons3Btns(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(298.0.dp).requiredHeight(152.0.dp)
    )
}

@Composable
fun ThirdButtonTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(155.0.dp)
    )
}
