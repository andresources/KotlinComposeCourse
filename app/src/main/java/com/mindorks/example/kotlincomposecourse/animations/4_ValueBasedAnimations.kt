package com.mindorks.example.kotlincomposecourse.animations

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Card
import androidx.wear.compose.material.Text
import com.mindorks.example.kotlincomposecourse.R
import java.util.concurrent.CancellationException

//Animate a single value with animate*AsState
@Composable
fun ValueBasedAnimDemo() {
    //ValueBasedAnimAlpha()
    //ValueBasedAnimDp()
    //ValueBasedPadding()
    //ValueBasedPaddingPress()
    InfiniteAnimation()
}

@Composable
fun ValueBasedAnimAlpha() {
    var enabled by remember { mutableStateOf(true) }
    val alpha: Float by animateFloatAsState(if (enabled) 1f else 0.5f)
    Column{
        Button(onClick = { enabled = !enabled }) {
            Text("Click")
        }
        Box(
            Modifier
                .fillMaxSize()
                .graphicsLayer(alpha = alpha)
                .background(Color.Red)
        )
    }
}

@Composable
fun ValueBasedAnimDp() {
    var enabled by remember { mutableStateOf(true) }
    val cornerDP: Dp by animateDpAsState(if (enabled) 16.dp else 1.dp)
    Column{
        Button(onClick = { enabled = !enabled }) {
            Text("Click")
        }
        Card(shape= RoundedCornerShape(cornerDP),onClick = { /*TODO*/ }, modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {

        }
    }
}
@Composable
fun ValueBasedPadding() {
    var enabled by remember { mutableStateOf(true) }
    val paddingDP: Dp by animateDpAsState(if (enabled) 0.dp else 15.dp)
    Column{
        Button(onClick = { enabled = !enabled }) {
            Text("Click")
        }
        Box(modifier = Modifier
            .padding(paddingDP)
            .background(Color.Red)
            .fillMaxSize()){

        }
    }
}

@Composable
fun ValueBasedPaddingPress() {
    var enabled by remember { mutableStateOf(true) }
    val paddingDP: Dp by animateDpAsState(if (enabled) 0.dp else 15.dp)
    Column{
        Box(modifier = Modifier
            .padding(paddingDP)
            .clip(RoundedCornerShape(paddingDP))
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        enabled = false
                        val released = try {
                            tryAwaitRelease()
                        } catch (c: CancellationException) {
                            false
                        }
                        if (released) {
                            //ACTION_UP
                            enabled = true
                        } else {
                            //CANCELED
                        }
                    },
                    onTap = {
                        // onTap
                    },
                    onDoubleTap = {
                        //onDoubleTap
                    },
                    onLongPress = {
                        //onLongPress
                    })
            }
            .background(Color.Red)
            .fillMaxSize()){

        }
    }
}

@Composable
fun AnimateColorAsState() {
    var isNeedColorChange by remember { mutableStateOf(false) }
    val startColor = Color.Blue
    val endColor = Color.Green
    val backgroundColor by animateColorAsState(
        if (isNeedColorChange) endColor else startColor,
        animationSpec = tween(
            durationMillis = 2000,
            delayMillis = 100,
            easing = LinearEasing
        )
    )
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .background(backgroundColor)
        )
        Button(
            onClick = { isNeedColorChange = !isNeedColorChange },
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = "Switch Color")
        }
    }
}

@Composable
fun InfiniteAnimation() {
    val infiniteTransition = rememberInfiniteTransition()

    val heartSize by infiniteTransition.animateFloat(
        initialValue = 100.0f,
        targetValue = 250.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, delayMillis = 100,easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Image(
        painter = painterResource(R.drawable.rrr),

        contentDescription = "heart",
        modifier = Modifier
            .size(heartSize.dp)
    )
}