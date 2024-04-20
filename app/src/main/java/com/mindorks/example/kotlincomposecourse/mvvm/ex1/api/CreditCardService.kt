package com.mindorks.example.kotlincomposecourse.mvvm.ex1.api

import com.mindorks.example.kotlincomposecourse.mvvm.ex1.api.CreditCard
import retrofit2.http.GET

interface CreditCardService {
    @GET("credit_cards")
    suspend fun getCreditCards(): CreditCard
}