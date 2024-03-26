package com.example.example1.databinding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DataBindingUsingState() {
    val (data, setData) = remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(10.dp)) {
        TextField(modifier = Modifier.padding(10.dp).wrapContentHeight().fillMaxWidth(),
            value = data,
            onValueChange = { newData ->
                setData(newData)
            }
        )
        Text(modifier = Modifier.padding(10.dp).wrapContentHeight().fillMaxWidth(),text = data)
    }

}