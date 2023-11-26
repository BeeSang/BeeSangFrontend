package com.example.beesang.composes.lecture.board

import com.example.beesang.lectureboard.notoSansKR

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.beesang.R
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.tappable

/**
 * .
 *
 * This composable was generated from the UI Package 'lecture_board'.
 * Generated code; do not edit directly
 */
@Composable
fun LectureBoard(
    modifier: Modifier = Modifier,
    time: Int,
    title: String,
    videoLink: String,
    onLectureBoardTapped: (String) -> Unit
) {
    LectureBoardTopLevel(modifier = modifier) {
        LectureBoardBoard(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
                .tappable(onTap = { onLectureBoardTapped(videoLink) })
        ) {
            LectureBoardBoardBg()
            LectureBoardBoardTitle(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 31.0.dp,
                        y = 48.0.dp
                    )
                ),
                title = title
            )
            LectureBoardBoardWeek(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 31.0.dp,
                        y = 26.0.dp
                    )
                ),
                time = time
            )
        }
    }
}

@Composable
fun LectureBoardBoardBg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.lecture_board_lecture_board_board_bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(345.0.dp).requiredHeight(140.95703125.dp)
    )
}

@Composable
fun LectureBoardBoardTitle(modifier: Modifier = Modifier, title: String) {
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
        modifier = modifier.requiredWidth(264.0.dp).requiredHeight(61.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun LectureBoardBoardWeek(modifier: Modifier = Modifier, time: Int) {
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
        modifier = modifier
    )
}

@Composable
fun LectureBoardBoard(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(345.0.dp).requiredHeight(140.95703125.dp)
    )
}

@Composable
fun LectureBoardTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(130.dp)
    )
}
