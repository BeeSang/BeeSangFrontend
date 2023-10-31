package com.example.beesang.composes.lecture

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.beesang.activities.ChapterActivity
import com.example.beesang.activities.HomeActivity
import com.example.beesang.login.notoSansKR
import com.google.relay.compose.BoxScopeInstance.boxAlign
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayText
import com.google.relay.compose.tappable

@Composable
fun LectureWeekCard(
    onCardTapped: (Int) -> Unit = {},
    week: Int,
    title: String,
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
            .tappable (onTap = { onCardTapped(week) })
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
            RelayText(
                content = week.toString() + "주차",
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
                    .fillMaxHeight(0.2f)
            )
            Text(
                text = title,
                fontSize = 34.0.sp,
                fontWeight = FontWeight(700.0.toInt()),
                fontFamily = notoSansKR,
                color = Color(
                    alpha = 255,
                    red = 115,
                    green = 115,
                    blue = 115
                ),
                lineHeight = 34.0.sp,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth(1.0f)
                    .fillMaxHeight(0.8f)
                    .padding(8.0.dp)
            )
        }
    }