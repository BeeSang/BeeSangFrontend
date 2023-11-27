package com.example.beesang.composes.register

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

/**
 * asdf
 *
 * This composable was generated from the UI Package 'register_home'.
 * Generated code; do not edit directly
 */
@Composable
fun RegisterTop(modifier: Modifier = Modifier) {
    RegisterTopTopLevel(modifier = modifier) {
            RegisterHomeHomeTitle(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 0.0.dp
                    )
                )
            )
    }
}


@Preview(widthDp = 430, heightDp = 932)
@Composable
private fun RegisterTopPreview() {
    MaterialTheme {
        RelayContainer {
            RegisterTop(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
    }
}

@Composable
fun RegisterHomeHomeTitle(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.register_home_register_home_home_title),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(180.0.dp).requiredHeight(75.0.dp)
    )
}

@Composable
fun RegisterTopTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(60.dp)
    )
}
