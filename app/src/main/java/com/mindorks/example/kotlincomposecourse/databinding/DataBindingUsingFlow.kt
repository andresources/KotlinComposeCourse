package com.example.example1.databinding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/*
@Composable
fun DataBindingUsingFlowDemo() {
    val data by getData().collectAsState(initial = "")
    Text(text = data)
}
fun getData(): Flow<String> = flow {
    emit("Initial value")
    delay(1000)
    emit("New value")
}*/
@Composable
fun DataBindingUsingFlowDemo() {
    val viewModel = remember { FlowViewModel() } // or viewModel() etc.
    val password by viewModel.password.collectAsState()
    Column(modifier = Modifier.padding(10.dp)){
        TextField(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
            value = password,
            //onValueChange = viewModel::onPasswordChanged
            onValueChange = {
                viewModel.onPasswordChanged(it)
            }
        )
        /*when{
            password.length < 4 -> Text(text = "Week", color = Color.Red)
            password.length < 10 -> Text(text = "OK",color = Color.Yellow)
            password.length >= 10 -> Text(text = "Strong",color = Color.Green)
        }*/
        when(password.length){
          in 0..4  -> {Text(text = "Week", color = Color.Red)}
            in 5..9  ->{Text(text = "OK",color = Color.Yellow)}
            else -> {Text(text = "Strong",color = Color.Green)}
        }
    }
}
