package com.example.example1.launched_effect

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.math.nextDown

@Composable
fun LaunchedEffectDemo() {
    var txtData by remember { mutableStateOf("Init Value") }
    var lefg1 by remember { mutableStateOf("0") }
    var lefg2 by remember { mutableStateOf("0") }
    Column(modifier = Modifier.padding(1.dp)) {
        Text( text = txtData)
        Button(onClick = {
            lefg1 = "${(0..1000).random()}"
        }) {
            Text(text = "Submit")
        }
        Button(onClick = {
            lefg2 = "${(0..1000).random()}"
        }) {
            Text(text = "Click Me")
        }
    }
    //key - Unit or someValue
    LaunchedEffect(key1 = lefg1,key2 = lefg2){
        // Your asynchronous task here
        delay(2000L)

        txtData = "New Value - ${(0..1000).random()}"
    }
}