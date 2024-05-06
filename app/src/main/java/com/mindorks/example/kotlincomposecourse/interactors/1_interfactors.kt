package com.mindorks.example.kotlincomposecourse.interactors

import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.wear.compose.material.Text
import kotlinx.coroutines.flow.collect

@Composable
fun ButtonInteractor() {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    Column{
        Button(
            onClick = { },
            interactionSource = interactionSource
        ) {
            Text(text = "Click Me")
        }
        Text(color = Color.Red, text = if(isPressed) "Pressed" else "Not Pressed")
    }
}

@Composable
fun ButtonInteractorFlow() {
    val interactionSource = remember { MutableInteractionSource() }
    val status = remember{ mutableStateOf("No-Interaction") }
    Column{
        Button(
            onClick = { },
            interactionSource = interactionSource
        ) {
            Text(text = "Click Me")
        }
        LaunchedEffect(interactionSource){
            interactionSource.interactions.collect{interaction ->
                when (interaction) {
                    is PressInteraction.Press -> {
                        status.value = "Pressed"
                    }
                    is PressInteraction.Release -> {
                        status.value = "Released"
                    }
                    is PressInteraction.Cancel -> {
                        status.value = "Canceled"
                    }
                    is DragInteraction.Start -> {
                        status.value = "Started"
                    }
                    is DragInteraction.Stop -> {
                        status.value = "Stoped"
                    }
                    is DragInteraction.Cancel -> {
                        status.value = "Canceled"
                    }
                }
            }
        }

        Text(color = Color.Red, text = status.value)
    }
}