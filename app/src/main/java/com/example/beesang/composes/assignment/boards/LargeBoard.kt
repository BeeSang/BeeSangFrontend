package com.example.beesang.composes.assignment.boards

import com.example.beesang.inassignmentlargeboard.notoSansKR

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
 * large V1
 *
 * This composable was generated from the UI Package 'inassignment_largeboard'.
 * Generated code; do not edit directly
 */
@Composable
fun LargeBoard(
    modifier: Modifier = Modifier,
    content: String?
) {
    LargeBoardTopLevel(modifier = modifier) {
        InassignmentLargeboardLargeboard(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
        ) {
            InassignmentLargeboardLargeboardBg()
            InassignmentLargeboardLargeboardContent(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 33.0.dp,
                        y = 26.0.dp
                    )
                ),
                content = content
            )
        }
    }
}

@Preview(widthDp = 430, heightDp = 932)
@Composable
private fun LargeBoardPreview() {
    MaterialTheme {
        RelayContainer {
            LargeBoard(
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f),
                content = "Hello, World!"
            )
        }
    }
}

@Composable
fun InassignmentLargeboardLargeboardBg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.inassignment_largeboard_inassignment_largeboard_largeboard_bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(350.0.dp).requiredHeight(379.0.dp)
    )
}

@Composable
fun InassignmentLargeboardLargeboardContent(modifier: Modifier = Modifier, content: String?) {
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
            modifier = modifier.requiredWidth(281.0.dp).requiredHeight(324.0.dp).wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
        )
    }
}

@Composable
fun InassignmentLargeboardLargeboard(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(350.0.dp).requiredHeight(379.0.dp)
    )
}

@Composable
fun LargeBoardTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(380.dp)
    )
}
