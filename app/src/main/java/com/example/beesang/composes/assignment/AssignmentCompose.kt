package com.example.beesang.composes.assignment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beesang.composes.NavigationBar
import com.example.beesang.composes.TopLevel
import com.example.beesang.composes.layout.BackgroundImg
import com.example.beesang.composes.lecture.LectureWeekCard
import com.example.beesang.login.notoSansKR
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayText

@Composable
fun AssignmentCompose(
    onBackBtnTapped: () -> Unit = {},
    onHomeBtnTapped: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    TopLevel(modifier = modifier) {
        BackgroundImg()
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            NavigationBar(
                onBackBtnTapped,
                onHomeBtnTapped
            )
            Spacer(modifier = Modifier.height(20.0.dp))
            RelayText(
                content = "과제하기",
                fontSize = 34.0.sp,
                fontWeight = FontWeight(700.0.toInt()),
                fontFamily = notoSansKR,
                color = Color(
                    alpha = 255,
                    red = 115,
                    green = 115,
                    blue = 115
                ),
                textAlign = TextAlign.Center,
                modifier = modifier.fillMaxWidth(1.0f)
            )
            Spacer(modifier = Modifier.height(50.0.dp))
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                repeat(10) {
                    AssignmentWeekCard()
                    Spacer(modifier = Modifier.height(30.0.dp))
                }
            }
        }

    }
}

@Preview(widthDp = 430, heightDp = 927)
@Composable
private fun AssignmentComposePreview() {
    MaterialTheme {
        RelayContainer {
            AssignmentCompose(
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            )
        }
    }
}