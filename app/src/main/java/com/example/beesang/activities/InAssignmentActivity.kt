package com.example.beesang.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.beesang.composes.assignment.InAssignmentCompose
import com.example.beesang.ui.theme.BeeSangTheme
import com.google.relay.compose.RelayText

class InAssignmentActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeeSangTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val id = intent.getIntExtra("id", 0)
                    val week = intent.getIntExtra("week", 0)
                    val title = intent.getStringExtra("title")
                    val content = intent.getStringExtra("description")

                    InAssignmentCompose(
                        applicationContext = applicationContext,
                        id = id,
                        week = week,
                        title = title,
                        content = content,
                        onBackBtnTapped = { onBackBtnTapped() },
                        onHomeBtnTapped = { onHomeBtnTapped() },
                        refreshActivity = { refreshActivity() }
                    )
                }
            }
        }
    }

    private fun onBackBtnTapped() {
        finish()
    }
    private fun onHomeBtnTapped() {
        val intent = Intent(this, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
        finish()
    }
    private fun refreshActivity() {
        finish()
        overridePendingTransition(0, 0)
        val intent = intent
        startActivity(intent)
        overridePendingTransition(0, 0)
    }
}