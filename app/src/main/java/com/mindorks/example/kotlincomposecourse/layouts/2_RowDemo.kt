package com.mindorks.example.kotlincomposecourse.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text

@Composable
fun RowDemo() {
    //SimpleRow()
    //RowArrangementCenter()
    //RowArrangementEnd()
    //RowAlignmentCenterVertically()
   // RowAlignmentBottom()
    //RowCenter()
}

@Composable
fun SimpleRow() {
    Row(modifier = Modifier.padding(10.dp).background(color = Color.Red).padding(10.dp)){
        Text(text = "Text - 1")
        Text(text = "Text - 2")
    }
}

@Composable
fun RowArrangementCenter() {
    Row(modifier = Modifier.background(color = Color.Red), horizontalArrangement = Arrangement.Center){
        Text(text = "Text - 1")
        Text(text = "Text - 2")
    }
}

@Composable
fun RowArrangementEnd() {
    Row(modifier = Modifier.background(color = Color.Red), horizontalArrangement = Arrangement.End){
        Text(text = "Text - 1")
        Text(text = "Text - 2")
    }
}

@Composable
fun RowAlignmentCenterVertically() {
    Row(modifier = Modifier.background(color = Color.Red), verticalAlignment = Alignment.CenterVertically){
        Text(text = "Text - 1")
        Text(text = "Text - 2")
    }
}

@Composable
fun RowAlignmentBottom() {
    Row(modifier = Modifier.background(color = Color.Red), verticalAlignment = Alignment.Bottom){
        Text(text = "Text - 1")
        Text(text = "Text - 2")
    }
}

@Composable
fun RowCenter() {
    Row(modifier = Modifier.background(color = Color.Red), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
        Text(text = "Text - 1")
        Text(text = "Text - 2")
    }
}

@Preview(showBackground = true)
@Composable
fun RowPreview() {
    RowArrangementEnd()
}