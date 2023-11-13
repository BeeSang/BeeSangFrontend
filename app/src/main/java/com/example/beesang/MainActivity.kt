package com.example.beesang

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.beesang.activities.GameActivity
import com.example.beesang.activities.HomeActivity
import com.example.beesang.activities.LoginActivity
import com.example.beesang.composes.welcome.WelcomeCompose
import com.example.beesang.ui.theme.BeeSangTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeeSangTheme {
                // A surface container using the 'background' color from the theme
                // initial commit2
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WelcomeCompose(onButtonTapped = { startBtnClick() })
                }
            }
        }
    }

    private fun startBtnClick() {
//        서비스 완성 후 주석 해제
        Intent(this, LoginActivity::class.java).also {
            startActivity(it)
        }

//        개발을 위한 임시 코드 - 서비스 완성 후 제거
//        Intent(this, HomeActivity::class.java).also {
//            startActivity(it)
//        }
//        Intent(this, GameActivity::class.java).also {
//            startActivity(it)
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    BeeSangTheme {
        WelcomeCompose()
    }
}