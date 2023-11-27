package com.example.beesang.composes.register

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.beesang.R
import com.example.beesang.composes.BackBtn
import com.example.beesang.composes.BackgroundImg
import com.example.beesang.composes.TopLevel
import com.example.beesang.login.notoSansKR
import com.google.relay.compose.BoxScopeInstanceImpl.align
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.relayDropShadow
import com.google.relay.compose.tappable

/**
 * Register Screen V2
 *
 * This composable was generated from the UI Package 'register'.
 * Generated code; do not edit directly
 *
 * @param onRegisterBtnTapped on registerBtn tapped
 * @param onBackBtn2Tapped on backBtn2 tapped
 */
@Composable
fun RegisterCompose(
    id: String = "", onIdChange: (String) -> Unit,
    password: String = "", onPasswordChange: (String) -> Unit,
    checkPassword: String = "", onCheckPasswordChange: (String) -> Unit,
    name: String = "", onNameChange: (String) -> Unit,
    school: String = "", onSchoolChange: (String) -> Unit,
    studentId: String = "", onStudentIdChange: (String) -> Unit,
    onRegisterBtnTapped: () -> Unit = {},
    onBackBtn2Tapped: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    TopLevel(modifier = modifier) {
        BackgroundImg()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(start = 20.dp, top = 20.dp)
            ) {
                BackBtn(
                    onBackBtnTapped = { onBackBtn2Tapped() },
                )
                Spacer(modifier = Modifier.weight(1.0f))
            }
            Spacer(modifier = Modifier.requiredHeight(30.dp))
            RegisterTop()
            Spacer(modifier = Modifier.requiredHeight(20.dp))
            Id(id, onIdChange)
            Spacer(modifier = Modifier.requiredHeight(14.dp))
            Password(password, onPasswordChange)
            Spacer(modifier = Modifier.requiredHeight(14.dp))
            CheckPassword(checkPassword, onCheckPasswordChange)
            Spacer(modifier = Modifier.requiredHeight(14.dp))
            Name(name, onNameChange)
            Spacer(modifier = Modifier.requiredHeight(14.dp))
            School(school, onSchoolChange)
            Spacer(modifier = Modifier.requiredHeight(14.dp))
            StudentId(studentId, onStudentIdChange)
            Spacer(modifier = Modifier.requiredHeight(24.dp))
            RegisterButton(onBtnTapped = onRegisterBtnTapped)
        }
    }
}

@Composable
fun PH(content: String, modifier: Modifier = Modifier) {
    RelayText(
        content = content,
        fontSize = 15.0.sp,
        fontFamily = notoSansKR,
        color = Color(
            alpha = 255,
            red = 115,
            green = 115,
            blue = 115
        ),
        height = 1.4479999542236328.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Id(id:String, onIdChange: (String) -> Unit, modifier: Modifier = Modifier) {
//    var text by remember { mutableStateOf("") }

    TextField(
        value = id,
        placeholder = { PH("아이디*(영문소문자/숫자, 4~16자)") },
        shape = MaterialTheme.shapes.small,
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        onValueChange = onIdChange,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(password: String, onPasswordChange: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(
        value = password,
        placeholder = { PH("비밀번호*(영문소문자/숫자, 8~16자)") },
        shape = MaterialTheme.shapes.small,
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
        onValueChange = onPasswordChange,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckPassword(checkPassword: String, onCheckPasswordChange: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(
        value = checkPassword,
        placeholder = { PH("비밀번호 확인*") },
        shape = MaterialTheme.shapes.small,
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
        onValueChange = onCheckPasswordChange,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Name(name: String, onNameChange: (String) -> Unit, modifier: Modifier = Modifier) {
//    var text by remember { mutableStateOf("") }

    TextField(
        value = name,
        placeholder = { PH("이름*") },
        shape = MaterialTheme.shapes.small,
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        onValueChange = onNameChange,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun School(school: String, onSchoolChange: (String) -> Unit, modifier: Modifier = Modifier) {
//    var text by remember { mutableStateOf("") }

    TextField(
        value = school,
        placeholder = { PH("학교*") },
        shape = MaterialTheme.shapes.small,
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        onValueChange = onSchoolChange,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentId(studentId: String, onStudentIdChange: (String) -> Unit, modifier: Modifier = Modifier) {
//    var text by remember { mutableStateOf("") }

    TextField(
        value = studentId,
        placeholder = { PH("학년 반 번호* (ex.1학년 2반 1번-10201)") },
        shape = MaterialTheme.shapes.small,
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        onValueChange = onStudentIdChange
    )
}

@Composable
fun InputAutoLayout(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        itemSpacing = 20.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredHeight(504.0.dp)
    )
}

@Composable
fun InputBox(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .requiredWidth(274.0.dp)
            .requiredHeight(504.0.dp)
    )
}

@Composable
fun Title(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.register_title),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(180.0.dp)
            .requiredHeight(75.0.dp)
    )
}

@Composable
fun RegisterRectangle(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.register_register_rectangle),
        modifier = modifier
            .requiredWidth(122.0.dp)
            .requiredHeight(47.0.dp)
            .relayDropShadow(
                color = Color(
                    alpha = 63,
                    red = 0,
                    green = 0,
                    blue = 0
                ),
                borderRadius = 50.0.dp,
                blur = 4.0.dp,
                offsetX = 0.0.dp,
                offsetY = 4.0.dp,
                spread = 0.0.dp
            )
    )
}

@Composable
fun RegisterText(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.register_register_text),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(85.6123046875.dp)
            .requiredHeight(22.8299560546875.dp)
    )
}

@Composable
fun RegisterBtn(
    onRegisterBtnTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .tappable(onTap = onRegisterBtnTapped)
            .requiredWidth(122.0.dp)
            .requiredHeight(47.0.dp)
    )
}

@Composable
fun BackBtn2(
    onBackBtn2Tapped: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayImage(
        image = painterResource(R.drawable.register_back_btn2),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .tappable(onTap = onBackBtn2Tapped)
            .requiredWidth(43.0.dp)
            .requiredHeight(44.0.dp)
    )
}

@Composable
fun MiddleFrame(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .requiredWidth(295.0.dp)
            .requiredHeight(730.0.dp)
    )
}
