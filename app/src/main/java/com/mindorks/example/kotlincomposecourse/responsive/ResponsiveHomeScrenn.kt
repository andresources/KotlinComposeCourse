package com.mindorks.example.kotlincomposecourse.responsive

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ResponsiveHomeScreen(windowSize: WindowWidthSizeClass,vm: ResponsiveViewModel) {
    var txt = vm.uiState.collectAsState().value
    Column{
        Text(text = txt.title)
        Button(onClick = { vm.updateDetailsScreenStates("Videos") }) {
            Text(text ="Submit")
        }
    }
    /*val mystate = remember {
        mutableStateOf("News")
    }
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            Text("Compact",color = Color.Black)
        }

        WindowWidthSizeClass.Medium -> {
            Text("Medium",color = Color.Black)
        }

        WindowWidthSizeClass.Expanded -> {
            PermanentNavigationDrawer(
                drawerContent = {
                    PermanentDrawerSheet(Modifier.width(240.dp)) {
                        Column {
                            Text(text = mystate.value, modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp))

                            NavigationDrawerItem(
                                selected = mystate.value == "News",
                                label = {
                                    Text(
                                        text = "News",
                                        color = Color.Black,
                                        modifier = Modifier.padding(horizontal = 8.dp)
                                    )
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Rounded.AccessTime,
                                        contentDescription = "Location FAB",
                                        tint = Color.Black,
                                    )
                                },
                                colors = NavigationDrawerItemDefaults.colors(
                                    unselectedContainerColor = Color.Transparent
                                ),
                                onClick = { mystate.value = "News" }
                            )
                            NavigationDrawerItem(
                                selected = mystate.value  == "Gallery",
                                label = {
                                    Text(
                                        text = "Gallery",
                                        color = Color.Black,
                                        modifier = Modifier.padding(horizontal = 8.dp)
                                    )
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Rounded.AccessTime,
                                        contentDescription = "Location FAB",
                                        tint = Color.Black,
                                    )
                                },
                                colors = NavigationDrawerItemDefaults.colors(
                                    unselectedContainerColor = Color.Transparent
                                ),
                                onClick = { mystate.value = "Gallery" }
                            )
                            NavigationDrawerItem(
                                badge={ Text("8")},
                                shape= RoundedCornerShape(8.dp),
                                selected = mystate.value  == "Videos",
                                label = {
                                    Text(
                                        text = "Videos",
                                        color = Color.Black
                                    )
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Rounded.AccessTime,
                                        contentDescription = "Location FAB",
                                        tint = Color.Black,
                                    )
                                },
                                colors = NavigationDrawerItemDefaults.colors(
                                    selectedContainerColor = Color.Red,
                                    unselectedContainerColor = Color.Transparent
                                ),
                                onClick = { mystate.value = "Videos" }
                            )

                        }
                    }
                }
            ){

            }
        }

        else -> {
            Text("Compact",color = Color.Black)
        }
    }*/
}