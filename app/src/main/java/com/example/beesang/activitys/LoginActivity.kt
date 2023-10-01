package com.example.beesang.activitys

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.beesang.login.Login
import com.example.beesang.ui.theme.BeeSangTheme

class LoginActivity : ComponentActivity() {
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
                    Login()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    BeeSangTheme {
        Login()
    }
}