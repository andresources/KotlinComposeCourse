package com.example.example1.adaptivelayout.list_grid

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun LGMainView() {
    val configuration = LocalConfiguration.current
    val screenW = configuration.screenWidthDp
    when{
        screenW <= 600 ->{
            PortraitView()
        }
        else -> {
            LandscapeView()
        }
    }
}