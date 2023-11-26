package com.example.beesang.composes.lecture.board

import com.example.beesang.chapterboard.notoSansKR

import androidx.compose.foundation.layout.fillMaxHeight
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
 * ,.
 *
 * This composable was generated from the UI Package 'chapter_board'.
 * Generated code; do not edit directly
 */
@Composable
fun ChapterBoard(
    modifier: Modifier = Modifier,
    week: Int,
    title: String,
    onCardTapped: (Int, String) -> Unit
) {
    ChapterBoardTopLevel(modifier = modifier) {
        ChapterBoardBoard(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
                .tappable(onTap = { onCardTapped(week, title) })
        ) {
            ChapterBoardBoardBg()
            ChapterBoardBoardTitle(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 38.0.dp,
                        y = 54.0.dp
                    )
                ),
                title = title
            )
            ChapterBoardBoardWeek(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = -1.0.dp,
                        y = 28.0.dp
                    )
                ),
                week = week
            )
        }
    }
}

//@Preview(widthDp = 430, heightDp = 927)
//@Composable
//private fun ChapterBoardPreview() {
//    MaterialTheme {
//        RelayContainer {
//            ChapterBoard(
//                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f),
//                week = 1,
//                title = "지구온난화로 인한\n기후위기와 식량위기"
//            )
//        }
//    }
//}

@Composable
fun ChapterBoardBoardBg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.chapter_board_chapter_board_board_bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(314.0.dp).requiredHeight(198.3681640625.dp)
    )
}

@Composable
fun ChapterBoardBoardTitle(modifier: Modifier = Modifier, title: String) {
    RelayText(
        content = title,
        fontSize = 27.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 83,
            green = 38,
            blue = 0
        ),
        height = 1.4480000248661746.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(236.0.dp).requiredHeight(104.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun ChapterBoardBoardWeek(modifier: Modifier = Modifier, week: Int) {
    RelayText(
        content = week.toString() + "주차",
        fontSize = 15.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 162,
            green = 160,
            blue = 156
        ),
        height = 1.4479999542236328.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(56.0.dp)
    )
}

@Composable
fun ChapterBoardBoard(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(314.0.dp).requiredHeight(198.3681640625.dp)
    )
}

@Composable
fun ChapterBoardTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(190.dp)
    )
}
