package com.mindorks.example.kotlincomposecourse.reusablebutton

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ReusableTextFieldComp(onClicked : (String)-> Unit) {
    var text by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier.padding(5.dp),
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        label = { Text(text = "Your Name") },
        placeholder = { Text(text = "Please enter Your name") },
    )
    Button(onClick = {
        onClicked.invoke(text)
    }) {
        Text(text = "Submit")
    }
}


