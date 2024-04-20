package com.mindorks.example.kotlincomposecourse.gradients

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text

@Composable
fun GradientsDemo() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())){
        val colorList = listOf(Color.Cyan,Color.Magenta,Color.Blue)
        Text(
            fontSize = 24.sp,
            text = "This Is Demo Horizontal Gradient Text",
            style = TextStyle(
                brush = Brush.horizontalGradient(colorList)
            )
        )

        Text(
            fontSize = 30.sp,
            text = "This Is Demo Vertical Gradient Text",
            style = TextStyle(
                brush = Brush.verticalGradient(colorList)
            )
        )
        Text(
            fontSize = 24.sp,
            text = "This Is Demo Vertical Gradient Text",
            style = TextStyle(
                brush = Brush.radialGradient(
                    colors = colorList
                )
            )
        )

        var text by remember { mutableStateOf("") }
        val brush = remember {
            Brush.linearGradient(
                colors = colorList
            )
        }

        TextField(
            value = text,
            onValueChange = { text = it },
            textStyle = TextStyle(brush = brush)
        )

        Box(modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .background(Brush.horizontalGradient(colorList))) {

        }
        Box(modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .background(Brush.verticalGradient(colorList))) {

        }
        Box(modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .background(Brush.radialGradient(colorList))) {

        }
        Box(modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .background(Brush.sweepGradient(colorList))) {

        }
        Box(modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .background(Brush.linearGradient(colorList))) {

        }
    }
}