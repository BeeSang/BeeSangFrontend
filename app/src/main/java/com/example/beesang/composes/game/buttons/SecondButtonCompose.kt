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

@Composable
fun SecondButtonCompose(modifier: Modifier = Modifier) {
    SecondButtonTopLevel(modifier = modifier) {
        IngameButtons2Btns(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
        ) {
            IngameButtons2No(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 4.0.dp,
                        y = 110.0.dp
                    )
                )
            )
            IngameButtons2Ok(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 169.0.dp,
                        y = 110.0.dp
                    )
                )
            )
            IngameButtons2Title()
        }
    }
}

@Preview(widthDp = 375, heightDp = 812)
@Composable
private fun SecondButtonCompose2Preview() {
    MaterialTheme {
        RelayContainer {
            SecondButtonCompose(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
    }
}

@Composable
fun IngameButtons2No(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.ingame_buttons2_ingame_buttons2_no),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(125.0.dp).requiredHeight(42.0.dp)
    )
}

@Composable
fun IngameButtons2Ok(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.ingame_buttons2_ingame_buttons2_ok),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(125.0.dp).requiredHeight(42.0.dp)
    )
}

@Composable
fun IngameButtons2Title(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.ingame_buttons2_ingame_buttons2_title),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(298.0.dp).requiredHeight(90.0.dp)
    )
}

@Composable
fun IngameButtons2Btns(
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
fun SecondButtonTopLevel(
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
