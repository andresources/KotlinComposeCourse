package com.mindorks.example.kotlincomposecourse.shapes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.graphics.shapes.CornerRounding
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.toPath

@Composable
fun ShapesComposable() {
    LazyColumn {
        item {
            Card(shape = RectangleShape, modifier = Modifier.padding(10.dp).size(50.dp).clickable {

            }) {
                Text(
                    text = "Hello", modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(Alignment.CenterVertically), textAlign = TextAlign.Center
                )
            }
            Card(shape = CircleShape, modifier = Modifier.padding(10.dp).size(50.dp)) {
                Text(
                    text = "Hello", modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(Alignment.CenterVertically), textAlign = TextAlign.Center
                )
            }
            Card(shape = RoundedCornerShape(8.dp), modifier = Modifier.padding(10.dp).size(50.dp)) {
                Text(
                    text = "Hello", modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(Alignment.CenterVertically), textAlign = TextAlign.Center
                )
            }
            Card(shape = CutCornerShape(5.dp), modifier = Modifier.padding(10.dp).size(100.dp)) {
                Text(
                    text = "Hello", modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(Alignment.CenterVertically), textAlign = TextAlign.Center
                )
            }

            Box(modifier = Modifier.padding(10.dp).size(100.dp).background(MaterialTheme.colorScheme.secondary, shape = CircleShape)){
                Text(
                    text = "Hello", modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(Alignment.CenterVertically), textAlign = TextAlign.Center
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun myShapesPreview(){
    ShapesComposable()
}