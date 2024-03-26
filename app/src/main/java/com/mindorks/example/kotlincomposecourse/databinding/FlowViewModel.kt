package com.example.example1.databinding

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FlowViewModel {
    private val _password = MutableStateFlow<String>("")
    val password: StateFlow<String> = _password

    fun onPasswordChanged(password: String) {
        _password.value = password
    }
}