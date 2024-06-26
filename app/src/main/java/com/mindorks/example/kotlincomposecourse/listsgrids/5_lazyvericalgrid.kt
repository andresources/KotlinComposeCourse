package com.example.example1.dropdown.listsgrids

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LazyVerticalGridDemo(){
    var listEmp = mutableListOf<Emp>()
    //loadFakeData(listEmp)

    //100 Emp List
    repeat(100){
        listEmp.add(Emp("Name: $it",10000))
    }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
        //columns = GridCells.Fixed(2)
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

