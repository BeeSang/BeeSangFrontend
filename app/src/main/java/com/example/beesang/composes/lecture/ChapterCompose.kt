package com.example.beesang.composes.lecture

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.beesang.composes.TopLevel
import com.example.beesang.composes.layout.BackgroundImg

@Composable
fun ChapterCompose(
    modifier: Modifier = Modifier
) {
    TopLevel(modifier = modifier) {
        BackgroundImg()
    }
}