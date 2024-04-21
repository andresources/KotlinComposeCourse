package com.mindorks.example.kotlincomposecourse.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text

@Composable
fun ShowHideTextDemo() {
    val fg = remember { mutableStateOf(false) }
    Column{
        Button(onClick = { fg.value = true }) {
            Text(text = "Show")
        }
        Button(onClick = { fg.value = false }) {
            Text(text = "Hide")
        }
        if(fg.value==true){
            //MyTextComp()
            Dialog(onDismissRequest = { fg.value = false }) {
                Card(modifier = Modifier.size(width = 300.dp, height = 75.dp)){
                    Column{
                        Text(text = "This is title",color = Color.Black, modifier = Modifier.padding(10.dp))
                        TextButton(onClick = {
                            fg.value = false
                        }) {
                            Text(text = "Close",color = Color.Black, fontSize = 18.sp)
                        }
                    }
                }


            }
        }
    }
}

@Composable
fun MyTextComp() {
    Text(text = "This is sample",color = Color.Red)
}
