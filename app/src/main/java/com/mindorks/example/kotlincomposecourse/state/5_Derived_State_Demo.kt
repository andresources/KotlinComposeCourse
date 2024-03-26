package com.example.example1.state

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

//For 5 clicks enable or disable button
//mutableState -> promote recomposition
//derivedStateOf -> skip recomposition
@Composable
fun DerivedStateOfDemo() {
    var clicks by remember { mutableStateOf(0) }
    val derived by remember(clicks) {
        derivedStateOf { clicks % 5 == 0 }
    }
    Column {
        Button(onClick = { clicks++ }) {
            Text(text = "clicks")
        }
        Button(onClick = { }, enabled = derived) {
            Text(text = "Submit")
        }

        //2. Input Validation
        var txtName by remember { mutableStateOf("") }
        var txtAge by remember { mutableStateOf("") }

        val submitButtonEnabled by remember {
            derivedStateOf { if(txtName.length>4 && txtAge.toInt()>18) true else false }
        }

        TextField(value = txtName, onValueChange = {
            txtName = it
        })
        TextField(value = txtAge, onValueChange = {
            txtAge = it
        })
        Button(onClick = { }, enabled = submitButtonEnabled) {
            Text(text = "Submit")
        }
    }

}