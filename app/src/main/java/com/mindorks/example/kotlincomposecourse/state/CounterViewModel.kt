package com.example.example1.state

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _counter: MutableLiveData<Int> = MutableLiveData(0)
     val counter: LiveData<Int> = _counter
    fun incrementCount(){
        _counter.value = _counter.value?.plus(1)
    }
}