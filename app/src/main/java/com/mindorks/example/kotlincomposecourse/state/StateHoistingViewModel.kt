package com.example.example1.state

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StateHoistingViewModel : ViewModel() {
    private val _isDone : MutableLiveData<Boolean> =  MutableLiveData(false)
    val isDone : LiveData<Boolean> = _isDone
    private val _isDoneFlow : MutableStateFlow<Boolean> =  MutableStateFlow(false)
    val isDoneFlow : StateFlow<Boolean> = _isDoneFlow.asStateFlow()
    fun onCheckboxChange(state:Boolean) {
        _isDone.value = state
        viewModelScope.launch {
            _isDoneFlow.emit(state)
        }

    }
}