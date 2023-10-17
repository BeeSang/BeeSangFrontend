package com.example.beesang.composes.home

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
import com.example.beesang.login.notoSansKR
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.relayDropShadow
import com.google.relay.compose.tappable

/**
 * Home Screen V1
 *
 * This composable was generated from the UI Package 'home'.
 * Generated code; do not edit directly
 *
 * @param onLectureBtnTapped on lecture_btn tapped
 * @param onGameBtnTapped on game_btn tapped
 * @param onAssignBtnTapped on assign_btn tapped
 * @param onMypageBtnTapped on mypage_btn tapped
 * @param onLogoutBtnTapped on logout_btn tapped
 */
@Composable
fun HomeCompose(
    onLectureBtnTapped: () -> Unit = {},
    onGameBtnTapped: () -> Unit = {},
    onAssignBtnTapped: () -> Unit = {},
    onMypageBtnTapped: () -> Unit = {},
    onLogoutBtnTapped: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    TopLevel(modifier = modifier) {
        BackgroundImg()
        TodayAssignInfo(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 61.0.dp,
                    y = 239.0.dp
                )
            )
        ) {
            TodayAssignRectanble(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = -10.0.dp,
                        y = -6.0.dp
                    )
                )
            )
            TotayAssignDescription(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 19.0.dp,
                        y = 92.0.dp
                    )
                )
            )
            TotayAssignTitle(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 19.0.dp,
                        y = 54.0.dp
                    )
                )
            )
            InfoTitle(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 22.0.dp,
                        y = 21.0.dp
                    )
                )
            )
        }
        LectureBtn(
            onLectureBtnTapped = onLectureBtnTapped,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 52.0.dp,
                    y = 459.0.dp
                )
            )
        ) {
            LectureRectangle()
            LectureText(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 57.12451171875.dp,
                        y = 15.919921875.dp
                    )
                )
            )
            LectureIcon(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 13.0.dp,
                        y = 16.16845703125.dp
                    )
                )
            )
        }
        GameBtn(
            onGameBtnTapped = onGameBtnTapped,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 230.0.dp,
                    y = 459.0.dp
                )
            )
        ) {
            GameRectangle()
            GameText(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 58.060546875.dp,
                        y = 15.919921875.dp
                    )
                )
            )
            GameIcon(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 15.99169921875.dp,
                        y = 18.16845703125.dp
                    )
                )
            )
        }
        AssignBtn(
            onAssignBtnTapped = onAssignBtnTapped,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 52.0.dp,
                    y = 552.0.dp
                )
            )
        ) {
            AssignRectangle()
            AssignText(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 57.12451171875.dp,
                        y = 15.919921875.dp
                    )
                )
            )
            AssignIcon(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 12.0.dp,
                        y = 10.0.dp
                    )
                )
            )
        }
        MypageBtn(
            onMypageBtnTapped = onMypageBtnTapped,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 230.0.dp,
                    y = 552.0.dp
                )
            )
        ) {
            MypageRectangle()
            MypageText(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 49.6328125.dp,
                        y = 13.9833984375.dp
                    )
                )
            )
            MypageIcon(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 10.99169921875.dp,
                        y = 9.0.dp
                    )
                )
            )
        }
        LogoutBtn(
            onLogoutBtnTapped = onLogoutBtnTapped,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 30.0.dp,
                    y = 34.0.dp
                )
            )
        )
    }
}

@Preview(widthDp = 430, heightDp = 927)
@Composable
private fun HomePreview() {
    MaterialTheme {
        RelayContainer {
            HomeCompose(
                onLectureBtnTapped = {},
                onGameBtnTapped = {},
                onAssignBtnTapped = {},
                onMypageBtnTapped = {},
                onLogoutBtnTapped = {},
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun BackgroundImg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.home_background_img),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(430.0.dp).requiredHeight(932.0.dp)
    )
}

@Composable
fun TodayAssignRectanble(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.home_today_assign_rectanble),
        modifier = modifier.requiredWidth(309.0.dp).requiredHeight(168.0.dp).relayDropShadow(
            color = Color(
                alpha = 63,
                red = 0,
                green = 0,
                blue = 0
            ),
            borderRadius = 0.0.dp,
            blur = 10.0.dp,
            offsetX = 0.0.dp,
            offsetY = 4.0.dp,
            spread = 0.0.dp
        )
    )
}

@Composable
fun TotayAssignDescription(modifier: Modifier = Modifier) {
    RelayText(
        content = "남은 음식으로 요리하기 ",
        fontSize = 22.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 138,
            green = 107,
            blue = 80
        ),
        height = 1.4479999542236328.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(247.0.dp).requiredHeight(36.0.dp)
    )
}

@Composable
fun TotayAssignTitle(modifier: Modifier = Modifier) {
    RelayText(
        content = "푸드 업사이클링",
        fontSize = 27.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 83,
            green = 38,
            blue = 0
        ),
        height = 1.4480000248661746.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(247.0.dp).requiredHeight(38.0.dp)
    )
}

@Composable
fun InfoTitle(modifier: Modifier = Modifier) {
    RelayText(
        content = "오늘의 과제",
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
        maxLines = -1,
        modifier = modifier.requiredWidth(91.0.dp).requiredHeight(20.0.dp)
    )
}

