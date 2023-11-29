package com.example.beesang.composes.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.beesang.R
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage

/**
 * asdf
 *
 * This composable was generated from the UI Package 'new_game_header'.
 * Generated code; do not edit directly
 */
@Composable
fun NewGameHeader(
    modifier: Modifier = Modifier,
    imgPath: String
) {
    NewGameHeaderTopLevel(modifier = modifier) {
        NewGameHeaderHeader(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
        ) {
            NewGameHeaderHeaderRight(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 4.0.dp,
                        y = 2.0.dp
                    )
                )
            )
            NewGameHeaderHeaderLeft()
            NewGameHeaderHeaderImg(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 4.0.dp,
                        y = 5.0.dp
                    )
                ),
                imgPath = imgPath
            )
        }
    }
}

@Preview(widthDp = 375, heightDp = 812)
@Composable
private fun NewGameHeaderPreview() {
    MaterialTheme {
        RelayContainer {
            NewGameHeader(
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f),
                "defaultImage.png"
            )
        }
    }
}

@Composable
fun NewGameHeaderHeaderRight(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.new_game_header_new_game_header_header_right),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(160.0.dp)
            .requiredHeight(59.6273193359375.dp)
    )
}

@Composable
fun NewGameHeaderHeaderLeft(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.new_game_header_new_game_header_header_left),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(60.0.dp)
            .requiredHeight(60.0.dp)
    )
}

@Composable
fun NewGameHeaderHeaderImg(modifier: Modifier = Modifier, imgPath: String) {
    Image(
        painter = rememberImagePainter(
        data = "https://beesang.s3.ap-northeast-2.amazonaws.com/user/$imgPath",
        builder = {
            crossfade(true)
        }),
        modifier = modifier
        .size(52.dp)
        .clip(RoundedCornerShape(6.dp)),
        contentScale = ContentScale.Crop,
        contentDescription = null // Provide content description if needed
    )
}

@Composable
fun NewGameHeaderHeader(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .requiredWidth(164.0.dp)
            .requiredHeight(61.6273193359375.dp)
    )
}

@Composable
fun NewGameHeaderTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(62.dp)
    )
}