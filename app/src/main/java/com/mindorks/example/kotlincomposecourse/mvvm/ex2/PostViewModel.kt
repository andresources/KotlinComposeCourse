package com.mindorks.example.kotlincomposecourse.mvvm.ex2

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    private val apiService = RetrofitInstance.api
    val posts = mutableStateListOf<Post>()

    private val _uiState: MutableStateFlow<List<Post>> = MutableStateFlow(listOf())
    val uiState = _uiState.asStateFlow()

    fun getPosts() {
        viewModelScope.launch {
            delay(5000L)
            try {
                val response = apiService.getPosts()
                if (response.isNotEmpty()) {
                    posts.addAll(response)
                }
                _uiState.value = response
            } catch (e: Exception) {
                // Handle errors here
            }
        }
    }
}