package com.example.example1.dropdown.listsgrids

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EmpList(){
    // Smoothly scroll 100px on first composition
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(500) }
    var listEmp = mutableListOf<Emp>()
    loadFakeData(listEmp)
    //modifier = Modifier.verticalScroll(state)
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        listEmp.forEach {
            EmpCard(it)
        }
    }
}



