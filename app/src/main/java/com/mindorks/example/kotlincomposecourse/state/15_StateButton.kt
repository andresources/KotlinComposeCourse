package com.mindorks.example.kotlincomposecourse.state

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun StateButton() {
    var count = remember { mutableStateOf(0) } //remember : to retain count var.
    var count1 = remember { mutableStateOf(0) }
    Column {
        Text("Count : ${count.value}") //redraw -> recomposition
        Text("Count1 : ${count1.value}")//not - recomposition
        Button(onClick = {
            count.value = count.value + 1
        }) {
            Text(text = "Submit")
        }
    }
    
    /*val count = remember { mutableStateOf(0) }
    Column{
        Text("Count : ${count.value}")
        Button(onClick = {
            count.value = count.value + 1
        }) {
            Text(text = "Clicked")
        }
    }*/
}