package com.example.example1.state

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
/*LaunchedEffect is a composable function that is used to launch a coroutine inside the scope of composable, when LaunchedEffect enters the composition, it launches a coroutine and cancels when it leaves composition.
LaunchedEffect takes multiple keys as params and if any of the key changes it cancels the existing coroutine and launch again.
This is useful for performing side effects, such as making network calls or updating a database, without blocking the UI thread.*/
// Side Effect
private var i = 0
@Composable
fun SideEffectDemo8() {
    var text by remember {
        mutableStateOf("")
    }
    Column {
        Button(onClick = { text += "@" }) {
            i++
            Text(text)
        }
    }
}
//Above is not correct way
// Launched Effect -> non composable operations
//Alternative - rememberCoroutineScope
private var j = 0

@Composable
fun SideEffect() {
    var text by remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = text) {
        i++
    }
    Column {
        Button(onClick = { text += "@" }) {
            Text(text)
        }
    }
}

