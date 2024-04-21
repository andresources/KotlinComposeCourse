package com.mindorks.example.kotlincomposecourse.reusablebutton

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.wear.compose.material.Button

@Composable
fun DemoComposable() {
    val context = LocalContext.current
    Column{
        ReuseForm(onClicked = {
           Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
        }, onHiClicked = {
            Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
        })
    }
}

