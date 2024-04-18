package com.mindorks.example.kotlincomposecourse.animations

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text

@Composable
fun AnimatedContentSizeDemo() {
    var expanded by remember { mutableStateOf(false) }
    Column{
        Button(onClick = { expanded = !expanded }) {
            Text("Click")
        }
        Box(
            modifier = Modifier
                .background(Color.Red)
                .animateContentSize()
                .height(if (expanded) 400.dp else 0.dp)
                .fillMaxWidth()
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    expanded = !expanded
                }

        ) {
        }
    }
}