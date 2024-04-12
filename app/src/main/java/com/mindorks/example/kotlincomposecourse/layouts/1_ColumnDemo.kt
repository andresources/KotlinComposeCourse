package com.mindorks.example.kotlincomposecourse.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text

@Composable
fun ColumnDemo() { //VerticalArrage , HorizontalAlign
    //SimpleColumn()
    //ColumnCenterArrangement()
    //ColumnBottomArrangement()
    //ColumnTopArrangement()
    //ColumnAlignmentCenterHorizontally()
    //ColumnAlignmentEnd()
    //ColumnCenter()
    ColumnVerticalScroll()
}

@Composable
fun SimpleColumn() {
    Column(modifier = Modifier
        .padding(10.dp)
        .background(Color.Blue)){
        Text(text = "Text1")
        Text(text = "Text2")
        Text(text = "Text3")
        Text(text = "Text4")
    }
}

@Composable
fun ColumnCenterArrangement() {
    Column(modifier = Modifier
        .padding(10.dp),verticalArrangement = Arrangement.Center) {
        Text(text = "Text1", color = Color.Red)
        Text(text = "Text2", color = Color.Red)
    }
}
@Composable
fun ColumnBottomArrangement() {
    Column(modifier = Modifier
        .padding(10.dp),verticalArrangement = Arrangement.Bottom) {
        Text(text = "Text1", color = Color.Red)
        Text(text = "Text2", color = Color.Red)
    }
}

@Composable
fun ColumnTopArrangement() {
    Column(modifier = Modifier
        .padding(10.dp),verticalArrangement = Arrangement.Top) {
        Text(text = "Text1", color = Color.Red)
        Text(text = "Text2", color = Color.Red)
    }
}

@Composable
fun ColumnAlignmentCenterHorizontally() {
    Column(modifier = Modifier
        .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Text1", color = Color.Red)
        Text(text = "Text2", color = Color.Red)
    }
}
@Composable
fun ColumnAlignmentEnd() {
    Column(modifier = Modifier
        .padding(10.dp), horizontalAlignment = Alignment.End) {
        Text(text = "Text1", color = Color.Red)
        Text(text = "Text2", color = Color.Red)
    }
}

@Composable
fun ColumnCenter() {
    Column(modifier = Modifier
        .padding(10.dp), verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Text1", color = Color.Red)
        Text(text = "Text2", color = Color.Red)
    }
}

@Composable
fun ColumnVerticalScroll() {
    Column(modifier = Modifier
        .padding(10.dp)
        .verticalScroll(rememberScrollState())) {
        repeat(100){
            Text(text = "Text- $it", color = Color.Red)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ColumnCenterArrangement()
}
