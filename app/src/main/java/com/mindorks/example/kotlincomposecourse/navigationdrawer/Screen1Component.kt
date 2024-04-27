package com.mindorks.example.kotlincomposecourse.navigationdrawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen1Component(openDrawer: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        // TopAppBar has slots for a title, navigation icon,
        // and actions. Also known as the action bar.
        TopAppBar(
            title = { Text("Screen 1 Title") },
            navigationIcon = {
                IconButton(onClick = openDrawer) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                }
            }
        )
        Surface(color = Color(0xFFffd7d7.toInt()), modifier = Modifier.weight(1f)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Text(text = "Welcome to compose, this is screen-1 content")
                }
            )
        }
    }
}