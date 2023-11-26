package com.example.beesang.composes.assignment

import com.example.beesang.inassignmentindexbar.notoSansKR

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
 * inassignment_indexbar V1
 *
 * This composable was generated from the UI Package 'inassignment_indexbar'.
 * Generated code; do not edit directly
 */
@Composable
fun InAssignmentIndexBar(
    modifier: Modifier = Modifier,
    title: String
) {
    InAssignmentIndexBarTopLevel(modifier = modifier) {
        InassignmentIndexbarIndexbar(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
        ) {
            InassignmentIndexbarIndexbarBg()
            InassignmentIndexbarIndexbarTitle(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = -32.0.dp,
                        y = 6.0.dp
                    )
                ),
                title = title
            )
        }
    }
}

@Preview(widthDp = 430, heightDp = 932)
@Composable
private fun InAssignmentIndexBarPreview() {
    MaterialTheme {
        RelayContainer {
            InAssignmentIndexBar(
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f),
                title = "참여 방법"
            )
        }
    }
}

@Composable
fun InassignmentIndexbarIndexbarBg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.inassignment_indexbar_inassignment_indexbar_indexbar_bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(359.0.dp).requiredHeight(39.0.dp)
    )
}

@Composable
fun InassignmentIndexbarIndexbarTitle(modifier: Modifier = Modifier, title: String) {
    RelayText(
        content = title,
        fontSize = 20.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 109,
            green = 84,
            blue = 0
        ),
        height = 1.4479999542236328.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(285.0.dp).requiredHeight(28.0.dp)
    )
}

@Composable
fun InassignmentIndexbarIndexbar(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(359.0.dp).requiredHeight(39.0.dp)
    )
}

@Composable
fun InAssignmentIndexBarTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(40.dp)
    )
}
