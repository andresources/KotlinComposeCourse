package com.mindorks.example.kotlincomposecourse.mvvm.ex2

import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List < Post >
}