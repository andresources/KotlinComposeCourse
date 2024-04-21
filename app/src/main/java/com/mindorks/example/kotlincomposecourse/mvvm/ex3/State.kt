package com.mindorks.example.kotlincomposecourse.mvvm.ex3

import com.mindorks.example.kotlincomposecourse.mvvm.ex2.Post

sealed class State {
    object START : State()
    object LOADING : State()
    data class SUCCESS(val posts: List<Post>) : State()
    data class FAILURE(val message: String) : State()
}