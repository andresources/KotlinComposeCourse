package com.example.example1.adaptivelayout

import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
//https://proandroiddev.com/adaptive-ui-with-jetpack-compose-968e375795d4
@Composable
fun Adaptive1(windowSizeClass: WindowSizeClass) {
        when (windowSizeClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                CompactUI() //Breakpoint (600dpWidth)(Potriate)
            }
            else -> {
                ExpandedUI()//LandScape
            }
        }
    }

@Composable
fun CompactUI() {
    Text(text = "Potriate Screen")
}
@Composable
fun ExpandedUI() {
    Text(text = "Landscape Screen")
}
