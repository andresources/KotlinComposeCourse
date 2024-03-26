package com.example.example1.databinding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier

@Composable
fun DataBindingUsingLiveDataDemo(viewModel: MyViewModel = MyViewModel()) {
    val data by viewModel.data.observeAsState()
    Column {
        data?.let {
            Text(text = it)
        }
        Button(modifier = Modifier.wrapContentHeight(), onClick = { viewModel.setData() }) {
            Text(text = "Get New Data")
        }
    }
}