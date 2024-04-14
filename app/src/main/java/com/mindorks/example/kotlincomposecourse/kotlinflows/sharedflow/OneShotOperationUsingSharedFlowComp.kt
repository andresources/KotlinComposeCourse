package com.mindorks.example.kotlincomposecourse.kotlinflows.sharedflow

import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun OneShotOperationUsingSharedFlowComp(viewmodel: OneShotOperationUsingSharedFlowViewModel = viewModel()) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewmodel.toastMessage.collect{
            Toast.makeText(
                context,
                it,
                Toast.LENGTH_SHORT,
            ).show()
        }
    }
    Button(
        onClick = {
            viewmodel.sendMessage("Sample Toast")
        },
    ) {
        Text(text = "Show Toast")
    }
}