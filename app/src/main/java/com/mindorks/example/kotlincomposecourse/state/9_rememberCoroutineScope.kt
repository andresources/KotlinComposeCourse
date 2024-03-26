package com.example.example1.state

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Launched Effect
//Alternative - rememberCoroutineScope
//It is a composable function that returns a coroutine scope bound to the point of Composable where its called.
// The scope will be cancelled when the call leaves the composition.
@Composable
fun MyCoroutineScopeComposable() {
    val myscope = rememberCoroutineScope()
    val txt = remember{ mutableStateOf("") }
    val isLoading = remember{ mutableStateOf(false) }
    Column{
        if(isLoading.value){
            Text(text = "Loading from Server")
        }
        Button(onClick = {
            myscope.launch {
                isLoading.value = true
                delay(3000)
                isLoading.value = false
                txt.value = "Data from Server"
            }
        }) {
            Text(text = "Submit")
        }
        Text(text = "Response: ${txt.value}")
    }
}
//rememberCoroutineScope is used to create a coroutine scope that is tied to the Composable function's lifecycle.
//You can use the launch function within the scope to easily and safely manage asynchronous operations.
