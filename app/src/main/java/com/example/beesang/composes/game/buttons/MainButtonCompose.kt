package com.example.beesang.composes.game.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.beesang.R
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.tappable


@Composable
fun MainButtonCompose(
    modifier: Modifier = Modifier,
    onGrowBtnTapped: () -> Unit = {},
    onHarvestBtnTapped: () -> Unit = {},
) {
    MainButtonTopLevel(modifier = modifier,) {
        IngameButtons1Btns(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
        ) {
            GrowBtn(
                modifier = Modifier
                    .tappable(onTap = onGrowBtnTapped)
            )
            HarvestBtn(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 164.0.dp,
                        y = 0.0.dp
                    )
                )
                    .tappable(onTap = onHarvestBtnTapped)
            )
        }
    }
}

@Preview(widthDp = 375, heightDp = 812)
@Composable
private fun IngameButtons1Preview() {
    MaterialTheme {
        RelayContainer {
            MainButtonCompose(
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun GrowBtn(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.ingame_buttons1_grow_btn),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(142.0.dp).requiredHeight(92.7734375.dp)
    )
}

@Composable
fun HarvestBtn(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.ingame_buttons1_harvest_btn),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(142.0.dp).requiredHeight(92.7734375.dp)
    )
}

@Composable
fun IngameButtons1Btns(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(306.0.dp).requiredHeight(92.7734375.dp)
    )
}

@Composable
fun MainButtonTopLevel(
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
