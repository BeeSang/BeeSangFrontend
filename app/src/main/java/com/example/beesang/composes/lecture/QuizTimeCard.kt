package com.example.beesang.composes.lecture

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beesang.R
import com.example.beesang.composes.lecture.quiz.QuizAnswerBoard
import com.example.beesang.composes.lecture.quiz.QuizCloseBoard
import com.example.beesang.composes.lecture.quiz.QuizOpenBoard
import com.example.beesang.login.notoSansKR
import com.google.relay.compose.BoxScopeInstance.boxAlign
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizTimeCard(
    time: Int,
    title: String,
    question: String,
    description: String,
    answer: Boolean,
    modifier: Modifier = Modifier,
) {
    var showAnswer by remember { mutableStateOf(false) }
    var showOX by remember { mutableStateOf("") }
    var isAnswer by remember { mutableStateOf("") }

    var isAnswerVisible by remember { mutableStateOf(false) }
    var isOpenVisible by remember { mutableStateOf(true) }
    if(!isAnswerVisible) {
        QuizCloseBoard(time = time, title = title, onBoardTapped = { isAnswerVisible = true })
    }
    else {
        if(isOpenVisible) {
            QuizOpenBoard(
                time = time, title = title,
                question = question, onBoardTapped = { isAnswerVisible = false },
                onOkBtnTapped = {
                    if(answer) { //정답
                        showOX = "O"
                        isAnswer = "정답입니다!"
                    } else {
                        showOX = "X"
                        isAnswer = "오답입니다..ㅜㅜㅜ"
                    }
                    showAnswer = true
                    isOpenVisible = false
                },
                onNoBtnTapped = {
                    if(!answer) { //정답
                        showOX = "X"
                        isAnswer = "정답입니다!"
                    } else {
                        showOX = "O"
                        isAnswer = "오답입니다..ㅜㅜㅜ"
                    }
                    showAnswer = true
                    isOpenVisible = false
                }
            )
        }
    }

    if(showAnswer) {
        QuizAnswerBoard(
            time = time, title = title,
            question = question, description = description,
            answer = showOX, isAnswer = isAnswer, onBoardTapped = {
                showAnswer = false
                isAnswerVisible = false
                isOpenVisible = true
            }
        )
    }
}

@Preview(widthDp = 430, heightDp = 927)
@Composable
private fun WelcomePreview() {
    MaterialTheme {
        RelayContainer {
            QuizTimeCard(
                time = 1,
                title = "기후위기의 발생과 원인1",
                question = "기후위기의 발생과 원인2",
                description = "기후위기의 발생과 원인3",
                answer = true,
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            )
        }
    }
}