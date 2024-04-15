package com.mindorks.example.kotlincomposecourse.kotlinflows.snapshotflow

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

@Composable
fun SnapshotflowComp() {
    val listState = rememberLazyListState()
    var indx by remember { mutableStateOf(0) }
    Column{
        Text(text = indx.toString())
        LazyColumn(state=listState){
            item {
                repeat(50){
                    Text(text = "Title - $it", modifier = Modifier.padding(top = 16.dp))
                }
            }
        }
    }

    LaunchedEffect(Unit){
        snapshotFlow { listState.firstVisibleItemIndex }
            //.map { index -> index > 0 }
            .distinctUntilChanged()
            //.filter { it == true }
            .collect {
                indx = it
                println("Item - $it")
                //MyAnalyticsService.sendScrolledPastFirstItemEvent()
            }

    }
}