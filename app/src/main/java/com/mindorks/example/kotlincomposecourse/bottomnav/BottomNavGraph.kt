package com.mindorks.example.kotlincomposecourse.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreenCompose()
        }
        composable(route = BottomBarScreen.Report.route) {
            ReportScreenCompose()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreenCompose()
        }
    }
}