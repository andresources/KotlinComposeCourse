package com.mindorks.example.kotlincomposecourse.TextField

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ValidationsDemo() {
    var context = LocalContext.current
    var uname by remember {mutableStateOf("")}
    var pwd by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .background(color = Color(0xFFB3B3B3))
        .padding(10.dp)
        .fillMaxSize(), 
        verticalArrangement = Arrangement.Center, 
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(modifier = Modifier.fillMaxWidth(), value = uname, onValueChange = {
            uname = it
        }, label = { Text(text = "Enter UserName")})
        Spacer(modifier = Modifier.height(10.dp))
        TextField(modifier = Modifier.fillMaxWidth(),value = pwd, onValueChange = {
            pwd = it
        }, label = { Text(text = "Enter Password")})
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            when {
                uname.isEmpty() and pwd.isEmpty() -> {
                    Toast.makeText(context,"UserName & Password should not be empty",Toast.LENGTH_SHORT).show()
                }

                uname.isEmpty() and pwd.isNotEmpty() -> {
                    Toast.makeText(context,"UserName should not be empty",Toast.LENGTH_SHORT).show()
                }

                uname.isNotEmpty() and pwd.isEmpty() -> {
                    Toast.makeText(context,"Password should not be empty",Toast.LENGTH_SHORT).show()
                }

                else -> {
                    Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
                }
            }

        }) {
            Text(text = "Submit")
        }
    }
}