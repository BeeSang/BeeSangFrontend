package com.example.beesang.composes.mypage

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beesang.composes.BackBtn
import com.example.beesang.composes.home.TopLevel
import com.example.beesang.login.notoSansKR
import com.example.beesang.retrofit.response.UserReadResponse
import com.example.beesang.retrofit.uploadAssignmentImage
import com.example.beesang.retrofit.userProfileUpload
import com.example.beesang.retrofit.userRead
import com.google.relay.compose.BoxScopeInstanceImpl.align
import com.google.relay.compose.RelayText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream
import java.util.UUID

@SuppressLint("CoroutineCreationDuringComposition", "Recycle")
@Composable
fun MyPageHome(
    modifier: Modifier = Modifier,
    applicationContext: Context,
    onBackBtnTapped: () -> Unit = {},
    refreshActivity: () -> Unit = {},
) {
    TopLevel(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(start = 20.dp, top = 20.dp)
            ) {
                BackBtn(onBackBtnTapped = { onBackBtnTapped() })
                Spacer(modifier = Modifier.weight(1.0f))
            }
            RelayText(
                content = "마이페이지",
                fontSize = 34.0.sp,
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
            Spacer(modifier = Modifier.requiredHeight(30.0.dp))

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
                        scope.launch { userProfileUpload(applicationContext, body) }
                    }

                    Thread.sleep(1500)
                    refreshActivity()
                }
            }

            val scope = CoroutineScope(Dispatchers.IO)
            val results = remember { mutableStateOf<UserReadResponse?>(null) }
            scope.launch { results.value = userRead(applicationContext) }

            results.value?.let {
                MyPageProfile(
                    onUpdateBtnTapped = { pickImage.launch("image/*") },
                    imgPath = it.imgPath
                )
                Spacer(modifier = Modifier.requiredHeight(30.0.dp))
                MyPageInfo(
                    username = it.username, schoolName = it.schoolName,
                    studentId = it.studentId, imgPath = it.imgPath
                )
            }
        }
    }
}

private fun resizeInputStream(inputStream: InputStream, maxSize: Int): InputStream {
    val bitmap = BitmapFactory.decodeStream(inputStream)
    val scale = maxSize.toFloat() / inputStream.available().toFloat()

    if (scale >= 1.0) {
        return ByteArrayInputStream(inputStream.readBytes())
    }

    val width = (bitmap.width * scale).toInt()
    val height = (bitmap.height * scale).toInt()
    val resizedBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true)

    val outputStream = ByteArrayOutputStream()
    resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 80, outputStream)

    return ByteArrayInputStream(outputStream.toByteArray())
}