package com.example.example1.state

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

//State Hoisting is a powerful technique that makes your Composable functions more reusable, testable, and maintainable.
//we have a Checkbox composable that we want to reuse in multiple places. 
@Composable
fun MyCheckBox(ckfg : Boolean,onCheckedChangeListener: (Boolean)->Unit) {
    Checkbox(checked =ckfg , onCheckedChange = onCheckedChangeListener)
}

@Composable
fun StateHoistingComposable() {
    var state by remember{ mutableStateOf(false) }
    var btnenabled by remember{ mutableStateOf(false) }
    Column {
        MyCheckBox(ckfg = state) {
            state = it
            btnenabled = state
        }
        Button(onClick = {  }, enabled = btnenabled) {
            Text(text = "Hello")
        }
    }

}