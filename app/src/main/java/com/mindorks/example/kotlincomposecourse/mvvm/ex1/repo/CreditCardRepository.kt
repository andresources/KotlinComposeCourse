package com.mindorks.example.kotlincomposecourse.mvvm.ex1.repo

import com.mindorks.example.kotlincomposecourse.mvvm.ex1.api.RetrofitInstance
import com.mindorks.example.kotlincomposecourse.mvvm.ex1.api.CreditCard

class CreditCardRepository {
    private val creditCardService = RetrofitInstance.creditCardService

    suspend fun getCreditCards(): CreditCard {
        return creditCardService.getCreditCards()
    }
}