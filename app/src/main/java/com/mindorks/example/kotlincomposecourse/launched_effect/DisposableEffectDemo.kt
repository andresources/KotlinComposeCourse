package com.example.example1.launched_effect

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.DisposableEffectResult
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DisposableEffectDemo() {
    var status by remember { mutableStateOf(false) }
    var data1 by remember { mutableStateOf("Init")}
    Column(modifier = Modifier.padding(1.dp)) {
        Text( text = "$status")
        Text( text = "$data1")
        Button(onClick = {
            status = true
        }) {
            Text(text = "Submit")
        }
    }
    DisposableEffect(key1 = Unit) {
        data1 = "${(0..1000).random()}"
        onDispose {

        }
    }
}