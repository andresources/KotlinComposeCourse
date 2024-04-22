package com.mindorks.example.kotlincomposecourse.testing

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text

@Composable
fun TestingComp1() {
    Column{
        Text(text = "Done", color = Color.Black)
    }
}

@Composable
fun TestingComp2ButtonClick() {
    var show = remember{ mutableStateOf(false) }
    Column{
        Button(onClick = {
            show.value = true
        }) {
            Text(text = "Submit")
        }
        if(show.value == true) {
            Text(text = "Hai", color = Color.Black)
        }
    }
}
@Composable
fun TestingComp3EditText() {
    var txt = remember{ mutableStateOf("") }
    Column{
        TextField(value = txt.value, onValueChange = {
            txt.value = it
        }, label = {
            Text(text = "Enter Name")
        })
    }
}