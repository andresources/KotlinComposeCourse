package com.example.example1.navcontroler

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavControllerDemo() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
        composable("home") {
            HomeComp{
                navController.navigate("addProject"){
                    popUpTo("home"){ inclusive = true }
                }
            }
        }
        composable("addProject") {
            AddProjectComp{
                navController.navigate("addTask")
            }
        }
        composable("addTask") {
            AddTaskComp{
                navController.navigate("home")
            }
        }
    }
}

@Composable
fun HomeComp(onBtnClicked: () -> Unit) {
    Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text("This is Home Screen")
        Button(onClick = onBtnClicked) {
            Text(text = "Go to Add Project")
        }
    }
}

@Composable
fun AddProjectComp(onBtnClicked: () -> Unit) {
    Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text("This is Add Project")
        Button(onClick = onBtnClicked) {
            Text(text = "Go to Add Task")
        }
    }
}

@Composable
fun AddTaskComp(onBtnClicked: () -> Unit) {
    Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text("This is Add Task")
        Button(onClick = onBtnClicked) {
            Text(text = "Go to Home")
        }
    }
}