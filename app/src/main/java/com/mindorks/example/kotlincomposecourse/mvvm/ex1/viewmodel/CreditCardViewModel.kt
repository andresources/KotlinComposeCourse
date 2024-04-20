package com.mindorks.example.kotlincomposecourse.mvvm.ex1.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindorks.example.kotlincomposecourse.mvvm.ex1.api.CreditCard
import com.mindorks.example.kotlincomposecourse.mvvm.ex1.repo.CreditCardRepository
import kotlinx.coroutines.launch

class CreditCardViewModel : ViewModel() {
    private val repository = CreditCardRepository()

    private val _creditCards = MutableLiveData<CreditCard>()
    val creditCards: LiveData<CreditCard> = _creditCards

    fun fetchCreditCards() {
        viewModelScope.launch {
            try {
                val cards = repository.getCreditCards()
                _creditCards.value = cards
            } catch (e: Exception) {
                Log.i("zzz",e.message.toString())
            }
        }
    }
}