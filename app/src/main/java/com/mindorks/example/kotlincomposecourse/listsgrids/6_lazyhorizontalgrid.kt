package com.example.example1.dropdown.listsgrids

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun LazyHorizontalGridDemo(){
    var listEmp = mutableListOf<Emp>()
    //loadFakeData(listEmp)
    repeat(100){
        listEmp.add(Emp("Name: $it",10000))
    }
    LazyHorizontalGrid(
        contentPadding = PaddingValues(all = 10.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        rows = GridCells.Adaptive(minSize = 128.dp), content =
    {
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
    })
}