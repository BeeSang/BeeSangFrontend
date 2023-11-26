package com.example.beesang.composes.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.beesang.R
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.tappable

/**
 * home_button V1
 *
 * This composable was generated from the UI Package 'home_button'.
 * Generated code; do not edit directly
 */
@Composable
fun HomeButtons(
    modifier: Modifier = Modifier,
    onLectureBtnTapped: () -> Unit = {},
    onGameBtnTapped: () -> Unit = {},
    onAssignBtnTapped: () -> Unit = {},
    onMyPageBtnTapped: () -> Unit = {},
) {
    HomeButtonsTopLevel(modifier = modifier) {
        HomeButtonButton(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
        ) {
            HomeButtonButtonMypageBtn(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 161.0.dp,
                        y = 76.0.dp
                    )
                )
                    .tappable(onTap = onMyPageBtnTapped)
            )
            HomeButtonButtonAssignmentBtn(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 76.0.dp
                    )
                )
                    .tappable(onTap = onAssignBtnTapped)
            )
            HomeButtonButtonLectureBtn(
                modifier = Modifier.tappable(onTap = onLectureBtnTapped)
            )
            HomeButtonButtonGameBtn(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 161.0.dp,
                        y = 0.0.dp
                    )
                )
                    .tappable(onTap = onGameBtnTapped)
            )
        }
    }
}

@Preview(widthDp = 430, heightDp = 927)
@Composable
private fun HomeButtonsPreview() {
    MaterialTheme {
        RelayContainer {
            HomeButtons(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
    }
}

@Composable
fun HomeButtonButtonMypageBtn(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.home_button_home_button_button_mypage_btn),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(155.0.dp).requiredHeight(66.856201171875.dp)
    )
}

@Composable
fun HomeButtonButtonAssignmentBtn(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.home_button_home_button_button_assignment_btn),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(155.0.dp).requiredHeight(66.856201171875.dp)
    )
}

@Composable
fun HomeButtonButtonLectureBtn(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.home_button_home_button_button_lecture_btn),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(155.0.dp).requiredHeight(66.856201171875.dp)
    )
}

@Composable
fun HomeButtonButtonGameBtn(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.home_button_home_button_button_game_btn),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(155.0.dp).requiredHeight(66.856201171875.dp)
    )
}

@Composable
fun HomeButtonButton(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(316.0.dp).requiredHeight(142.856201171875.dp)
    )
}

@Composable
fun HomeButtonsTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .requiredHeight(140.dp)
    )
}
