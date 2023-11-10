package com.example.beesang.composes.assignment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beesang.R
import com.example.beesang.login.notoSansKR
import com.google.relay.compose.BoxScopeInstance.boxAlign
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayImage

@Composable
fun AssignmentWeekCard(
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
            .requiredHeight(120.0.dp)
            .fillMaxWidth(0.8f)
            .boxAlign(
                alignment = Alignment.Center,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
    ) {
        Column(
            modifier = modifier
                .padding(8.0.dp)
                .fillMaxWidth(1.0f)
                .fillMaxHeight(1.0f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 0.0.dp
                        )
                    )
                    .fillMaxWidth(1.0f)
                    .requiredHeight(40.0.dp)
                    .padding(start = 10.0.dp, end = 10.0.dp)
            ) {
                Text(
                    text = "테스트",
                    fontSize = 15.0.sp,
                    fontWeight = FontWeight(700.0.toInt()),
                    fontFamily = notoSansKR,
                    color = Color(
                        alpha = 255,
                        red = 115,
                        green = 115,
                        blue = 115
                    ),
                    textAlign = TextAlign.Left,
                    modifier = modifier
                )
                Spacer(Modifier.weight(1.0f))
                RelayImage(
                    image = painterResource(R.drawable.arrow_under),
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .requiredWidth(20.0.dp)
                        .requiredHeight(20.0.dp)
                        .boxAlign(
                            alignment = Alignment.TopEnd,
                            offset = DpOffset(
                                x = 0.0.dp,
                                y = 0.0.dp
                            )
                        )
                )
            }
            Text(
                text = "테스트2",
                fontSize = 26.0.sp,
                fontWeight = FontWeight(700.0.toInt()),
                fontFamily = notoSansKR,
                color = Color(
                    alpha = 255,
                    red = 109,
                    green = 85,
                    blue = 0
                ),
                textAlign = TextAlign.Left,
                modifier = modifier
                    .fillMaxWidth(1.0f)
                    .padding(start = 10.0.dp)
            )
        }
    }
}