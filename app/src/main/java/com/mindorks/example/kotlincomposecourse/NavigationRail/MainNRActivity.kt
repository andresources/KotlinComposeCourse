package com.example.example1.NavigationRail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import com.example.example1.adaptivelayout.list_grid.Foo
import com.example.example1.adaptivelayout.list_grid.LandscapeView
import com.example.example1.adaptivelayout.list_grid.PortraitView
import com.mindorks.example.kotlincomposecourse.R
import com.mindorks.example.kotlincomposecourse.ui.theme.KotlinComposeCourseTheme


class MainNRActivity : ComponentActivity() {

    private val navigations: List<NavigationModel> = listOf(
        NavigationModel(
            title = R.string.home,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false
        ),
        NavigationModel(
            title = R.string.chat,
            selectedIcon = Icons.Filled.Email,
            unselectedIcon = Icons.Outlined.Email,
            hasNews = false,
            badgeCount = 77
        ),
        NavigationModel(
            title = R.string.settings,
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = true
        )
    )

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinComposeCourseTheme {
                val window = calculateWindowSizeClass(activity = this)
                val compact = window.widthSizeClass == WindowWidthSizeClass.Compact
                val medium = window.widthSizeClass == WindowWidthSizeClass.Medium
                val expanded = window.widthSizeClass == WindowWidthSizeClass.Expanded
                var selectedNavigationIndex by rememberSaveable { mutableIntStateOf(0) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            if (compact) {
                                NavigationBottomBar(
                                    navigations = navigations,
                                    selectedNavigationIndex = selectedNavigationIndex,
                                    onSelect = { index ->
                                        selectedNavigationIndex = index
                                    }
                                )
                            }
                        },
                        modifier = Modifier.fillMaxSize()
                    ) { padding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding)
                                .padding(
                                    start = if (compact) 0.dp else if(medium) 80.dp else 250.dp
                                )
                        ) {
                                when{
                                    selectedNavigationIndex==0 -> if(compact) PortraitView() else LandscapeView()
                                    selectedNavigationIndex==1 -> if(compact) PortraitView(Foo.foos_chat) else LandscapeView(Foo.foos_chat)
                                    selectedNavigationIndex==2 -> if(compact) PortraitView(Foo.foos_settings) else LandscapeView(Foo.foos_settings)
                                }
                        }
                        /*LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding)
                                .padding(
                                    start = if (compact) 0.dp else 80.dp
                                )
                        ) {
                            if(compact){
                                items(100) { index ->
                                    Text(
                                        text = stringResource(id = R.string.your_item, index),
                                        modifier = Modifier.padding(16.dp)
                                    )
                                }
                            }else{
                                items(100) { index ->
                                    Text(
                                        text = stringResource(id = R.string.your_item_rail, index),
                                        modifier = Modifier.padding(16.dp)
                                    )
                                }
                            }

                        }*/
                    }
                }//Surface End
                if(medium){
                    NavigationSideBar(
                        navigations = navigations,
                        selectedNavigationIndex = selectedNavigationIndex,
                        onSelect = { index ->
                            selectedNavigationIndex = index
                        }
                    )
                }
                if (expanded) {
                    PermanentNavigationDrawerComp( navigations = navigations,
                        selectedNavigationIndex = selectedNavigationIndex,
                        onSelect = { index ->
                            selectedNavigationIndex = index
                        })

                }

            }
        }
    }
}

data class NavigationModel(
    @StringRes val title: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@Composable
fun NavigationBottomBar(
    navigations: List<NavigationModel>,
    selectedNavigationIndex: Int,
    onSelect: (Int) -> Unit
) {
    NavigationBar {
        navigations.forEachIndexed { index, navigation ->
            val selected = selectedNavigationIndex == index
            NavigationBarItem(
                selected = selected,
                onClick = {
                    onSelect(index)
                },
                icon = {
                    NavigationIcon(
                        navigation = navigation,
                        selected = selected
                    )
                },
                label = {
                    Text(text = stringResource(id = navigation.title))
                }
            )
        }
    }
}

@Composable
fun PermanentNavigationDrawerComp(navigations: List<NavigationModel>,
                                  selectedNavigationIndex: Int,
                                  onSelect: (Int) -> Unit) {
    PermanentNavigationDrawer(drawerContent = {
        PermanentDrawerSheet(Modifier.width(dimensionResource(R.dimen.drawer_width))) {
            Column{
                navigations.forEachIndexed { index, navigation ->
                    val selected = selectedNavigationIndex == index
                    NavigationDrawerItem(
                        selected = selected,
                        onClick = {
                            onSelect(index)
                        },
                        icon = {
                            NavigationIcon(
                                navigation = navigation,
                                selected = selected
                            )
                        },
                        label = {
                            Text(text = stringResource(id = navigation.title))
                        }
                    )
                }
            }
        }
     }
    ){

    }
}
@Composable
fun NavigationSideBar(
    navigations: List<NavigationModel>,
    selectedNavigationIndex: Int,
    onSelect: (Int) -> Unit
) {
    NavigationRail(
        header = {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(id = R.string.menu)
                )
            }
            /*FloatingActionButton(
                onClick = { },
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.add)
                )
            }*/
        },
        modifier = Modifier
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .offset(x = (-1).dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                space = 12.dp,
                //alignment = Alignment.Bottom
            ),
            modifier = Modifier.fillMaxHeight()
        ) {
            navigations.forEachIndexed { index, navigation ->
                val selected = selectedNavigationIndex == index
                NavigationRailItem(
                    selected = selected,
                    onClick = {
                        onSelect(index)
                    },
                    icon = {
                        NavigationIcon(
                            navigation = navigation,
                            selected = selected
                        )
                    },
                    label = {
                        Text(text = stringResource(id = navigation.title))
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationIcon(
    navigation: NavigationModel,
    selected: Boolean
) {
    BadgedBox(
        badge = {
            when {
                navigation.badgeCount != null -> {
                    Badge {
                        Text(text = navigation.badgeCount.toString())
                    }
                }

                navigation.hasNews -> {
                    Badge()
                }
            }
        }
    ) {
        Icon(
            imageVector = if (selected) navigation.selectedIcon else navigation.unselectedIcon,
            contentDescription = stringResource(id = navigation.title)
        )
    }
}