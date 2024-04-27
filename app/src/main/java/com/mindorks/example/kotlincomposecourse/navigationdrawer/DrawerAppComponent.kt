package com.mindorks.example.kotlincomposecourse.navigationdrawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun DrawerAppComponent() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val currentScreen = remember { mutableStateOf(DrawerAppScreen.Screen1) }
    val coroutineScope = rememberCoroutineScope()
    ModalNavigationDrawer(
        // Drawer state indicates whether the drawer is open or closed.
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = { //drawerContent accepts a composable to represent the view/layout that will be displayed when the drawer is open.
            //drawerContent accepts a composable to represent
            // the view/layout that will be displayed
            // when the drawer is open.
            DrawerContentComponent(
                // We pass a state composable that represents the
                // current screen that's selected
                // and what action to take when the drawer is closed.
                currentScreen = currentScreen,
                closeDrawer = { coroutineScope.launch { drawerState.close() } }
            )
        }, content = {
            // bodyContent takes a composable to represent the view/layout to display on the
            // screen. We select the appropriate screen based on the value stored in currentScreen.
            BodyContentComponent(
                currentScreen = currentScreen.value,
                openDrawer = {
                    coroutineScope.launch { drawerState.open() }
                }
            )
        }
    )
}
@Composable
fun DrawerContentComponent(
    currentScreen: MutableState<DrawerAppScreen>,
    closeDrawer: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        // We want to have 3 rows in this column to
        // represent the 3 screens in this activity.
        for (index in DrawerAppScreen.values().indices) {
            // Here, we just update the currentScreen variable
            // to hold the appropriate value based on
            // the row that is clicked i.e if the first
            // row is clicked, we set the value of
            // currentScreen to DrawerAppScreen.Screen1,
            // when second row is clicked we set it to
            // DrawerAppScreen.Screen2 and so on and so forth.
            val screen = getScreenBasedOnIndex(index)
            Column(Modifier.clickable(onClick = {
                currentScreen.value = screen
                // We also close the drawer when an
                // option from the drawer is selected.
                closeDrawer()
            }), content = {
                // bodyContent takes a composable to
                // represent the view/layout to display on the
                // screen.
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = if (currentScreen.value == screen) {
                        MaterialTheme.colorScheme.secondary
                    } else {
                        MaterialTheme.colorScheme.surface
                    }
                ) {
                    Text(text = screen.name, modifier = Modifier.padding(16.dp))
                }
            })
        }
    }
}
fun getScreenBasedOnIndex(index: Int) = when (index) {
    0 -> DrawerAppScreen.Screen1
    1 -> DrawerAppScreen.Screen2
    2 -> DrawerAppScreen.Screen3
    else -> DrawerAppScreen.Screen1
}

@Composable
fun BodyContentComponent(
    currentScreen: DrawerAppScreen,
    openDrawer: () -> Unit
) {
    when (currentScreen) {
        DrawerAppScreen.Screen1 -> Screen1Component(
            openDrawer
        )
        DrawerAppScreen.Screen2 -> Screen2Component(
            openDrawer
        )
        DrawerAppScreen.Screen3 -> Screen3Component(
            openDrawer
        )
    }
}
enum class DrawerAppScreen {
    Screen1,
    Screen2,
    Screen3
}