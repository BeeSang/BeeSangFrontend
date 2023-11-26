package com.example.beesang.composes.assignment

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.icu.number.Scale
import android.net.Uri
import android.os.Build
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.beesang.composes.NavigationBar
import com.example.beesang.composes.TopLevel
import com.example.beesang.composes.assignment.boards.InAssignmentButton
import com.example.beesang.composes.assignment.boards.LargeBoard
import com.example.beesang.composes.assignment.boards.MidBoard
import com.example.beesang.composes.assignment.boards.SmallBoard
import com.example.beesang.composes.game.GameHeader
import com.example.beesang.login.notoSansKR
import com.example.beesang.retrofit.getUserInfo
import com.example.beesang.retrofit.myAssignmentRead
import com.example.beesang.retrofit.response.FarmUserInfoResponse
import com.example.beesang.retrofit.response.MyAssignmentReadResponse
import com.example.beesang.retrofit.uploadAssignmentImage
import com.google.relay.compose.BoxScopeInstanceImpl.align
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.io.InputStream
import java.util.UUID

@SuppressLint("Recycle", "CoroutineCreationDuringComposition")
@Composable
fun InAssignmentCompose(
    modifier: Modifier = Modifier,
    applicationContext: Context,
    id: Int,
    week: Int,
    title: String?,
    content: String?,
    onBackBtnTapped: () -> Unit = {},
    onHomeBtnTapped: () -> Unit = {},
    refreshActivity: () -> Unit = {}
) {
    val contentResolver: ContentResolver = LocalContext.current.contentResolver
    val pickImage = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        if (uri != null) {
            val inputStream: InputStream? = contentResolver.openInputStream(uri)
            if (inputStream != null) {
                val uuid = UUID.randomUUID().toString()
                val file = File(applicationContext.cacheDir, "$uuid.jpg")
                file.outputStream().use { outputStream ->
                    inputStream.copyTo(outputStream)
                }

                val requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file)
                val body = MultipartBody.Part.createFormData("file", file.name, requestFile)

                val scope = CoroutineScope(Dispatchers.IO)
                scope.launch { uploadAssignmentImage(applicationContext, body, id.toLong()) }
            }

            Toast.makeText(applicationContext, "축하드려요! 10마리의 벌이 살아났어요!", Toast.LENGTH_SHORT).show()
            Thread.sleep(1000)
            refreshActivity()
        }
    }

    val scope = CoroutineScope(Dispatchers.IO)
    val result = remember { mutableStateOf<MyAssignmentReadResponse?>(null) }
    scope.launch { result.value = myAssignmentRead(applicationContext, id.toLong()) }

    var imgLink by remember { mutableStateOf("") }
    result.value?.let {
        imgLink = it.imgLink
    }
    TopLevel(modifier = modifier) {
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            RelayContainer(
                backgroundColor = Color(
                    alpha = 255,
                    red = 255,
                    green = 251,
                    blue = 238
                ),
            ) {
                NavigationBar(onBackBtnTapped, onHomeBtnTapped)
                Spacer(modifier = Modifier.height(10.0.dp))
                RelayText(
                    content = title.toString(),
                    fontSize = 18.0.sp,
                    fontWeight = FontWeight(700.0.toInt()),
                    fontFamily = notoSansKR,
                    color = Color(
                        alpha = 255,
                        red = 109,
                        green = 85,
                        blue = 0
                    ),
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth(1.0f)
                )
                Spacer(modifier = Modifier.height(20.0.dp))
            }
            Spacer(modifier = Modifier.height(20.0.dp))
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                InAssignmentIndexBar(title = "참여 방법")
                Spacer(modifier = Modifier.height(10.0.dp))
                if(id == 1 || id == 2) {
                    LargeBoard(content = content)
                } else if(id == 5 || id == 6) {
                    MidBoard(content = content)
                } else {
                    SmallBoard(content = content)
                }

                if(imgLink != "No Image") {
                    InAssignmentIndexBar(title = "내 참여 내역")
                    Spacer(modifier = Modifier.height(10.0.dp))
                    InAssignmentImage(imgLink = imgLink)
                    Spacer(modifier = Modifier.height(10.0.dp))
                } else {
                    InAssignmentIndexBar(title = "미션 인증하기")
                    Spacer(modifier = Modifier.height(10.0.dp))
                    InAssignmentButton( onAssignmentBtnTapped = { pickImage.launch("image/*") })
                }
            }
        }
    }

}

@Composable
fun InAssignmentImage(modifier: Modifier = Modifier, imgLink: String) {
    Image(
        modifier = modifier
            .requiredWidth(300.dp)
            .requiredHeight(300.dp),
        painter = rememberImagePainter(
            data = "https://beesang.s3.ap-northeast-2.amazonaws.com/assignment/$imgLink",
            builder = {
                crossfade(true)
            }
        ),
        contentDescription = null // Provide content description if needed
    )
}

@Composable
fun InAssignmentTopLevel(
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
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxSize(1.0f)
//            .fillMaxHeight(1.0f)
    )
}