package com.example.beesang.composes

import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.beesang.R
import com.google.relay.compose.RelayImage

@Composable
fun BackgroundImg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.home_background_img),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(430.0.dp)
            .requiredHeight(932.0.dp)
    )
}

@Composable
fun FarmBackground(
    modifier: Modifier = Modifier,
    bg: Int
) {
    RelayImage(
        image = painterResource(bg),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(430.0.dp)
            .requiredHeight(927.0.dp)
    )
}