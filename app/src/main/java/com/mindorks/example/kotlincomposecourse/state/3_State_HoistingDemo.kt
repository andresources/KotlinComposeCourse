package com.example.example1.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun CustomCardStateViewModel(viewModel: StateHoistingViewModel){
    //val chkState : Boolean by viewModel.isDone.observeAsState(false)
    val chkState : Boolean by viewModel.isDoneFlow.collectAsState(false)
    CreateCustomCard1("My Card - Flow",chkState){
        viewModel.onCheckboxChange(it)
    }
}