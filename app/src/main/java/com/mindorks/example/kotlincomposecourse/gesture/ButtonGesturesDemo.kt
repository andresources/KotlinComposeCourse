package com.mindorks.example.kotlincomposecourse.gesture

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ButtonGesturesComposable() {
    var txt = remember{
        mutableStateOf("")
    }
    Box(modifier = Modifier.testTag("box_tag")
        .padding(50.dp) //margin
        .background(Color.Red)
        .fillMaxSize()
        .combinedClickable(
            onLongClick = {
                txt.value = "onLongClicked"
            },
            onDoubleClick = {
                txt.value = "onDoubleClicked"
            },
            onClick = {
                txt.value = "onClicked"
            }
        )) {
        Text(text = txt.value)
    }
}