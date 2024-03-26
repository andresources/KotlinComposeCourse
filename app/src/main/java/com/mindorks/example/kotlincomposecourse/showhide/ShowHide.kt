package com.example.example1.showhide

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset

@Composable
fun ShowHideText(text: String, fg : Boolean) {
    AnimatedVisibility(
        visible = fg,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Text(text = "Welcome, $text")
    }
}