package com.mindorks.example.kotlincomposecourse.dialogs

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.mindorks.example.kotlincomposecourse.R

@Composable
fun MyDialogComp() {
    val context = LocalContext.current
    //Dialog is a basic composable that doesn't provide any styling or predefined slots for content.
    val showDialog = remember { mutableStateOf(false) }
    Column {
        Button(onClick = {
            showDialog.value = true
        }) {
            Text(text = "Click Me")
        }
        if(showDialog.value){
            ReusableDialogComp(onYesClicked = {
                showDialog.value = false
                Toast.makeText(context,"Yes clicked",Toast.LENGTH_SHORT).show()
            }, onNoClicked = {
                showDialog.value = false
                Toast.makeText(context,"No clicked",Toast.LENGTH_SHORT).show()
            })
           /* Dialog(onDismissRequest = { showDialog.value = false }) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(16.dp),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Box (modifier = Modifier.fillMaxSize().padding(16.dp)){
                        Text(
                            text = "Do you want to close App?",
                        )
                        Row(modifier = Modifier.align(Alignment.BottomEnd)) {
                            TextButton(onClick = {
                                showDialog.value = false
                            }) {
                                Text(text = "Yes")
                            }
                            TextButton(onClick = {
                                showDialog.value = false
                            }) {
                                Text(text = "No")
                            }
                        }
                    }
                }
            }*/
        }
    }
}