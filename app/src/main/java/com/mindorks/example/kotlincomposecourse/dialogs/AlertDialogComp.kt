package com.mindorks.example.kotlincomposecourse.dialogs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp

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
                shape = RoundedCornerShape(10.dp), //CutCornerShape,RoundedCornerShape
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
}