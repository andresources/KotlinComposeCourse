package com.example.example1.layouts

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mindorks.example.kotlincomposecourse.R

@Composable
fun BoxDemo() {
    //BoxModel1()
    //BoxModel2()
    BoxModel3()
    //Demo1()
}

@Composable
fun Demo1() {

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)) {
        Image(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp), contentScale = ContentScale.Crop, painter = painterResource(id = R.drawable.rrr), contentDescription = "Image Desc")

        Text(
            text = "RRR Movie Review",
            modifier = Modifier.padding(top = 178.dp, start = 150.dp)
                .wrapContentWidth()
                .wrapContentHeight()
                .background(Color.White)

        )
    }

}

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

@Composable
fun BoxModel2() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)) {
        Image(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp), contentScale = ContentScale.Crop, painter = painterResource(id = R.drawable.rrr), contentDescription = "Image Desc")
        FilledIconButton(modifier = Modifier
            .padding(end = 8.dp)
            .height(20.dp)
            .align(Alignment.CenterEnd)
            .width(20.dp), onClick = {

        }){
            Icon(modifier = Modifier
                .height(10.dp)
                .width(10.dp),
                imageVector = Icons.Rounded.ArrowForward,
                contentDescription = "",
                tint = Color.White,
            )
        }
        FilledIconButton(modifier = Modifier
            .padding(start = 8.dp)
            .height(20.dp)
            .align(Alignment.CenterStart)
            .width(20.dp), onClick = {

        }){
            Icon(modifier = Modifier
                .height(10.dp)
                .width(10.dp),
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "",
                tint = Color.White,
            )
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BoxModel3(){ //offset
    var content = LocalContext.current
    Box(modifier = Modifier
        .padding(50.dp) //margin
        .background(Color.Red)
        .fillMaxSize()
        .combinedClickable(
            onLongClick = {
                Toast
                    .makeText(content, "onLongClick", Toast.LENGTH_SHORT)
                    .show()
                // perform long click operations
            },
            onDoubleClick = {
                Toast
                    .makeText(content, "onDoubleClick", Toast.LENGTH_SHORT)
                    .show()
                // perform double click operations
            },
            onClick = {
                Toast
                    .makeText(content, "onClick", Toast.LENGTH_SHORT)
                    .show()
                // click operations
            }
        )) {
        Button(
            onClick = {},
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .background(Color.Red)
                .align(Alignment.TopCenter)
                .offset(x = 0.dp, y = (-25).dp)
        ){
            Text(text = "KSR")
        }
        Button(
            onClick = {},
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .background(Color.Red)
                .align(Alignment.CenterStart)
                .offset(x = -20.dp)
        ){
            Text(text = "Left")
        }
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
            .offset(y = (-30).dp)
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

@Preview(showBackground = true)
@Composable
fun BoxPreview() {
    BoxModel2()
}