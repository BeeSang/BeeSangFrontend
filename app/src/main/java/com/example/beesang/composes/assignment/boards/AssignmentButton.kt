package com.example.beesang.composes.assignment.boards

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.beesang.R
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.tappable

/**
 * .
 *
 * This composable was generated from the UI Package 'inassignment_image_button'.
 * Generated code; do not edit directly
 */
@Composable
fun InAssignmentButton(
    modifier: Modifier = Modifier,
    onAssignmentBtnTapped: () -> Unit = {}
) {
    InAssignmentButtonTopLevel(modifier = modifier) {
        InassignmentImageButtonButton(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 35.0.dp,
                    y = 0.0.dp
                )
            )
                .tappable( onAssignmentBtnTapped )
        ) {
            InassignmentImageButtonButtonButton()
        }
    }
}

@Preview(widthDp = 430, heightDp = 932)
@Composable
private fun InAssignmentButtonPreview() {
    MaterialTheme {
        RelayContainer {
            InAssignmentButton(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
    }
}

@Composable
fun InassignmentImageButtonButtonButton(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.inassignment_image_button_inassignment_image_button_button_button),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(87.0.dp).requiredHeight(37.0.dp)
    )
}

@Composable
fun InassignmentImageButtonButton(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(87.0.dp).requiredHeight(37.0.dp)
    )
}

@Composable
fun InAssignmentButtonTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(38.dp)
    )
}
