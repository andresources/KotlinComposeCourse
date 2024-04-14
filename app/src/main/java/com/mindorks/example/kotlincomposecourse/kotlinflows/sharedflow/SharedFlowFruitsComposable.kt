package com.mindorks.example.kotlincomposecourse.kotlinflows.sharedflow

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.mindorks.example.kotlincomposecourse.kotlinflows.stateflow.StateFlowFruitsViewModel

@Composable
fun SharedFlowFruitsComposable(fruitsViewModel: SharedFlowFruitsViewModel) {
    val fruit = fruitsViewModel.sharedflowFruits
    val msg = remember { mutableStateOf("") }
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        fruit.collect {
            msg.value = it
        }
    }
    Column{
        Text(text = msg.value)
        Button(onClick = {
            fruitsViewModel.onBtnClicked()
        }) {
            Text(text = "Get Fruit")
        }
    }
}