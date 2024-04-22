package com.mindorks.example.kotlincomposecourse.testing.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TestingViewModel : ViewModel() {
    val data: Flow<String> = flow{
        delay(2000L)
        emit("Welcome")
    }
}