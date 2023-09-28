package com.example.beesang

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.beesang.login.Login
import com.example.beesang.ui.theme.BeeSangTheme

import com.example.beesang.welcome.Welcome

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
//                    val intent = Intent(this, Welcome(
//                        onButtonTapped = {
//                            Log.d("MainActivity", "onButtonTapped")
//                        }
//                    )::class.java)
//                    startActivity(intent)

                    Welcome(onButtonTapped = {
                        Log.d("MainActivity", "onButtonTapped")
                    })
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BeeSangTheme {
        Greeting("Android")
    }
}