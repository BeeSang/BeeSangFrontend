package com.example.beesang.composes.lecture.quiz

import com.example.beesang.quizboardanswer.notoSansKR

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.beesang.R
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.tappable

/**
 * asdf
 *
 * This composable was generated from the UI Package 'quiz_board_answer'.
 * Generated code; do not edit directly
 */
@Composable
fun QuizAnswerBoard(
    modifier: Modifier = Modifier,
    time: Int,
    title: String,
    question: String,
    description: String,
    answer: String,
    isAnswer: String,
    onBoardTapped: () -> Unit
) {
    QuizAnswerBoardTopLevel(modifier = modifier) {
        QuizBoardAnswerAnswer(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            ).tappable(onTap = onBoardTapped)
        ) {
            QuizBoardAnswerAnswerBg()
            QuizBoardAnswerAnswerTitle(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 32.0.dp,
                        y = 50.0.dp
                    )
                ),
                title = title
            )
            QuizBoardAnswerAnswerTime(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 32.0.dp,
                        y = 28.0.dp
                    )
                ),
                time = time
            )
            QuizBoardAnswerAnswerQuestion(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = -1.5.dp,
                        y = 103.0.dp
                    )
                ),
                question = question
            )
            QuizBoardAnswerAnswerDescription(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = -1.5.dp,
                        y = 213.0.dp
                    )
                ),
                description = description
            )
            QuizBoardAnswerAnswerAnswer(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = -1.5.dp,
                        y = 193.0.dp
                    )
                ),
                answer = answer
            )
            QuizBoardAnswerAnswerIsanswer(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = -1.5.dp,
                        y = 173.0.dp
                    )
                ),
                isAnswer = isAnswer
            )
        }
    }
}
@Composable
fun QuizBoardAnswerAnswerBg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.quiz_board_answer_quiz_board_answer_answer_bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(350.0.dp).requiredHeight(417.0.dp)
    )
}

@Composable
fun QuizBoardAnswerAnswerTitle(modifier: Modifier = Modifier, title: String) {
    RelayText(
        content = title,
        fontSize = 18.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 109,
            green = 84,
            blue = 0
        ),
        height = 1.4479999542236328.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(264.0.dp).requiredHeight(53.0.dp).alpha(alpha = 0.4000000059604645f).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun QuizBoardAnswerAnswerTime(modifier: Modifier = Modifier, time: Int) {
    RelayText(
        content = time.toString() + "차시",
        fontSize = 15.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 162,
            green = 160,
            blue = 156
        ),
        height = 1.4479999542236328.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        modifier = modifier.alpha(alpha = 0.4000000059604645f)
    )
}

@Composable
fun QuizBoardAnswerAnswerQuestion(modifier: Modifier = Modifier, question: String) {
    RelayText(
        content = question,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 83,
            green = 38,
            blue = 0
        ),
        height = 1.4479999542236328.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(283.0.dp).alpha(alpha = 0.5f).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun QuizBoardAnswerAnswerDescription(modifier: Modifier = Modifier, description: String) {
    RelayText(
        content = description,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 83,
            green = 38,
            blue = 0
        ),
        height = 1.4479999542236328.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(283.0.dp).requiredHeight(165.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun QuizBoardAnswerAnswerAnswer(modifier: Modifier = Modifier, answer: String) {
    RelayText(
        content = "정답: $answer",
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 83,
            green = 38,
            blue = 0
        ),
        height = 1.4479999542236328.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(283.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun QuizBoardAnswerAnswerIsanswer(modifier: Modifier = Modifier, isAnswer: String) {
    RelayText(
        content = isAnswer,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 223,
            green = 26,
            blue = 26
        ),
        height = 1.4479999542236328.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(283.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun QuizBoardAnswerAnswer(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(350.0.dp).requiredHeight(417.0.dp)
    )
}

@Composable
fun QuizAnswerBoardTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(400.dp)
    )
}
