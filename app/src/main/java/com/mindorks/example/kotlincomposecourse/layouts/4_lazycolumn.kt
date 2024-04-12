package com.mindorks.example.kotlincomposecourse.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun LazyColumnDemo() {
    simplelazy()
}

@Composable
fun simplelazy() {
    /*LazyColumn{
        item{
            Text(text = "text-1")
        }
        item{
            Text(text = "text-2")
        }
        item{
            Text(text = "text-3")
        }
        item{
            Text(text = "text-4")
        }
    }*/

    LazyColumn(modifier = Modifier.background(Color.Blue)){
        item {
            Text(text = "Header")
        }
        item{
            repeat(100){
                Text(text = "Title - $it")
            }
        }
        item {
            Text(text = "Footer")
        }
    }

}