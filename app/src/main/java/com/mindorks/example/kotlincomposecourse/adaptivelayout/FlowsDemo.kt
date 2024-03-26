package com.example.example1.adaptivelayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.compose.ui.Modifier

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowRowSample() {
    val colors = remember {
        listOf(Color.Yellow, Color.LightGray, Color.Cyan)
    }

        FlowRow(modifier = Modifier.padding(16.dp)) {
            for (i in 0..20) {
                Box(
                    modifier = Modifier.padding(4.dp)
                        .width(100.dp)
                        .height(60.dp)
                        .background(colors[i % 3])
                ) {
                    Text("Item $i", modifier = Modifier.padding(4.dp))
                }
            }
        }

}