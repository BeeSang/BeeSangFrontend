package com.example.beesang.composes.assignment.boards

import com.example.beesang.inassignmentsmallboard.notoSansKR

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
 * This composable was generated from the UI Package 'inassignment_smallboard'.
 * Generated code; do not edit directly
 */
@Composable
fun SmallBoard(
    modifier: Modifier = Modifier,
    content: String?
) {
    SmallBoardTopLevel(modifier = modifier) {
        InassignmentSmallboardSmallboard(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
        ) {
            InassignmentSmallboardSmallboardBg()
            InassignmentSmallboardSmallboardContent(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 35.0.dp,
                        y = 24.0.dp
                    )
                ),
                content = content
            )
        }
    }
}

@Preview(widthDp = 430, heightDp = 932)
@Composable
private fun SmallBoardPreview() {
    MaterialTheme {
        RelayContainer {
            SmallBoard(
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f),
                content = "Hello World!"
            )
        }
    }
}

@Composable
fun InassignmentSmallboardSmallboardBg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.inassignment_smallboard_inassignment_smallboard_smallboard_bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(350.0.dp).requiredHeight(208.0.dp)
    )
}

@Composable
fun InassignmentSmallboardSmallboardContent(modifier: Modifier = Modifier, content: String?) {
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
            modifier = modifier.requiredWidth(281.0.dp).requiredHeight(153.0.dp).wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
        )
    }
}

@Composable
fun InassignmentSmallboardSmallboard(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(350.0.dp).requiredHeight(208.0.dp)
    )
}

@Composable
fun SmallBoardTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(204.dp)
    )
}
