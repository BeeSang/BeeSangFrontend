package com.example.beesang.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.beesang.composes.assignment.AssignmentCompose
import com.example.beesang.ui.theme.BeeSangTheme

class AssignmentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeeSangTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AssignmentCompose(
                        onBackBtnTapped = { onBackBtnTapped() },
                        onHomeBtnTapped = { onHomeBtnTapped() },
                        onCardAssignmentTapped = { id, week, title, description -> onCardAssignmentTapped(id, week, title, description) }
                    )
                }
            }
        }
    }

    private fun onCardAssignmentTapped(id: Long, week: Int, title: String, description: String) {
        val intent = Intent(this, InAssignmentActivity::class.java)
        intent.putExtra("id", id.toInt())
        intent.putExtra("week", week)
        intent.putExtra("title", title)
        intent.putExtra("description", description)
        startActivity(intent)
    }

    private fun onBackBtnTapped() {
        finish()
    }
    private fun onHomeBtnTapped() {
        finish()
    }
}