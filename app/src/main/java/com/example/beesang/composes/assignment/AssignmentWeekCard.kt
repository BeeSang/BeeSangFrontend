package com.example.beesang.composes.assignment

import com.example.beesang.assignmenthomeboard.notoSansKR

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
 * assignment home board V1
 *
 * This composable was generated from the UI Package 'assignment_home_board'.
 * Generated code; do not edit directly
 */
@Composable
fun AssignmentWeekCard(
    modifier: Modifier = Modifier,
    id: Long,
    week: Int,
    title: String,
    description: String,
    onCardAssignmentTapped: (Long, Int, String, String) -> Unit,
) {
    AssignmentWeekCardTopLevel(modifier = modifier) {
        AssignmentHomeBoardBoard(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
                .tappable(onTap = { onCardAssignmentTapped(id, week, title, description) })
        ) {
            AssignmentHomeBoardBoardBg()
            AssignmentHomeBoardBoardContent(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 37.0.dp,
                        y = 43.0.dp
                    )
                ),
                title = title
            )
            AssignmentHomeBoardBoardTitle(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 37.0.dp,
                        y = 28.0.dp
                    )
                ),
                week = week
            )
        }
    }
}

@Composable
fun AssignmentHomeBoardBoardBg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.assignment_home_board_assignment_home_board_board_bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(350.0.dp).requiredHeight(116.0.dp)
    )
}

@Composable
fun AssignmentHomeBoardBoardContent(modifier: Modifier = Modifier, title: String) {
    RelayText(
        content = title,
        fontSize = 20.0.sp,
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
        modifier = modifier.requiredWidth(264.0.dp).requiredHeight(44.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun AssignmentHomeBoardBoardTitle(modifier: Modifier = Modifier, week: Int) {
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
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        modifier = modifier
    )
}

@Composable
fun AssignmentHomeBoardBoard(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(350.0.dp).requiredHeight(116.0.dp)
    )
}

@Composable
fun AssignmentWeekCardTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(100.dp)
    )
}
