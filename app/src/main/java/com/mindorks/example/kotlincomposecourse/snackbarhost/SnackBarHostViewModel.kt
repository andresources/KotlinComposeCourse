package com.mindorks.example.kotlincomposecourse.snackbarhost

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SnackBarHostViewModel : ViewModel() {
     var _sb_status = mutableStateOf(false)
    fun updateStatus(){
        _sb_status.value = true
    }
}