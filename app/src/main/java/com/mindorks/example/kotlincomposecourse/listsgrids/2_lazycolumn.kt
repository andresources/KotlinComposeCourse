package com.example.example1.dropdown.listsgrids

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LazyColumnList(){
    var listEmp = mutableListOf<Emp>()
    loadFakeData(listEmp)
    LazyColumn(){
        item {
            Text(text = "Header")
        }
        items(items = listEmp, key = {
            it.ename
        }){
            EmpCard(e = it)
        }
        /*itemsIndexed(listEmp){index, item ->

        }*/
        item {
            Text(text = "Footer")
        }
    }

}

