package com.example.example1.dropdown.listsgrids

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LazyRowEmpList(){
    var listEmp = mutableListOf<Emp>()
    loadFakeData(listEmp)
    LazyRow{
        item {
            Text(text = "Header")
        }
        items(listEmp){
            EmpCard(e = it)
        }
        /*itemsIndexed(listEmp){index, item ->

        }*/
        item {
            Text(text = "Footer")
        }
    }
}