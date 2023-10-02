package com.example.beesang.composes.welcome

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.beesang.R
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayVector
import com.google.relay.compose.relayDropShadow
import com.google.relay.compose.tappable

/**
 * Welcome Screen V2
 *
 * This composable was generated from the UI Package 'welcome'.
 * Generated code; do not edit directly
 *
 * @param onButtonTapped on button tapped
 */
@Composable
fun WelcomeCompose(
    modifier: Modifier = Modifier,
    onButtonTapped: () -> Unit = {}
) {
    TopLevel(modifier = modifier) {
        WholeLayout {
            AutoLayout(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                BackgroundImg1(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 1.0.dp
                        )
                    )
                )
                AutoLayoutSynth {
                    MiddleFrame(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                        TitleGroup(
                            modifier = Modifier.boxAlign(
                                alignment = Alignment.TopStart,
                                offset = DpOffset(
                                    x = 85.0.dp,
                                    y = 12.0.dp
                                )
                            )
                        ) {
                            BeeLogo(
                                modifier = Modifier.boxAlign(
                                    alignment = Alignment.TopCenter,
                                    offset = DpOffset(
                                        x = -0.5.dp,
                                        y = 0.0.dp
                                    )
                                )
                            ) {
                                Bee()
                            }
                            Title(
                                modifier = Modifier.boxAlign(
                                    alignment = Alignment.TopCenter,
                                    offset = DpOffset(
                                        x = 0.0.dp,
                                        y = 162.0.dp
                                    )
                                )
                            )
                        }
                        Button(
                            onButtonTapped = onButtonTapped,
                            modifier = Modifier.boxAlign(
                                alignment = Alignment.BottomCenter,
                                offset = DpOffset(
                                    x = -0.5.dp,
                                    y = -14.0.dp
                                )
                            )
                        ) {
                            Rectangle25(
                                modifier = Modifier.boxAlign(
                                    alignment = Alignment.TopStart,
                                    offset = DpOffset(
                                        x = -4.0.dp,
                                        y = 0.0.dp
                                    )
                                )
                            )
                            ButtonText(
                                modifier = Modifier.boxAlign(
                                    alignment = Alignment.BottomStart,
                                    offset = DpOffset(
                                        x = 24.0.dp,
                                        y = -12.0.dp
                                    )
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(widthDp = 430, heightDp = 927)
@Composable
private fun WelcomePreview() {
    MaterialTheme {
        RelayContainer {
            WelcomeCompose(
                onButtonTapped = {},
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun BackgroundImg1(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.welcome_background_img_1),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(430.0.dp).requiredHeight(927.0.dp)
    )
}

@Composable
fun Bee(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.welcome_bee),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(197.0.dp).requiredHeight(149.0.dp)
    )
}

@Composable
fun BeeLogo(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(197.0.dp).requiredHeight(149.0.dp)
    )
}

@Composable
fun Title(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.welcome_title),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(256.0.dp).requiredHeight(85.0.dp)
    )
}

@Composable
fun TitleGroup(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(256.0.dp).requiredHeight(247.0.dp)
    )
}

@Composable
fun Rectangle25(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.welcome_rectangle_25),
        modifier = modifier.requiredWidth(161.0.dp).requiredHeight(55.0.dp).relayDropShadow(
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
fun ButtonText(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.welcome_button_text),
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(113.0.dp).requiredHeight(30.0.dp)
    )
}

@Composable
fun Button(
    onButtonTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = onButtonTapped).requiredWidth(161.0.dp).requiredHeight(55.0.dp)
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
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
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
            top = 250.0.dp,
            end = 0.0.dp,
            bottom = 250.0.dp
        ),
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(430.0.dp).requiredHeight(927.0.dp).alpha(alpha = 100.0f)
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
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun WholeLayout(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(430.0.dp).requiredHeight(927.0.dp)
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
