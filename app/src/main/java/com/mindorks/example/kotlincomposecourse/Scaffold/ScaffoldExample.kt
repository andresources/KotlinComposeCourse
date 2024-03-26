package com.mindorks.example.kotlincomposecourse.Scaffold

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ScaffoldExample() {
    //SimpleScaffold()
    TopbarBottomBarScaffold()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleScaffold() {
    var presses by remember { mutableStateOf(0) }
    Scaffold(
        modifier = Modifier,
        topBar = {Text(text = "This is Top Bar")},
        bottomBar = {Text(text = "This is Bottom Bar")}
    ){ paddingV ->
        Column(modifier = Modifier.padding(paddingV)) {
            Text(text = "Content...")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopbarBottomBarScaffold() {
    var mDisplayMenu by remember { mutableStateOf(false) }
    var presses by remember { mutableStateOf(0) }
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text("TopAppBar")
                },
                navigationIcon = {
                    IconButton(onClick = {   }) {
                        Icon(
                            imageVector = Icons.Filled.Menu, contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    val context = LocalContext.current
                    IconButton(onClick = {
                        Toast.makeText(context,"Favorite",Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Favorite, contentDescription = "Localized description"
                        )
                    }
                    IconButton(onClick = { mDisplayMenu = !mDisplayMenu }) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert, contentDescription = "Localized description"
                        )
                    }
                    DropdownMenu(
                        expanded = mDisplayMenu,
                        onDismissRequest = { mDisplayMenu = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Logout") },
                            onClick = {
                                Toast.makeText(context,"Logout",Toast.LENGTH_SHORT).show()
                                mDisplayMenu = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("About") },
                            onClick = {
                                Toast.makeText(context,"About",Toast.LENGTH_SHORT).show()
                                mDisplayMenu = false
                            }
                        )
                    }
                },

                colors = TopAppBarDefaults.mediumTopAppBarColors(titleContentColor =Color.White,navigationIconContentColor= Color.White, containerColor =MaterialTheme.colorScheme.primary,actionIconContentColor= Color.White))
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(Icons.Filled.Check, contentDescription = "Localized description")
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "Localized description",
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Mic,
                            contentDescription = "Localized description",
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Image,
                            contentDescription = "Localized description",
                        )
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /* do something */ },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, "Localized description")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(shape = RoundedCornerShape(100), onClick = { presses++ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ){ paddingV ->
        Column(modifier = Modifier.padding(paddingV)) {
            Text(text = "Content...")
        }
    }
}
