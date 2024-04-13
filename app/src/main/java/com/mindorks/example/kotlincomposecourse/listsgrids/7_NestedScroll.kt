package com.example.example1.dropdown.listsgrids

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun NestedDemo(){
    var listEmp: MutableList<Emp> = mutableListOf<Emp>()
    loadFakeData(listEmp)
    LazyColumn(){
        item {
            Text(text = "Header")
        }

        gridItems<Emp>(data = listEmp, nColumns = 4) { emp ->
            var context = LocalContext.current
            Column(
                modifier = Modifier.clickable {
                    Toast.makeText(context,"${emp.ename}",Toast.LENGTH_SHORT).show()
                }
                    .size(50.dp)
                    .padding(5.dp)
                    .background(Color.Gray)
            ){
                Text(text = emp.ename)
                Text(text = "${emp.esal}")
            }
        }
        item{
            LazyRow(){
                items(listEmp){
                    EmpCard(e = it)
                }
            }
        }
        item {
            Text(text = "Footer")
        }
    }
}
val books = (1..10).map { "Book $it" }.toList()
val wishlisted = (1..50).map { "Wishlisted Book $it" }

@Composable
fun NestedScrollScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        // My Books section
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text("My Books")
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items(books) { item ->
                        Box(
                            modifier = Modifier
                                .padding(50.dp)
                                .height(120.dp)
                                .width(90.dp)
                                .background(color = Color.Gray, shape = RoundedCornerShape(8.dp)).padding(50.dp)
                        ) {
                            Text(item, modifier = Modifier.align(Alignment.Center))
                        }
                    }
                }
            }

        }
        item {
            Text("Whishlisted Books")
        }
        // Turning the list in a list of lists of two elements each
        items(wishlisted.windowed(2, 2, true)) { sublist ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(PaddingValues(4.dp))) {
                sublist.forEach { item ->
                    Text(
                        item, modifier = Modifier
                            .height(120.dp)
                            .padding(4.dp)
                            .background(Color.Yellow)
                            .fillParentMaxWidth(.5f)
                    )
                }
            }
        }
    }
}
