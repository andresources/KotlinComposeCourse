package com.mindorks.example.kotlincomposecourse.animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

//The AnimatedContent composable animates its content as it changes based on a target state.
@Composable
fun AnimatedContentDemo() {
   // AnimatedContentSimple()
    //AnimatedContentAdv()

}

@Composable
fun AnimatedContentSimple() {
    Row {
        var count by remember { mutableStateOf(0) }
        Button(onClick = { count++ }) {
            Text("Add")
        }
        AnimatedContent(targetState = count) { targetCount ->
            // Make sure to use `targetCount`, not `count`.
            Text(text = "Count: $targetCount")
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentAdv() {
    Row {
        var count by remember { mutableStateOf(0) }
        Button(onClick = { count++ }) {
            Text("+")
        }
        Button(onClick = { count-- }) {
            Text("-")
        }
        AnimatedContent(targetState = count,
            transitionSpec = {
                // Compare the incoming number with the previous number.
                if (targetState < initialState) {
                    // If the target number is larger, it slides up and fades in
                    // while the initial (smaller) number slides up and fades out.
                    slideInVertically { height -> height } + fadeIn() with
                            slideOutVertically { height -> -height } + fadeOut()
                } else {
                    // If the target number is smaller, it slides down and fades in
                    // while the initial number slides down and fades out.
                    slideInVertically { height -> -height } + fadeIn() with
                            slideOutVertically { height -> height } + fadeOut()
                }.using(
                    // Disable clipping since the faded slide-in/out should
                    // be displayed out of bounds.
                    SizeTransform(clip = false)
                )
            }
        ) { targetCount ->
            // Make sure to use `targetCount`, not `count`.
            Text(text = "Count: $targetCount")
        }
    }
}

