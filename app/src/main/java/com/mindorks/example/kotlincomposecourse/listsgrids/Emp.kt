package com.example.example1.dropdown.listsgrids

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Emp(val ename: String,val esal: Int)

fun loadFakeData( listEmp: MutableList<Emp>){
    repeat(10){
        listEmp.add(Emp("Name: $it",10000))
    }
}

@Composable
fun EmpCard(e: Emp){
    var context = LocalContext.current
    Card(modifier = Modifier.padding(15.dp),  elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        shape = RoundedCornerShape(10.dp)

    ) {
        Column(modifier = Modifier.clickable {
            Toast.makeText(context,"Clicked:${e.ename}",Toast.LENGTH_SHORT).show()
        }) {
            Text(modifier = Modifier.padding(8.dp), text = "${e.ename}")
            Text(modifier = Modifier.padding(8.dp), text = "Salary : ${e.esal}")
        }
    }


}
/*

inline fun <T> LazyListScope.gridItems(
    columns: Int,
    gridPadding: Dp = 0.dp,
    contentPadding: PaddingValues = PaddingValues(),
    items: List<T>,
    crossinline itemContent: @Composable LazyItemScope.(item: T) -> Unit
) {
    val chunkedItems = items.chunked(columns)
    itemsIndexed(chunkedItems) { index, rowList ->
        val layoutDirection = LocalLayoutDirection.current
        val topPadding = if (index > 0) gridPadding else contentPadding.calculateTopPadding()
        val startPadding = contentPadding.calculateLeftPadding(layoutDirection)
        val endPadding = contentPadding.calculateEndPadding(layoutDirection)
        val bottomPadding = contentPadding.calculateBottomPadding()
        Row(Modifier.padding(top = topPadding, start = startPadding, bottom = bottomPadding, end = endPadding)) {
            val rowModifier = Modifier.weight(1f)
            rowList.forEachIndexed { index, item ->
                if (index > 0) Spacer(Modifier.width(gridPadding))
                Box(rowModifier) {
                    itemContent(item)
                }
            }
            val emptyRows = (columns - rowList.size)
            repeat(emptyRows) { // fill empty cells
                Spacer(Modifier.width(gridPadding))
                Spacer(modifier = rowModifier)
            }
        }
    }
}*/
fun <T> LazyListScope.gridItems(
    count: Int,
    nColumns: Int,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    itemContent: @Composable BoxScope.(Int) -> Unit,
) {
    gridItems(
        data = List(count) { it },
        nColumns = nColumns,
        horizontalArrangement = horizontalArrangement,
        itemContent = itemContent,
    )
}
fun <T> LazyListScope.gridItems(
    data: List<T>,
    nColumns: Int,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    key: ((item: T) -> Any)? = null,
    itemContent: @Composable BoxScope.(T) -> Unit,
) {
    val rows = if (data.isEmpty()) 0 else 1 + (data.count() - 1) / nColumns
    items(rows) { rowIndex ->
        Row(horizontalArrangement = horizontalArrangement) {
            for (columnIndex in 0 until nColumns) {
                val itemIndex = rowIndex * nColumns + columnIndex
                if (itemIndex < data.count()) {
                    val item = data[itemIndex]
                    androidx.compose.runtime.key(key?.invoke(item)) {
                        Box(
                            modifier = Modifier.weight(1f, fill = true),
                            propagateMinConstraints = true
                        ) {
                            itemContent.invoke(this, item)
                        }
                    }
                } else {
                    Spacer(Modifier.weight(1f, fill = true))
                }
            }
        }
    }
}
