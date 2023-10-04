package com.example.beesang.activitys

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
import com.example.beesang.composes.login.LoginCompose
import com.example.beesang.ui.theme.BeeSangTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeeSangTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginCompose(
                        onEnterBtnTapped = { enterBtnClick() },
                        onRegisterBtnTapped = { registerBtnClick() }
                    )
                }
            }
        }
    }

    private fun enterBtnClick() {
        Intent(this, HomeActivity::class.java).also {
            startActivity(it)
        }
    }
    private fun registerBtnClick() {
        Intent(this, RegisterActivity::class.java).also {
            startActivity(it)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    BeeSangTheme {
        LoginCompose()
    }
}