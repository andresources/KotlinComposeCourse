package com.mindorks.example.kotlincomposecourse.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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

//Compose comes with built-in composables and modifiers for handling common animation use cases.
//The AnimatedVisibility composable animates the appearance and disappearance of its content.
//Animated visibility will eventually remove the item from the composition once the animation has finished.
//By default, the content appears by fading in and expanding, and it disappears by fading out and shrinking.
//The transition can be customized by specifying EnterTransition and ExitTransition.
/*
    var visible by remember { mutableStateOf(true) }
    AnimatedVisibility(visible) {

    }
*/

/*
------EnterTransition List-------------------Exit Transition List------
1.fadeIn                                    1.fadeOut
2.slideIn(bottom)                           2.slideOut
3.slideInHorizontally                       3.slideOutHorizontally
4.slideInVertically                         4.slideOutVertically
5.scaleIn                                   5.scaleOut
6.expandIn(top)                             6.shrinkOut
7.expandHorizontally                        7.shrinkHorizontally
8.expandVertically                          8.shrinkVertically
 */
//https://developer.android.com/reference/kotlin/androidx/compose/animation/package-summary#fadein
//https://developer.android.com/develop/ui/compose/animation/composables-modifiers#animatedvisibility
@Composable
fun AnimatedVisibilityDemo() {
    //TopSlideInSlideOutComp()
    AnimateEnterExitChildren()
}

@Composable
fun TopSlideInSlideOutComp() {
    Column{
        var visible by remember { mutableStateOf(false) }
        val density = LocalDensity.current
        AnimatedVisibility(
            visible = visible,
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
                    .height(200.dp)
                    .background(Color.Red))
        }
        Button(onClick = { visible = !visible }) {
            Text(text = "Click")
        }

    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimateEnterExitChildren() {
    var visible by remember { mutableStateOf(false) }
    Column {
        Button(onClick = { visible = !visible }) {
            Text(text = "Click")
        }
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(500)),
            exit = fadeOut()
        ) {
            // Fade in/out the background and the foreground.
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray)) {
                Box(
                    Modifier
                        .align(Alignment.Center)
                        .animateEnterExit(
                            // Slide in/out the inner box.
                            enter = slideInVertically(),
                            exit = slideOutVertically()
                        )
                        .sizeIn(minWidth = 256.dp, minHeight = 64.dp)
                        .background(Color.Red)
                ) {
                    // Content of the notification…
                }
            }
        }

    }
}