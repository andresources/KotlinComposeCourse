package com.example.example1.state

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

//Side effects are actions that occur outside of the normal data flow of your app, such as fetching data from an API or updating a database
//you can use the LaunchedEffect function to manage side effects
// The LaunchedEffect function launches a coroutine that performs the side effect and then updates the state when the side effect is complete.
@Composable
fun SideEffectDemo() {
    var isLoading by remember { mutableStateOf(true) }
    var txt by remember { mutableStateOf("") }
    val dataAvailable by remember { derivedStateOf { txt.length > 0 } }
    Column{
        if(isLoading){
            Text(text = "Please wait, Data is loaded.")
        }
        LaunchedEffect(key1 = Unit){
            delay(5000L)
            txt= getDataFromAPI()
            isLoading = false
        }

        if(dataAvailable){
            Text(text = txt)
        }

    }

}

fun getDataFromAPI() : String {
    return "Data from server"
}