@Composable
fun TodayAssignInfo(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(309.0.dp).requiredHeight(168.0.dp)
    )
}

@Composable
fun LectureRectangle(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.home_lecture_rectangle),
        modifier = modifier.requiredWidth(147.02490234375.dp).requiredHeight(58.997314453125.dp)
    )
}

@Composable
fun LectureText(modifier: Modifier = Modifier) {
    RelayText(
        content = "강의듣기",
        fontSize = 18.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 134,
            green = 112,
            blue = 69
        ),
        height = 1.4479999542236328.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(69.29833984375.dp).requiredHeight(27.157470703125.dp)
    )
}

@Composable
fun LectureIcon(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.home_lecture_icon),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(35.0.dp).requiredHeight(27.197509765625.dp)
    )
}

@Composable
fun LectureBtn(
    onLectureBtnTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = onLectureBtnTapped).requiredWidth(147.02490234375.dp).requiredHeight(58.997314453125.dp).relayDropShadow(
            color = Color(
                alpha = 63,
                red = 0,
                green = 0,
                blue = 0
            ),
            borderRadius = 0.0.dp,
            blur = 4.0.dp,
            offsetX = 0.0.dp,
            offsetY = 4.0.dp,
            spread = 0.0.dp
        )
    )
}

@Composable
fun GameRectangle(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.home_game_rectangle),
        modifier = modifier.requiredWidth(147.02490234375.dp).requiredHeight(58.997314453125.dp)
    )
}

@Composable
fun GameText(modifier: Modifier = Modifier) {
    RelayText(
        content = "게임하기",
        fontSize = 18.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 134,
            green = 112,
            blue = 69
        ),
        height = 1.4479999542236328.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(69.29833984375.dp).requiredHeight(27.157470703125.dp)
    )
}

@Composable
fun GameIcon(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.home_game_icon),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(35.0.dp).requiredHeight(24.76611328125.dp)
    )
}

@Composable
fun GameBtn(
    onGameBtnTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = onGameBtnTapped).requiredWidth(147.02490234375.dp).requiredHeight(58.997314453125.dp).relayDropShadow(
            color = Color(
                alpha = 63,
                red = 0,
                green = 0,
                blue = 0
            ),
            borderRadius = 0.0.dp,
            blur = 4.0.dp,
            offsetX = 0.0.dp,
            offsetY = 4.0.dp,
            spread = 0.0.dp
        )
    )
}

@Composable
fun AssignRectangle(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.home_assign_rectangle),
        modifier = modifier.requiredWidth(147.02490234375.dp).requiredHeight(58.997314453125.dp)
    )
}

@Composable
fun AssignText(modifier: Modifier = Modifier) {
    RelayText(
        content = "과제하기",
        fontSize = 18.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 134,
            green = 112,
            blue = 69
        ),
        height = 1.4479999542236328.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(69.29833984375.dp).requiredHeight(27.157470703125.dp)
    )
}

@Composable
fun AssignIcon(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.home_assign_icon),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(35.0.dp).requiredHeight(39.8896484375.dp)
    )
}

@Composable
fun AssignBtn(
    onAssignBtnTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = onAssignBtnTapped).requiredWidth(147.02490234375.dp).requiredHeight(58.997314453125.dp).relayDropShadow(
            color = Color(
                alpha = 63,
                red = 0,
                green = 0,
                blue = 0
            ),
            borderRadius = 0.0.dp,
            blur = 4.0.dp,
            offsetX = 0.0.dp,
            offsetY = 4.0.dp,
            spread = 0.0.dp
        )
    )
}

@Composable
fun MypageRectangle(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.home_mypage_rectangle),
        modifier = modifier.requiredWidth(147.02490234375.dp).requiredHeight(58.997314453125.dp)
    )
}

@Composable
fun MypageText(modifier: Modifier = Modifier) {
    RelayText(
        content = "마이페이지",
        fontSize = 18.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 134,
            green = 112,
            blue = 69
        ),
        height = 1.4479999542236328.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(86.15478515625.dp).requiredHeight(27.157470703125.dp)
    )
}

@Composable
fun MypageIcon(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.home_mypage_icon),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(35.0.dp).requiredHeight(37.916748046875.dp)
    )
}

@Composable
fun MypageBtn(
    onMypageBtnTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = onMypageBtnTapped).requiredWidth(147.02490234375.dp).requiredHeight(58.997314453125.dp).relayDropShadow(
            color = Color(
                alpha = 63,
                red = 0,
                green = 0,
                blue = 0
            ),
            borderRadius = 0.0.dp,
            blur = 4.0.dp,
            offsetX = 0.0.dp,
            offsetY = 4.0.dp,
            spread = 0.0.dp
        )
    )
}

@Composable
fun LogoutBtn(
    onLogoutBtnTapped: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = "LOGOUT",
        fontSize = 13.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 115,
            green = 115,
            blue = 115
        ),
        height = 1.4479999542236328.em,
        textAlign = TextAlign.Left,
        underline = true,
        modifier = modifier.tappable(onTap = onLogoutBtnTapped).wrapContentHeight(
            align = Alignment.Bottom,
            unbounded = true
        )
    )
}

@Composable
fun TopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 250,
            green = 240,
            blue = 202
        ),
        isStructured = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}
