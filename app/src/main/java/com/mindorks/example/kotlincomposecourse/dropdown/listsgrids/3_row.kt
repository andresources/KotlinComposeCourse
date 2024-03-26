package com.example.example1.dropdown.listsgrids

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EmpListRow(){
    var listEmp = mutableListOf<Emp>()
    loadFakeData(listEmp)
    //modifier = Modifier.verticalScroll(state)
    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
        listEmp.forEach {
            EmpCard(it)
        }
    }
}