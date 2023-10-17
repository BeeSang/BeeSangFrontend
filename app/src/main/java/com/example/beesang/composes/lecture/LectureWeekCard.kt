package com.example.beesang.composes.lecture

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.google.relay.compose.BoxScopeInstance.boxAlign
import com.google.relay.compose.RelayContainer

@Composable
fun LectureWeekCard(
    modifier: Modifier = Modifier,
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 255,
            green = 251,
            blue = 238
        ),
        modifier = modifier
            .requiredHeight(200.0.dp)
            .fillMaxWidth(0.8f)
            .boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )

    ) {
        Text(
            text = "2Week",
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth(1.0f)
        )
    }
}