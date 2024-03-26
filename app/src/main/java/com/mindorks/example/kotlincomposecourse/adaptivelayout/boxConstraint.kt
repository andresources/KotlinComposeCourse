package com.example.example1.adaptivelayout

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun boxConstraintDemo() {
        BoxWithConstraints(modifier = Modifier.padding(16.dp)) {
            when (this.maxWidth) {
                in (0.dp..600.dp) -> {
                    Text(text = "Potriate Screen")
                }
                in (601.dp..900.dp) -> {
                    Text(text = "LandScape Screen")
                }
            }
        }
}

