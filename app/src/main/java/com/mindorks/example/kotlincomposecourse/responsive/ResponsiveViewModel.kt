package com.mindorks.example.kotlincomposecourse.responsive

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ResponsiveViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(News())
    val uiState: StateFlow<News> = _uiState

    fun updateDetailsScreenStates(screen: String) {
        _uiState.value.title = screen
    }
}