package com.mindorks.example.kotlincomposecourse.kotlinflows.stateflow

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel

//OneShotOperation using StateFlow is not good chose: Correct one : Shared Flow
@Composable
fun OneShotOperationUsingStateFlowComp(viewmodel: OneShotOperationViewModelStateFlow = viewModel()) {
    val context = LocalContext.current
    LaunchedEffect(key1 = viewmodel.toastMessage){
        if(viewmodel.toastMessage.isNotEmpty()){
            Toast.makeText(context, viewmodel.toastMessage, Toast.LENGTH_SHORT,).show()
            viewmodel.toastMessage = ""
        }
    }
    Column {
        Button(onClick = {
            viewmodel.toastMessage = "This is toast message"
        }) {
            Text(text = "Show Toast")
        }
    }
}
