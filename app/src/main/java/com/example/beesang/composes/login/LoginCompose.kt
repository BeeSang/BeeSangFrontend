package com.example.beesang.composes.login

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.beesang.R
import com.example.beesang.login.notoSansKR
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.relayDropShadow
import com.google.relay.compose.tappable

/**
 * Login Screen V3
 *
 * This composable was generated from the UI Package 'login'.
 * Generated code; do not edit directly
 *
 * @param onFindPasswordBtnTapped on findPasswordBtn tapped
 * @param onEnterBtnTapped on enterBtn tapped
 * @param onRegisterBtnTapped on registerBtn tapped
 */
@Composable
fun LoginCompose(
    modifier: Modifier = Modifier,
    onFindPasswordBtnTapped: () -> Unit = {},
    onEnterBtnTapped: () -> Unit = {},
    onRegisterBtnTapped: () -> Unit = {}
) {
    TopLevel(modifier = modifier) {
        AutoLayout(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 1.0.dp
                )
            )
        ) {
            BackgroundImg(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 1.0.dp
                    )
                )
            )
            AutoLayoutSynth {
                MiddleFrame {
                    MiddleGroup(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 78.0.dp,
                                y = 140.0.dp
                            )
                        )
                    ) {
                        FindPasswordBtn(
                            onFindPasswordBtnTapped = onFindPasswordBtnTapped,
                            modifier = Modifier.boxAlign(
                                alignment = Alignment.Center,
                                offset = DpOffset(
                                    x = 99.0.dp,
                                    y = 18.5.dp
                                )
                            )
                        )
                        ButtonBox(
                            modifier = Modifier.boxAlign(
                                alignment = Alignment.TopStart,
                                offset = DpOffset(
                                    x = 0.0.dp,
                                    y = 185.0.dp
                                )
                            )
                        ) {
                            EnterBtn(
                                onEnterBtnTapped = onEnterBtnTapped,
                                modifier = Modifier.boxAlign(
                                    alignment = Alignment.TopCenter,
                                    offset = DpOffset(
                                        x = -76.0.dp,
                                        y = 0.0.dp
                                    )
                                )
                            ) {
                                EnteRectangle(
                                    modifier = Modifier.boxAlign(
                                        alignment = Alignment.Center,
                                        offset = DpOffset(
                                            x = -4.0.dp,
                                            y = 0.0.dp
                                        )
                                    )
                                )
                                EnterText(
                                    modifier = Modifier.boxAlign(
                                        alignment = Alignment.Center,
                                        offset = DpOffset(
                                            x = 0.30615234375.dp,
                                            y = 0.9150390625.dp
                                        )
                                    )
                                )
                            }
                            RegisterBtn(
                                onRegisterBtnTapped = onRegisterBtnTapped,
                                modifier = Modifier.boxAlign(
                                    alignment = Alignment.TopStart,
                                    offset = DpOffset(
                                        x = 153.0.dp,
                                        y = 0.0.dp
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
                                        alignment = Alignment.Center,
                                        offset = DpOffset(
                                            x = -0.19384765625.dp,
                                            y = 0.9150390625.dp
                                        )
                                    )
                                )
                            }
                        }
                        RememberIdBox(
                            modifier = Modifier.boxAlign(
                                alignment = Alignment.TopStart,
                                offset = DpOffset(
                                    x = 0.0.dp,
                                    y = 125.0.dp
                                )
                            )
                        ) {
                            RememberIdText(
                                modifier = Modifier.boxAlign(
                                    alignment = Alignment.Center,
                                    offset = DpOffset(
                                        x = 11.5.dp,
                                        y = -0.5.dp
                                    )
                                )
                            )
                            RememberCheckBox(
                                modifier = Modifier.boxAlign(
                                    alignment = Alignment.Center,
                                    offset = DpOffset(
                                        x = -34.0.dp,
                                        y = 1.0.dp
                                    )
                                )
                            )
                        }
                        InputBox(
                            modifier = Modifier.boxAlign(
                                alignment = Alignment.TopStart,
                                offset = DpOffset(
                                    x = 1.0.dp,
                                    y = 0.0.dp
                                )
                            )
                        ) {
                            InputId {
                                IdRectangle()
                            }
                            InputPassword(
                                modifier = Modifier.boxAlign(
                                    alignment = Alignment.TopStart,
                                    offset = DpOffset(
                                        x = 0.0.dp,
                                        y = 67.0.dp
                                    )
                                )
                            ) {
                                PasswordRectangle(
                                    modifier = Modifier.boxAlign(
                                        alignment = Alignment.Center,
                                        offset = DpOffset(
                                            x = 0.0.dp,
                                            y = 0.0.dp
                                        )
                                    )
                                )
                            }
                        }
                    }
                    Title(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 139.0.dp,
                                y = 0.0.dp
                            )
                        )
                    )
                }
            }
        }
    }
}

