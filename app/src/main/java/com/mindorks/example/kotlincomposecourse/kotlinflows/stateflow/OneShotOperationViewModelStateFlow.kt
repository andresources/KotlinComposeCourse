package com.mindorks.example.kotlincomposecourse.kotlinflows.stateflow

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class OneShotOperationViewModelStateFlow : ViewModel() {
    var toastMessage by mutableStateOf(value = "")

}