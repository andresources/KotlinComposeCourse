package com.mindorks.example.kotlincomposecourse.reusablebutton

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.wear.compose.material.Button

@Composable
fun ReuseForm(onClicked : (String) -> Unit,onHiClicked : (String) -> Unit) {
    var data = remember { mutableStateOf("") }
    Column {
        TextField(value = data.value, onValueChange = {
            data.value = it
        })
        Button(onClick = {
            onClicked.invoke(data.value)
        }) {
            Text(text = "Click")
        }
        Button(onClick = {
            onHiClicked.invoke("Hi")
        }) {
            Text(text = "Hi")
        }
    }
}