@Preview(widthDp = 430, heightDp = 927)
@Composable
private fun LoginPreview() {
    MaterialTheme {
        RelayContainer {
            LoginCompose(
                onFindPasswordBtnTapped = {},
                onEnterBtnTapped = {},
                onRegisterBtnTapped = {},
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun BackgroundImg(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.login_background_img),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(430.0.dp).requiredHeight(932.0.dp)
    )
}

@Composable
fun FindPasswordBtn(
    onFindPasswordBtnTapped: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = "비밀번호 찾기",
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
        modifier = modifier.tappable(onTap = onFindPasswordBtnTapped).wrapContentHeight(
            align = Alignment.Bottom,
            unbounded = true
        )
    )
}

@Composable
fun EnteRectangle(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.login_ente_rectangle),
        modifier = modifier.requiredWidth(123.0.dp).requiredHeight(47.0.dp).relayDropShadow(
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
fun EnterText(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.login_enter_text),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(85.6123046875.dp).requiredHeight(22.830078125.dp)
    )
}

@Composable
fun EnterBtn(
    onEnterBtnTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = onEnterBtnTapped).requiredWidth(123.0.dp).requiredHeight(47.0.dp)
    )
}

@Composable
fun RegisterRectangle(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.login_register_rectangle),
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
        image = painterResource(R.drawable.login_register_text),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(85.6123046875.dp).requiredHeight(22.830078125.dp)
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
fun ButtonBox(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(275.0.dp).requiredHeight(47.0.dp)
    )
}

@Composable
fun RememberIdText(modifier: Modifier = Modifier) {
    RelayText(
        content = "아이디 저장",
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
        modifier = modifier
    )
}

@Composable
fun RememberCheckBox(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.login_remember_check_box),
        modifier = modifier.requiredWidth(18.0.dp).requiredHeight(18.0.dp)
    )
}

@Composable
fun RememberIdBox(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(86.0.dp).requiredHeight(20.0.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IdRectangle(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        placeholder = { Id() },
        shape = MaterialTheme.shapes.small,
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        onValueChange = {text = it},
    )
}

@Composable
fun Id(modifier: Modifier = Modifier) {
    RelayText(
        content = "아이디",
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

@Composable
fun InputId(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(274.0.dp).requiredHeight(43.0.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordRectangle(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        placeholder = { Password() },
        shape = MaterialTheme.shapes.small,
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        onValueChange = {text = it},
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
fun Password(modifier: Modifier = Modifier) {
    RelayText(
        content = "비밀번호",
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

@Composable
fun InputPassword(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 5.0,
        content = content,
        modifier = modifier.requiredWidth(274.0.dp).requiredHeight(43.0.dp)
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
        modifier = modifier.requiredWidth(274.0.dp).requiredHeight(110.0.dp)
    )
}

@Composable
fun MiddleGroup(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(275.0.dp).requiredHeight(232.0.dp)
    )
}

@Composable
fun Title(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.login_title),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(153.0.dp).requiredHeight(64.0.dp)
    )
}

@Composable
fun MiddleFrame(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier.requiredWidth(430.0.dp).requiredHeight(487.0.dp)
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
        padding = PaddingValues(
            start = 0.0.dp,
            top = 209.0.dp,
            end = 0.0.dp,
            bottom = 209.0.dp
        ),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.alpha(alpha = 100.0f)
    )
}

@Composable
fun AutoLayout(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
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
