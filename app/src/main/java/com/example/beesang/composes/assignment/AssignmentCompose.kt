package com.example.beesang.composes.assignment

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.beesang.composes.lecture.getChapterData
import com.example.beesang.login.notoSansKR
import com.example.beesang.retrofit.getAssignments
import com.example.beesang.retrofit.response.AssignmentReadAllResponse
import com.example.beesang.retrofit.response.ChapterReadResponse
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun AssignmentCompose(
    onBackBtnTapped: () -> Unit = {},
    onHomeBtnTapped: () -> Unit = {},
    onCardAssignmentTapped: (Long, Int, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    TopLevel(
        modifier = modifier,
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationBar(
                onBackBtnTapped,
                onHomeBtnTapped
            )
            Spacer(modifier = Modifier.height(10.0.dp))
            RelayText(
                content = "과제하기",
                fontSize = 34.0.sp,
                fontWeight = FontWeight(700.0.toInt()),
                fontFamily = notoSansKR,
                color = Color(
                    alpha = 255,
                    red = 109,
                    green = 85,
                    blue = 0
                ),
                textAlign = TextAlign.Center,
                modifier = modifier.fillMaxWidth(1.0f)
            )
            Spacer(modifier = Modifier.height(35.0.dp))
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                val scope = CoroutineScope(Dispatchers.IO)
                val results = remember { mutableStateOf<List<AssignmentReadAllResponse>?>(null) }
                scope.launch { results.value = getAssignments() }

                results.value?.let {
                    for(i in it.indices) {
                        AssignmentWeekCard(id = it[i].assignmentId, week = it[i].week, title = it[i].title, description = it[i].description, onCardAssignmentTapped = onCardAssignmentTapped)
                        Spacer(modifier = Modifier.height(20.0.dp))
                    }
                }
            }
        }

    }
}

//@Preview(widthDp = 430, heightDp = 927)
//@Composable
//private fun AssignmentComposePreview() {
//    MaterialTheme {
//        RelayContainer {
//            AssignmentCompose(
//                modifier = Modifier
//                    .rowWeight(1.0f)
//                    .columnWeight(1.0f)
//            )
//        }
//    }
//}