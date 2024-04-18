package com.mindorks.example.kotlincomposecourse.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text

@Composable
fun ShowHideComposable() {
    //SimpleShowHide()
    //SimpleShowHideWithAnim()
    //ShowHideLayouts()
    //TextAnimateVerticalComp()
    //TextAnimateHorizontalComp()
    TextAnimateZoomComp()
}

@Composable
fun SimpleShowHide() {
    var visibleText = remember { mutableStateOf(false) }

    Column{
        if(visibleText.value){
            Text(text = "My Text", color = Color.Red)
        }
        Button(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), onClick = {
            visibleText.value = true
        }) {
            Text(text = "Show")
        }
        Button(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),onClick = {
            visibleText.value = false
        }) {
            Text(text = "Hide")
        }
    }
}
@Composable
fun SimpleShowHideWithAnim() {
    var visibleText = remember { mutableStateOf(false) }

    Column{
        if(visibleText.value){
            androidx.compose.animation.AnimatedVisibility(
                visible = visibleText.value,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Text(text = "My Text", color = Color.Red)
            }
            }
        Button(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), onClick = {
            visibleText.value = true
        }) {
            Text(text = "Show")
        }
        Button(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),onClick = {
            visibleText.value = false
        }) {
            Text(text = "Hide")
        }
    }
}

@Composable
fun ShowHideLayouts() {
    var visible_fg by remember { mutableStateOf(true) }
    Column {

        Button(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), onClick = {
            visible_fg = true
        }) {
            Text(text = "Show")
        }
        Button(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), onClick = {
            visible_fg = false
        }) {
            Text(text = "Hide")
        }
        AnimatedVisibility(visible = visible_fg) {
            Box(modifier = Modifier
                .size(200.dp)
                .background(Color.Blue))
        }
    }
}

@Composable
fun TextAnimateVerticalComp() {
    //https://developer.android.com/develop/ui/compose/animation/composables-modifiers#animatedvisibility
    var visible_fg by remember { mutableStateOf(true) }
    val density = LocalDensity.current
    Column {
        AnimatedVisibility(
            visible = visible_fg,
            enter = slideInVertically {
                // Slide in from 40 dp from the top.
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                // Expand from the top.
                expandFrom = Alignment.Top
            ) + fadeIn(
                // Fade in with the initial alpha of 0.3f.
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            Text("Hello",
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(color = Color.Blue)
                    .padding(8.dp), color = Color.Red)
        }
        Button(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), onClick = {
            visible_fg = true
        }) {
            Text(text = "Show")
        }
        Button(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), onClick = {
            visible_fg = false
        }) {
            Text(text = "Hide")
        }
    }
}
@Composable
fun TextAnimateHorizontalComp() {
    //https://developer.android.com/develop/ui/compose/animation/composables-modifiers#animatedvisibility
    var visible_fg by remember { mutableStateOf(true) }
    val density = LocalDensity.current
    Column {
        AnimatedVisibility(
            visible = visible_fg,
            enter = slideInHorizontally()+ expandHorizontally(expandFrom = Alignment.Start) + fadeIn(
                // Fade in with the initial alpha of 0.3f.
                initialAlpha = 0.3f
            ),
            exit = slideOutHorizontally() + shrinkHorizontally() + fadeOut()
        ) {
            Text("Hello",
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(color = Color.Blue)
                    .padding(8.dp), color = Color.Red)
        }
        Button(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), onClick = {
            visible_fg = true
        }) {
            Text(text = "Show")
        }
        Button(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), onClick = {
            visible_fg = false
        }) {
            Text(text = "Hide")
        }
    }
}
@Composable
fun TextAnimateZoomComp() {
    //https://developer.android.com/develop/ui/compose/animation/composables-modifiers#animatedvisibility
    var visible_fg by remember { mutableStateOf(true) }
    val density = LocalDensity.current
    Column {
        AnimatedVisibility(
            visible = visible_fg,
            enter = scaleIn() + fadeIn(
                // Fade in with the initial alpha of 0.3f.
                initialAlpha = 0.3f
            ),
            exit = scaleOut() + fadeOut()
        ) {
            Text("Hello",
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(color = Color.Blue)
                    .padding(8.dp), color = Color.Red)
        }
        Button(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), onClick = {
            visible_fg = true
        }) {
            Text(text = "Show")
        }
        Button(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), onClick = {
            visible_fg = false
        }) {
            Text(text = "Hide")
        }
    }
}



