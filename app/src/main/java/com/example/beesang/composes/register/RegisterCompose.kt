package com.example.beesang.composes.register

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.beesang.R
import com.example.beesang.login.notoSansKR
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
        AutoLayout {
            AutoLayoutSynth {
                BackgroundImg()
            }
            MiddleFrame(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 57.0.dp,
                        y = 71.0.dp
                    )
                )
            ) {
                InputBox(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 21.0.dp,
                            y = 143.0.dp
                        )
                    )
                ) {
                    InputAutoLayout {
                        Id(id, onIdChange)
                        Password(password, onPasswordChange)
                        CheckPassword(checkPassword, onCheckPasswordChange)
                        Name(name, onNameChange)
                        School(school, onSchoolChange)
                        StudentId(studentId, onStudentIdChange)
                    }
                }
                Title(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 68.0.dp,
                            y = 0.0.dp
                        )
                    )
                )
                RegisterBtn(
                    onRegisterBtnTapped = onRegisterBtnTapped,
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 96.0.dp,
                            y = 683.0.dp
                        )
                    )
                ) {
                    RegisterRectangle(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.Center,
                            offset = DpOffset(
                                x = -4.0.dp,
                                y = 0.0.dp
                            )
                        )
                    )
                    RegisterText(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 19.0.dp,
                                y = 13.0.dp
                            )
                        )
                    )
                }
                BackBtn2(
                    onBackBtn2Tapped = onBackBtn2Tapped,
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 16.0.dp
                        )
                    )
                )
            }
        }
    }
}

@Composable
fun BackgroundImg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.register_background_img),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(430.0.dp).requiredHeight(932.0.dp)
    )
}

@Composable
fun AutoLayoutSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 10.0,
        content = content,
        modifier = modifier.requiredWidth(430.0.dp).requiredHeight(932.0.dp).alpha(alpha = 100.0f)
    )
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
        placeholder = { PH("아이디") },
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
//    var text by remember { mutableStateOf("") }

    TextField(
        value = password,
        placeholder = { PH("비밀번호") },
        shape = MaterialTheme.shapes.small,
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        onValueChange = onPasswordChange,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckPassword(checkPassword: String, onCheckPasswordChange: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(
        value = checkPassword,
        placeholder = { PH("비밀번호 확인") },
        shape = MaterialTheme.shapes.small,
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
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
        placeholder = { PH("이름") },
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
        placeholder = { PH("학교") },
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
        placeholder = { PH("학번") },
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
        modifier = modifier.requiredWidth(274.0.dp).requiredHeight(504.0.dp)
    )
}

@Composable
fun Title(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.register_title),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(180.0.dp).requiredHeight(75.0.dp)
    )
}

@Composable
fun RegisterRectangle(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.register_register_rectangle),
        modifier = modifier.requiredWidth(122.0.dp).requiredHeight(47.0.dp).relayDropShadow(
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
        modifier = modifier.requiredWidth(85.6123046875.dp).requiredHeight(22.8299560546875.dp)
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
        modifier = modifier.tappable(onTap = onRegisterBtnTapped).requiredWidth(122.0.dp).requiredHeight(47.0.dp)
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
        modifier = modifier.tappable(onTap = onBackBtn2Tapped).requiredWidth(43.0.dp).requiredHeight(44.0.dp)
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
        modifier = modifier.requiredWidth(295.0.dp).requiredHeight(730.0.dp)
    )
}

@Composable
fun AutoLayout(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier.requiredWidth(430.0.dp).requiredHeight(932.0.dp)
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
