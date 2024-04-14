package com.mindorks.example.kotlincomposecourse.kotlinflows.stateflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StateFlowFruitsViewModel : ViewModel() {
    private val fruitsList = listOf( "apple", "tomato", "banana")
    private val _fruitsStateFlow = MutableStateFlow("")
    val fruitsStateFlow = _fruitsStateFlow.asStateFlow()
    //val fruitsStateFlow: StateFlow<String> = _fruitsStateFlow
    fun onBtnClicked(){
        viewModelScope.launch {
            val fruit = fruitsList.random()
            _fruitsStateFlow.emit(fruit)
        }
    }
}