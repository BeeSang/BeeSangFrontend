package com.example.beesang.composes.lecture.quiz

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
import com.example.beesang.login.notoSansKR
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.tappable

/**
 * asd
 *
 * This composable was generated from the UI Package 'quiz_board_open'.
 * Generated code; do not edit directly
 */
@Composable
fun QuizOpenBoard(
    modifier: Modifier = Modifier,
    time: Int,
    title: String,
    question: String,
    onBoardTapped: () -> Unit,
    onOkBtnTapped: () -> Unit,
    onNoBtnTapped: () -> Unit
) {
    QuizOpenBoardTopLevel(modifier = modifier) {
        QuizBoardOpenOpen(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            ).tappable(onTap = onBoardTapped)
        ) {
            QuizBoardOpenOpenBg()
            QuizBoardOpenOpenTitle(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 32.0.dp,
                        y = 43.0.dp
                    )
                ),
                title = title
            )
            QuizBoardOpenOpenWeek(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 32.0.dp,
                        y = 28.0.dp
                    )
                ),
                time = time
            )
            QuizBoardOpenOpenQuestion(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = -1.5.dp,
                        y = 84.0.dp
                    )
                ),
                question = question
            )
            QuizBoardOpenOpenNo(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 65.0.dp,
                        y = 173.0.dp
                    )
                ).tappable(onTap = onNoBtnTapped)
            )
            QuizBoardOpenOpenOk(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 192.0.dp,
                        y = 173.0.dp
                    )
                ).tappable(onTap = onOkBtnTapped)
            )
        }
    }
}

@Composable
fun QuizBoardOpenOpenBg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.quiz_board_open_quiz_board_open_open_bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(350.0.dp).requiredHeight(261.0.dp)
    )
}

@Composable
fun QuizBoardOpenOpenTitle(modifier: Modifier = Modifier, title: String) {
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
        modifier = modifier.requiredWidth(264.0.dp).requiredHeight(44.0.dp).alpha(alpha = 0.4000000059604645f).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun QuizBoardOpenOpenWeek(modifier: Modifier = Modifier, time: Int) {
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
fun QuizBoardOpenOpenQuestion(modifier: Modifier = Modifier, question: String) {
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
        modifier = modifier.requiredWidth(283.0.dp).requiredHeight(66.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun QuizBoardOpenOpenNo(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.quiz_board_open_quiz_board_open_open_no),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(90.0.dp).requiredHeight(42.0.dp)
    )
}

@Composable
fun QuizBoardOpenOpenOk(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.quiz_board_open_quiz_board_open_open_ok),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(90.0.dp).requiredHeight(42.0.dp)
    )
}

@Composable
fun QuizBoardOpenOpen(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(350.0.dp).requiredHeight(261.0.dp)
    )
}

@Composable
fun QuizOpenBoardTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(250.dp)
    )
}
