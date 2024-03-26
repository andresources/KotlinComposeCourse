package com.example.example1.NavigationRail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

enum class Page(val title:String, val content: String){
    HOME("home","Show only icon"),
    SEARCH("Search","Show icon with label"),
    SETTINGS("Settings","Show icon /Show the label only when selected")
}

@Composable
fun NavigationRailSample() {
    var selectedItem by remember { mutableStateOf(0) }
    val pages = Page.values()
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Settings)
    Row {
        NavigationRail {
            pages.forEachIndexed { index, item ->
                when(item){
                    Page.HOME -> {
                        NavigationRailItem(
                            label = { Text(item.title) },
                            icon = { Icon(icons[index], contentDescription = "") },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            alwaysShowLabel = true
                        )
                    }
                    Page.SEARCH -> {
                        NavigationRailItem(
                            label = { Text(item.title) },
                            icon = { Icon(icons[index], contentDescription = "") },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            alwaysShowLabel = true
                        )
                    }
                    Page.SETTINGS -> {
                        NavigationRailItem(
                            label = { Text(item.title) },
                            icon = { Icon(icons[index], contentDescription = "") },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            alwaysShowLabel = true
                        )
                    }
                }
            }
        }

        when{
            selectedItem == 0 -> HomeScreen()
            selectedItem == 1 -> SearchScreen()
            selectedItem == 2 -> SettingsScreen()
        }

        //Text(pages[selectedItem].content, Modifier.padding(start = 8.dp))
    }
}

@Composable
fun HomeScreen() {
    Text(text = "This is Home Screen")
}

@Composable
fun SearchScreen() {
    Text(text = "This is Search Screen")
}

@Composable
fun SettingsScreen() {
    Text(text = "This is Settings Screen")
}
