package com.example.example1.state

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow

//snapshotFlow is a function that allows you to create a flow that emits the current value of a state object, and then emits any subsequent changes to that object. This can be useful for creating reactive UIs that respond to changes in state, without having to manually manage callbacks or listeners.
@Composable
fun SnapshotFlowDemo() {
    val count = remember { mutableStateOf(0) }

    val countFlow = snapshotFlow { count.value }

    LaunchedEffect(countFlow) {
        countFlow.collect { value ->

        }
    }

    Button(onClick = { count.value++ }) {
        Text("Clicked ${count.value} times")
    }
}