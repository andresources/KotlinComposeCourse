package com.example.example1.state

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun ViewModelStateManagement(viewModel: CounterViewModel ) {
    val conter = viewModel.counter.observeAsState()
    Column {
        Text(text = "Counter : ${conter.value}")
        Button(onClick = { viewModel.incrementCount() }) {
            Text(text = "Click Me")
        }
    }
}