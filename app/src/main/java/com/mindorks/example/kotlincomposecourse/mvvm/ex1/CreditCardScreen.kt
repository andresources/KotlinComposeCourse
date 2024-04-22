package com.mindorks.example.kotlincomposecourse.mvvm.ex1

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text
import com.mindorks.example.kotlincomposecourse.mvvm.ex1.viewmodel.CreditCardViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
@Composable
fun CreditCardScreen(viewModel: CreditCardViewModel = viewModel()){
    val creditCard by viewModel.creditCards.observeAsState()
    var context = LocalContext.current
    Column {
        if (creditCard?.credit_card_type.isNullOrEmpty()) {
            // Show loading indicator or placeholder
            Text(text = "Loading...", color = Color.Blue)
        } else {
            Text(text = "success", color = Color.Blue)
            LazyColumn {
                item {
                    Text(text = creditCard?.credit_card_number.toString(), color = Color.Blue)
                    Text(text = creditCard?.credit_card_expiry_date.toString(), color = Color.Blue)
                    Text(text = creditCard?.credit_card_type.toString(), color = Color.Blue)
                    Divider() // Add a divider between items
                }
            }
        }
    }
    LaunchedEffect(Unit) {
        viewModel.fetchCreditCards()
    }
}