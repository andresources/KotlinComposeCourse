package com.example.example1

import androidx.activity.compose.BackHandler
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun BackbuttonHandler() {
    var backPressCount by remember { mutableStateOf(0) }
    Text(text = "Welcome")
    Text(text = "Clicked : $backPressCount")
    BackHandler{
        backPressCount ++
    }
}