package com.mindorks.example.kotlincomposecourse.kotlinflows.stateflow

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun StateFlowFruitsComposables(fruitsViewModel: StateFlowFruitsViewModel) {
     //StateFlow : The ViewModel survives configuration changes and therefore will preserve the contents of the StateFlow, a behavior similar to LiveData.
     val fruit = fruitsViewModel.fruitsStateFlow.collectAsState()
     //collectAsState : establishes a subscription to a Flow maintained by our ViewModel.
     /*LaunchedEffect(Unit){
        fruit.collect{

        }
     }*/
    Column{
        Text(text = "Fruit : ${fruit.value}")
        Button(onClick = {
            fruitsViewModel.onBtnClicked()
        }) {
            Text(text = "Get Fruit")
        }
    }
}