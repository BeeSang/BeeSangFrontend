package com.example.beesang.composes.lecture

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.unit.sp
import com.example.beesang.R
import com.example.beesang.composes.welcome.Button
import com.example.beesang.composes.welcome.WelcomeCompose
import com.example.beesang.login.notoSansKR
import com.google.relay.compose.BoxScopeInstance.boxAlign
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.tappable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizTimeCard(
    time: Int,
    title: String,
    question: String,
    description: String,
    answer: Boolean,
    modifier: Modifier = Modifier,
) {
    var isAnswerVisible by remember { mutableStateOf(false) }
    if(!isAnswerVisible) {
        Card(
            onClick = {isAnswerVisible = !isAnswerVisible},
            colors = CardDefaults.cardColors(
                containerColor = Color(
                    alpha = 255,
                    red = 255,
                    green = 251,
                    blue = 238
                )
            ),
            shape = RoundedCornerShape(14.dp),
            modifier = modifier
                .requiredHeight(120.0.dp)
                .fillMaxWidth(0.8f)
                .boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 0.0.dp
                    )
                )
        ) {
            Column(
                modifier = modifier
                    .padding(8.0.dp)
                    .fillMaxWidth(1.0f)
                    .fillMaxHeight(1.0f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 0.0.dp,
                                y = 0.0.dp
                            )
                        )
                        .fillMaxWidth(1.0f)
                        .requiredHeight(40.0.dp)
                        .padding(start = 10.0.dp, end = 10.0.dp)
                ) {
                    Text(
                        text = time.toString() + "차시",
                        fontSize = 15.0.sp,
                        fontWeight = FontWeight(700.0.toInt()),
                        fontFamily = notoSansKR,
                        color = Color(
                            alpha = 255,
                            red = 115,
                            green = 115,
                            blue = 115
                        ),
                        textAlign = TextAlign.Left,
                        modifier = modifier
                    )
                    Spacer(Modifier.weight(1.0f))
                    RelayImage(
                        image = painterResource(R.drawable.arrow_under),
                        contentScale = ContentScale.Crop,
                        modifier = modifier
                            .requiredWidth(20.0.dp)
                            .requiredHeight(20.0.dp)
                            .boxAlign(
                                alignment = Alignment.TopEnd,
                                offset = DpOffset(
                                    x = 0.0.dp,
                                    y = 0.0.dp
                                )
                            )
                    )
                }
                Text(
                    text = title,
                    fontSize = 26.0.sp,
                    fontWeight = FontWeight(700.0.toInt()),
                    fontFamily = notoSansKR,
                    color = Color(
                        alpha = 255,
                        red = 109,
                        green = 85,
                        blue = 0
                    ),
                    textAlign = TextAlign.Left,
                    modifier = modifier
                        .fillMaxWidth(1.0f)
//                        .requiredHeight(40.0.dp)
                        .padding(start = 10.0.dp)
                )
            }
        }
    }
    else {
        Card(
            onClick = {isAnswerVisible = !isAnswerVisible},
            colors = CardDefaults.cardColors(
                containerColor = Color(
                    alpha = 255,
                    red = 255,
                    green = 251,
                    blue = 238
                )
            ),
            shape = RoundedCornerShape(14.dp),
            modifier = modifier
                .requiredHeight(350.0.dp)
                .fillMaxWidth(0.8f)
                .boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 0.0.dp
                    )
                )
        ) {
            Column(
                modifier = modifier
                    .padding(8.0.dp)
                    .fillMaxWidth(1.0f)
                    .fillMaxHeight(1.0f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 0.0.dp,
                                y = 0.0.dp
                            )
                        )
                        .fillMaxWidth(1.0f)
                        .requiredHeight(40.0.dp)
                        .padding(start = 10.0.dp, end = 10.0.dp)
                ) {
                    Text(
                        text = time.toString() + "차시",
                        fontSize = 15.0.sp,
                        fontWeight = FontWeight(700.0.toInt()),
                        fontFamily = notoSansKR,
                        color = Color(
                            alpha = 255,
                            red = 115,
                            green = 115,
                            blue = 115
                        ),
                        textAlign = TextAlign.Left,
                        modifier = modifier
                    )
                    Spacer(Modifier.weight(1.0f))
                    RelayImage(
                        image = painterResource(R.drawable.arrow_top),
                        contentScale = ContentScale.Crop,
                        modifier = modifier
                            .requiredWidth(20.0.dp)
                            .requiredHeight(20.0.dp)
                            .boxAlign(
                                alignment = Alignment.TopEnd,
                                offset = DpOffset(
                                    x = 0.0.dp,
                                    y = 0.0.dp
                                )
                            )
                    )
                }
                Text(
                    text = title,
                    fontSize = 26.0.sp,
                    fontWeight = FontWeight(700.0.toInt()),
                    fontFamily = notoSansKR,
                    color = Color(
                        alpha = 255,
                        red = 109,
                        green = 85,
                        blue = 0
                    ),
                    textAlign = TextAlign.Left,
                    modifier = modifier
                        .fillMaxWidth(1.0f)
//                        .requiredHeight(40.0.dp)
                        .padding(start = 10.0.dp)
                )
                Text(
                    text = "QUIZ!",
                    fontSize = 30.0.sp,
                    fontWeight = FontWeight(700.0.toInt()),
                    fontFamily = notoSansKR,
                    color = Color(
                        alpha = 255,
                        red = 84,
                        green = 39,
                        blue = 0
                    ),
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .fillMaxWidth(1.0f)
                )
                Text(
                    text = question,
                    fontSize = 14.0.sp,
                    fontWeight = FontWeight(700.0.toInt()),
                    fontFamily = notoSansKR,
                    color = Color(
                        alpha = 255,
                        red = 84,
                        green = 39,
                        blue = 0
                    ),
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .fillMaxWidth(1.0f)
                )
                Spacer(modifier = Modifier.height(20.0.dp))

                var submit by remember { mutableStateOf(false) }
                var isAnswer by remember { mutableStateOf(true) }
                if(!submit) {
                    Row(
                        modifier = modifier
                            .fillMaxWidth(1.0f)
                            .padding(start = 20.0.dp, end = 20.0.dp)
                    ) {
                        OutlinedButton(
                            onClick = {
                                if(answer) isAnswer = true;
                                else isAnswer = false;
                                submit = true;
                            },
                            modifier = modifier
                                .requiredWidth(120.0.dp)
                        ) {
                            Text("O")
                        }
                        Spacer(modifier = Modifier.weight(1.0f))
                        OutlinedButton(
                            onClick = {
                                if(answer) isAnswer = false;
                                else isAnswer = true;
                                submit = true;
                            },
                            modifier = modifier
                                .requiredWidth(120.0.dp)
                        ) {
                            Text("X")
                        }
                    }
                }
                else {
                    if(isAnswer) {
                        Text(
                            text = "정답입니다!",
                            fontSize = 14.0.sp,
                            fontWeight = FontWeight(700.0.toInt()),
                            fontFamily = notoSansKR,
                            color = Color(
                                alpha = 255,
                                red = 84,
                                green = 39,
                                blue = 0
                            ),
                            textAlign = TextAlign.Center,
                            modifier = modifier
                                .fillMaxWidth(1.0f)
                        )
                    } else {
                        Text(
                            text = "오답입니다!",
                            fontSize = 14.0.sp,
                            fontWeight = FontWeight(700.0.toInt()),
                            fontFamily = notoSansKR,
                            color = Color(
                                alpha = 255,
                                red = 84,
                                green = 39,
                                blue = 0
                            ),
                            textAlign = TextAlign.Center,
                            modifier = modifier
                                .fillMaxWidth(1.0f)
                        )
                    }

//                    Text(
//                        text = description,
//                        fontSize = 14.0.sp,
//                        fontWeight = FontWeight(700.0.toInt()),
//                        fontFamily = notoSansKR,
//                        color = Color(
//                            alpha = 255,
//                            red = 84,
//                            green = 39,
//                            blue = 0
//                        ),
//                        textAlign = TextAlign.Center,
//                        modifier = modifier
//                            .fillMaxWidth(1.0f)
//                    )
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
            QuizTimeCard(
                time = 1,
                title = "기후위기의 발생과 원인1",
                question = "기후위기의 발생과 원인2",
                description = "기후위기의 발생과 원인3",
                answer = true,
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            )
        }
    }
}