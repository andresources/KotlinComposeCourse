package com.mindorks.example.kotlincomposecourse.reusablebutton

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ReusableButtonComposable(onClicked : ()-> Unit) {
        Button(onClick = {
            onClicked.invoke()
        }) {
            Text(text = "Submit")
        }
}