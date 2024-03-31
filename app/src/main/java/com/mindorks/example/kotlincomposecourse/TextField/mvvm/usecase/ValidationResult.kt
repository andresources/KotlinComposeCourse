package com.mindorks.example.kotlincomposecourse.TextField.mvvm.usecase

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)