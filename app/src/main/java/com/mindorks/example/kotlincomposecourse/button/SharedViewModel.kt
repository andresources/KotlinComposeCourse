package com.example.example1.button

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    var fabOnClick = mutableStateOf({})
    var smallFabOnClick = mutableStateOf({})

    val expandedFab = mutableStateOf(true)
}