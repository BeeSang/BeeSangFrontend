package com.example.beesang.composes.mypage

import com.example.beesang.mypageinfo.notoSansKR

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
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

/**
 * asdf
 *
 * This composable was generated from the UI Package 'mypage_info'.
 * Generated code; do not edit directly
 */
@Composable
fun MyPageInfo(
    modifier: Modifier = Modifier,
    username: String,
    schoolName: String,
    studentId: String,
    imgPath: String
) {
    MyPageInfoTopLevel(modifier = modifier) {
        MypageInfoInfo(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
        ) {
            InassignmentIndexbarIndexbarBg()
            MypageInfoInfoUsername(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 167.0.dp,
                        y = 56.0.dp
                    )
                ),
                username = username
            )
            MypageInfoInfoSchool(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 167.0.dp,
                        y = 100.0.dp
                    )
                ),
                schoolName = schoolName
            )
            MypageInfoInfoStudentID(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 167.0.dp,
                        y = 144.0.dp
                    )
                ),
                studentId = studentId
            )
            MypageInfoInfoHeader(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = -52.0.dp,
                        y = 5.0.dp
                    )
                )
            )
            MypageInfoInfoTitle(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 25.0.dp,
                        y = 61.0.dp
                    )
                )
            )
        }
    }
}
@Composable
fun InassignmentIndexbarIndexbarBg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.mypage_info_inassignment_indexbar_indexbar_bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(359.0.dp).requiredHeight(39.0.dp)
    )
}

@Composable
fun MypageInfoInfoUsername(modifier: Modifier = Modifier, username: String) {
    RelayText(
        content = username,
        fontSize = 15.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 90,
            green = 66,
            blue = 46
        ),
        height = 1.4479999542236328.em,
        textAlign = TextAlign.Left,
        modifier = modifier
    )
}

@Composable
fun MypageInfoInfoSchool(modifier: Modifier = Modifier, schoolName: String) {
    RelayText(
        content = schoolName,
        fontSize = 15.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 90,
            green = 66,
            blue = 46
        ),
        height = 1.4479999542236328.em,
        textAlign = TextAlign.Left,
        modifier = modifier
    )
}

@Composable
fun MypageInfoInfoStudentID(modifier: Modifier = Modifier, studentId: String) {
    RelayText(
        content = studentId,
        fontSize = 15.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 90,
            green = 66,
            blue = 46
        ),
        height = 1.4479999542236328.em,
        textAlign = TextAlign.Left,
        modifier = modifier
    )
}

@Composable
fun MypageInfoInfoHeader(modifier: Modifier = Modifier) {
    RelayText(
        content = "내 정보",
        fontSize = 20.0.sp,
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
        modifier = modifier.requiredWidth(233.0.dp)
    )
}

@Composable
fun MypageInfoInfoTitle(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.mypage_info_mypage_info_info_title),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(75.0.dp).requiredHeight(102.33331298828125.dp)
    )
}

@Composable
fun MypageInfoInfo(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(359.0.dp).requiredHeight(166.0.dp)
    )
}

@Composable
fun MyPageInfoTopLevel(
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
        modifier = modifier.fillMaxWidth(1.0f).requiredHeight(170.dp)
    )
}
