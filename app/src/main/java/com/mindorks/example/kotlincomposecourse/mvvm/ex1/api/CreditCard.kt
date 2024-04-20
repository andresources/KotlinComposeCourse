package com.mindorks.example.kotlincomposecourse.mvvm.ex1.api

data class CreditCard(
    val id: Int,
    val credit_card_expiry_date: String,
    val credit_card_number: String,
    val credit_card_type: String
)