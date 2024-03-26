package com.example.example1.layouts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun BoxModel1() {
    Box(modifier = Modifier
        .padding(10.dp) //margin
        .background(Color.Red)
        .padding(horizontal = 25.dp, vertical = 10.dp)//content padding inside Box
        .fillMaxSize()) {
            Text(
                text = "Bottom Center",
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .background(Color.White)
                    .align(Alignment.BottomCenter)
            )
        Text(
            text = "Bottom Start",
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .background(Color.White)
                .align(Alignment.BottomStart)
        )
        Text(
            text = "Bottom End",
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .background(Color.White)
                .align(Alignment.BottomEnd)
        )
        Text(
            text = "Top Start",
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .background(Color.White)
                .align(Alignment.TopStart)
        )
        Text(
            text = "Top Start",
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .background(Color.White)
                .align(Alignment.TopStart)
        )
        Text(
            text = "Top End",
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .background(Color.White)
                .align(Alignment.TopEnd)
        )
        Text(
            text = "Top Center",
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .background(Color.White)
                .align(Alignment.TopCenter)
        )
        Text(
            text = "Center Start",
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .background(Color.White)
                .align(Alignment.CenterStart)
        )
        Text(
            text = "Center End",
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .background(Color.White)
                .align(Alignment.CenterEnd)
        )
        Text(
            text = "Center",
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .background(Color.White)
                .align(Alignment.Center)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BoxModel2(){ //offset
    Box(modifier = Modifier
        .padding(10.dp) //margin
        .background(Color.Red)
        .fillMaxSize()
        .combinedClickable(
            onLongClick = {
                // perform long click operations
            },
            onDoubleClick = {
                // perform double click operations
            },
            onClick = {
                // click operations
            }
        )) {
        Text(
            text = "KSR",
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .align(Alignment.TopCenter)
                .offset(x = 0.dp, y = (-10).dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.Green)
                .align(Alignment.BottomStart)
        ){
            Text(text = "Text1", textAlign = TextAlign.Center, modifier = Modifier
                .background(Color.Yellow)
                .weight(0.5f))
            Text(text = "Text2",textAlign = TextAlign.Center, modifier = Modifier
                .background(Color.Blue)
                .weight(0.5f))
        }
        Box( modifier = Modifier
            .offset(y = (-25).dp)
            .fillMaxWidth(0.4f)
            .clip(RoundedCornerShape(100f))
            .background(MaterialTheme.colorScheme.onError)
            .padding(2.dp)
            .align(Alignment.BottomCenter)
        ){
          Button(onClick = { /*TODO*/ }) {
              Text(text = "Submit")
          }
        }
    }
}