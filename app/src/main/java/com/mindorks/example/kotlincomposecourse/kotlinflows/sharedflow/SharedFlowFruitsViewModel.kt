package com.mindorks.example.kotlincomposecourse.kotlinflows.sharedflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SharedFlowFruitsViewModel : ViewModel() {
    private val _sharedflowFruits = MutableSharedFlow<String>()
    val sharedflowFruits = _sharedflowFruits.asSharedFlow()
    //val sharedflowFruits: SharedFlow<String> = _sharedflowFruits.asSharedFlow()
    private val fruitsList = listOf( "apple", "tomato", "banana")
    fun onBtnClicked(){
        viewModelScope.launch {
            val fruit = fruitsList.random()
            _sharedflowFruits.emit(fruit)
        }
    }
}