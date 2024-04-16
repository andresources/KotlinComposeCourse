package com.mindorks.example.kotlincomposecourse.dialogs

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun AlertDialogComp() {
    val showDialog = remember { mutableStateOf(false) }
    Column{
        Button(onClick = {
            showDialog.value = true
        }) {
            Text(text = "Click Me")
        }
        if(showDialog.value==true) {
            AlertDialog(
                onDismissRequest = {
                    showDialog.value = false
                },
                title = { Text(text = "Dialog Title") },
                text = {
                    Text("Here is a text ")
                },
                confirmButton = {
                    TextButton(onClick = {  showDialog.value = false }) {
                        Text(text = "Confirm")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {  showDialog.value = false }) {
                        Text(text = "Dismiss")
                    }
                }
            )
        }
    }
   /*

    Column {
        val openDialog = remember { mutableStateOf(false) }
        Button(onClick = {
            openDialog.value = true
        }) {
            Text("Click me")
        }

        if (openDialog.value) {

            AlertDialog(
                onDismissRequest = {
                    // Dismiss the dialog when the user clicks outside the dialog or on the back
                    // button. If you want to disable that functionality, simply use an empty
                    // onCloseRequest.
                    openDialog.value = false
                },
                title = {
                    Text(text = "Dialog Title")
                },
                text = {
                    Text("Here is a text ")
                },
                confirmButton = {
                    Button(

                        onClick = {
                            openDialog.value = false
                        }) {
                        Text("This is the Confirm Button")
                    }
                },
                dismissButton = {
                    Button(

                        onClick = {
                            openDialog.value = false
                        }) {
                        Text("This is the dismiss Button")
                    }
                }
            )
        }
    }*/
}