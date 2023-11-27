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
import com.google.relay.compose.tappable

@Composable
fun RegisterButton(
    modifier: Modifier = Modifier,
    onBtnTapped: () -> Unit
) {
    RegisterButtonTopLevel(modifier = modifier) {
        RegisterHomeButtonButton(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            ).tappable(onTap = onBtnTapped)
        )
    }
}
@Composable
fun RegisterHomeButtonButton(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.register_home_button_register_home_button_button),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(126.0.dp).requiredHeight(53.30767822265625.dp)
    )
}

@Composable
fun RegisterButtonTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).requiredHeight(50.dp)
    )
}
