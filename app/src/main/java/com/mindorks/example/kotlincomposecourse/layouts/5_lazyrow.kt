package com.mindorks.example.kotlincomposecourse.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text

@Composable
fun LazyRowDemo() {
    SimpleLazyRow()
}

@Composable
fun SimpleLazyRow() {
    LazyRow(modifier = Modifier.background(color = Color.Blue)) {
        item {
            repeat(50){
                Text(text = "Text - $it", modifier = Modifier.padding(start = 10.dp, end = 10.dp))
            }
        }
    }
}