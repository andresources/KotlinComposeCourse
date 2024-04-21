package com.mindorks.example.kotlincomposecourse.mvvm.ex3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindorks.example.kotlincomposecourse.mvvm.ex2.RetrofitInstance
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GenericPostsViewModel: ViewModel() {
    private val apiService = RetrofitInstance.api
    val state = MutableStateFlow<State>(State.START)
    init {
        getPosts()
    }
    private fun getPosts() {
        viewModelScope.launch {
            delay(3000L)
            state.value = State.LOADING
            delay(5000L)
            try {
                val response = apiService.getPosts()
                state.value = State.SUCCESS(response)

            } catch (e: Exception) {
                state.value = State.FAILURE(e.localizedMessage)
            }
        }
    }

}