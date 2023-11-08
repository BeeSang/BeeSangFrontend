package com.example.beesang.composes.lecture

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.beesang.login.notoSansKR
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.relay.compose.BoxScopeInstance.boxAlign
import com.google.relay.compose.BoxScopeInstanceImpl.align
import com.google.relay.compose.RelayText
import com.google.relay.compose.tappable

@Composable
fun ChapterTimeCard(
    time: Int,
    title: String,
    videoLink: String,
    modifier: Modifier = Modifier,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(
                alpha = 255,
                red = 255,
                green = 251,
                blue = 238
            )
        ),
        shape = RoundedCornerShape(14.dp),
        modifier = modifier
            .tappable(onTap = {

            })
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
            text = time.toString() + "차시",
            fontSize = 20.0.sp,
            fontWeight = FontWeight(700.0.toInt()),
            fontFamily = notoSansKR,
            color = Color(
                alpha = 255,
                red = 115,
                green = 115,
                blue = 115
            ),
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth(1.0f)
                .fillMaxHeight(0.3f)
        )
        Text(
            text = title,
            fontSize = 26.0.sp,
            fontWeight = FontWeight(700.0.toInt()),
            fontFamily = notoSansKR,
            color = Color(
                alpha = 255,
                red = 115,
                green = 115,
                blue = 115
            ),
            lineHeight = 26.0.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth(1.0f)
                .fillMaxHeight(0.7f)
                .padding(8.0.dp)
        )
    }
}