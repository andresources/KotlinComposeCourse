package com.mindorks.example.kotlincomposecourse.navigationdrawer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mindorks.example.kotlincomposecourse.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultNavDrawerComposable() {

    val navigationState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }

    val items = listOf(
        DrawerItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
        ),
        DrawerItem(
            title = "Notification",
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info,
            badgeCount = 45
        ),
        DrawerItem(
            title = "Favorites",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
        ),
    )


        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {
                    Spacer(modifier = Modifier.height(26.dp))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .padding(10.dp)
                                .border(BorderStroke(5.dp, Color.Red), CircleShape)
                                .clip(CircleShape)
                                .size(100.dp),
                            painter = painterResource(id = R.drawable.rrr),
                            contentDescription = "Image Desc",
                            contentScale = ContentScale.FillBounds
                        )
                    }
                    Spacer(modifier = Modifier.height(26.dp))
                    items.forEachIndexed { index, drawerItem ->
                        NavigationDrawerItem(label = {
                            Text(text = drawerItem.title)
                        }, selected = index == selectedItemIndex, onClick = {
                            selectedItemIndex = index
                            scope.launch {
                                navigationState.close()
                            }
                        }, icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    drawerItem.selectedIcon
                                } else drawerItem.unselectedIcon,
                                contentDescription = drawerItem.title
                            )
                        }, badge = {
                            drawerItem.badgeCount?.let {
                                Text(text = drawerItem.badgeCount.toString())
                            }
                        }, modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )

                    }
                    DrawerFooter()
                }
            },
            drawerState = navigationState,
        ) {
            Scaffold(topBar = {
                TopAppBar(title = {
                    Text(text = "My App")
                }, navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            navigationState.open()
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                })
            }) {
                Column {
                    Text(
                        text = "Hii Learner",
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize(),
                        textAlign = TextAlign.Center
                    )
                }

            }

        }

}
@Composable
fun DrawerFooter(
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 10.dp)
    ) {


        Spacer(modifier = Modifier.height(48.dp))
        Text(
            text = "Contact Creator",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold,
        )
    }
}

data class DrawerItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null
)