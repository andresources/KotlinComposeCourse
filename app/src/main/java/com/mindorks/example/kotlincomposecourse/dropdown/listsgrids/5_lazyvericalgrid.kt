package com.example.example1.dropdown.listsgrids

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun LazyVerticalGridDemo(){
    var listEmp = mutableListOf<Emp>()
    loadFakeData(listEmp)
    LazyVerticalGrid(
        //columns = GridCells.Adaptive(minSize = 128.dp)
        columns = GridCells.Fixed(2)
    ){
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
