package com.example.example1.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val data = MutableLiveData<String>("Init Data")
    fun setData(){
        data.value = "New Data"
    }
}