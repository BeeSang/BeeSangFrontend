package com.example.beesang.composes

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.beesang.R
import com.google.relay.compose.BoxScopeInstance.boxAlign
import com.google.relay.compose.RelayImage
import com.google.relay.compose.tappable

@Composable
fun NavigationBar(
    onBackBtnTapped: () -> Unit,
    onHomeBtnTapped: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 20.0.dp
                )
            )
            .fillMaxWidth(1.0f)
            .requiredHeight(40.0.dp)
    ) {
        BackBtn(
            onBackBtnTapped,
            modifier = Modifier
                .boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 20.0.dp,
                        y = 0.0.dp
                    )
                )
        )
        Spacer(Modifier.weight(1.0f))
        HomeBtn(
            onHomeBtnTapped,
            modifier = Modifier
                .boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = -20.0.dp,
                        y = 0.0.dp
                    )
                )
        )
    }
}

@Composable
fun BackBtn(onBackBtnTapped: () -> Unit, modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.register_back_btn2),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .tappable(onTap = onBackBtnTapped)
            .requiredWidth(43.0.dp)
            .requiredHeight(44.0.dp)
    )
}

@Composable
fun HomeBtn(onHomeBtnTapped: () -> Unit, modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.home_btn),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .tappable(onTap = onHomeBtnTapped)
            .requiredWidth(43.0.dp)
            .requiredHeight(44.0.dp)
    )
}