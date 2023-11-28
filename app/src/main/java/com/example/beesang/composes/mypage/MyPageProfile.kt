package com.example.beesang.composes.mypage

import androidx.compose.foundation.Image
import com.example.beesang.mypageprofile.notoSansKR

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.beesang.R
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.tappable

@Composable
fun MyPageProfile(
    modifier: Modifier = Modifier,
    imgPath: String,
    onUpdateBtnTapped: () -> Unit = {}
) {
    MyPageProfileTopLevel(modifier = modifier) {
        MypageProfileProfile(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopCenter,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 0.0.dp
                )
            )
        ) {
            MypageProfileProfileUpdateButton(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 10.0.dp,
                        y = 127.0.dp
                    )
                ).tappable(onTap = { onUpdateBtnTapped() })
            )
            MypageProfileProfileBg()
            MypageProfileProfileImage(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 4.0.dp,
                        y = 4.0.dp
                    )
                ),
                imgPath = imgPath
            )
        }
    }
}

@Composable
fun MypageProfileProfileUpdateButton(modifier: Modifier = Modifier) {
    RelayText(
        content = "사진 또는 아바타 수정",
        fontSize = 12.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 175,
            green = 135,
            blue = 76
        ),
        height = 1.4479999542236328.em,
        modifier = modifier
    )
}

@Composable
fun MypageProfileProfileBg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.mypage_profile_mypage_profile_profile_bg),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(127.0.dp).requiredHeight(127.0.dp)
    )
}

@Composable
fun MypageProfileProfileImage(modifier: Modifier = Modifier, imgPath: String) {
    RelayImage(
        image = painterResource(R.drawable.mypage_profile_mypage_profile_profile_image),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(114.0.dp).requiredHeight(113.0.dp)
    )
    Image(
        painter = rememberImagePainter(
            data = "https://beesang.s3.ap-northeast-2.amazonaws.com/user/$imgPath",
            builder = {
                crossfade(true)
            }
        ),
        modifier = modifier
            .size(113.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop,
        contentDescription = null // Provide content description if needed
    )
}

/*
*     painter = painterResource(id = R.drawable.dog),
    contentDescription = stringResource(id = R.string.dog_content_description),
    contentScale = ContentScale.Crop,
    modifier = Modifier
        .size(200.dp)
        .clip(CircleShape)
* */

@Composable
fun MypageProfileProfile(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(127.0.dp).requiredHeight(144.0.dp)
    )
}

@Composable
fun MyPageProfileTopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).requiredHeight(150.dp)
    )
}
