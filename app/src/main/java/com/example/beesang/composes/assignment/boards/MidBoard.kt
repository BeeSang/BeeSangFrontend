package com.example.beesang.composes.assignment.boards

import com.example.beesang.inassignmentmidboard.notoSansKR

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
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
 * .
 *
 * This composable was generated from the UI Package 'inassignment_midboard'.
 * Generated code; do not edit directly
 */
@Composable
fun MidBoard(
    modifier: Modifier = Modifier,
    content: String?
) {
    MidBoardTopLevel(modifier = modifier) {
        InassignmentMidboardMidboard(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
        ) {
            InassignmentMidboardMidboardBg()
            InassignmentMidboardMidboardContent(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 35.0.dp,
                        y = 22.0.dp
                    )
                )
                ,content = content
            )
        }
    }
}

@Preview(widthDp = 430, heightDp = 932)
@Composable
private fun MidBoardPreview() {
    MaterialTheme {
        RelayContainer {
            MidBoard(
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f),
                content = "Hello World!"
            )
        }
    }
}

@Composable
fun InassignmentMidboardMidboardBg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.inassignment_midboard_inassignment_midboard_midboard_bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(350.0.dp).requiredHeight(294.0.dp)
    )
}

@Composable
fun InassignmentMidboardMidboardContent(modifier: Modifier = Modifier, content: String?) {
    if (content != null) {
        RelayText(
            content = content,
            fontSize = 20.0.sp,
            fontFamily = notoSansKR,
            color = Color(
                alpha = 255,
                red = 83,
                green = 38,
                blue = 0
            ),
            height = 1.4479999542236328.em,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight(700.0.toInt()),
            maxLines = -1,
            modifier = modifier.requiredWidth(281.0.dp).requiredHeight(242.0.dp).wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
        )
    }
}

@Composable
fun InassignmentMidboardMidboard(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(350.0.dp).requiredHeight(294.0.dp)
    )
}

@Composable
fun MidBoardTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(290.dp)
    )
}
