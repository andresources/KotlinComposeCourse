package com.mindorks.example.kotlincomposecourse.interactors

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.wear.compose.material.Text

@Composable
fun CartButtonInteractor() {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    Column{
        Button(
            onClick = { },
            interactionSource = interactionSource
        ) {
            AnimatedVisibility(visible = isPressed) {
                if (isPressed) {
                    Row {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = null)
                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    }
                }
            }
            Text(text = "Add to Cart")
        }
    }
}