package com.example.example1.dropdown

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Composable
fun myAlertDialogBox(onConfirmButtonClick: (std: Student) -> Unit){
    val context = LocalContext.current
    val openDialog = remember { mutableStateOf(false)  }
    Column {
        Button(onClick = {
            openDialog.value = true
            //Toast.makeText(context,"Button Clicked",Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Submit")
        }
    }
    if(openDialog.value){
        AlertDialogComponent(onConfirmButtonClick = {
            openDialog.value = false
            onConfirmButtonClick.invoke(it)
           // Toast.makeText(context,"onConfirmButtonClick Clicked",Toast.LENGTH_SHORT).show()
        }){
            openDialog.value = false
            Toast.makeText(context,"onDismissButtonClick Clicked",Toast.LENGTH_SHORT).show()
        }
    }
}

data class Student(val sname: String= "",val sno: Int = 0)

@Composable
fun AlertDialogComponent(onConfirmButtonClick: (std: Student)->Unit,onDismissButtonClick: ()-> Unit) {

        AlertDialog(
            containerColor = Color.Black,
            onDismissRequest = {  },
            title = { Text(text = "Geeks for Geeks", color = Color.White) },
            text = { Text("Hello! This is our Alert Dialog..", color = Color.White) },
            confirmButton = {
                TextButton(
                    onClick = {

                        onConfirmButtonClick.invoke(Student("KSR",1))
                    }
                ) {
                    Text("Confirm", color = Color.White)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onDismissButtonClick
                ) {
                    Text("Dismiss", color = Color.White)
                }
            }
        )
}