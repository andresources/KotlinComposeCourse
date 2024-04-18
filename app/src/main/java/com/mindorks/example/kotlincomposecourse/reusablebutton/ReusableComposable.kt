package com.mindorks.example.kotlincomposecourse.reusablebutton

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun ReusableComposable() {
   // SimpleButtonReusable()
    TextFieldReusable()
}

@Composable
fun SimpleButtonReusable() {
    val context = LocalContext.current
    var data = remember { mutableStateOf("") }
    Column{
        TextField(value = data.value, onValueChange = {
            data.value = it
        })
        ReusableButtonComposable {
            Toast.makeText(context,data.value,Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun TextFieldReusable() {
    val context = LocalContext.current
    Column{
        ReusableTextFieldComp {
            Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
        }
    }
}