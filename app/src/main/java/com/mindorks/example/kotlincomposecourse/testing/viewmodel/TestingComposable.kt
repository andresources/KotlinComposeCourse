package com.mindorks.example.kotlincomposecourse.testing.viewmodel

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.material.Text

@Composable
fun TestingComposable(viewModel: TestingViewModel = viewModel()) {
    val data by viewModel.data.collectAsState("Loading")
    Column{
        Text(text = data,color = Color.Black)
    }
}