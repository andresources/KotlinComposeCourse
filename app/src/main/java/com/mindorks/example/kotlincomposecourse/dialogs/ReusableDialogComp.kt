package com.mindorks.example.kotlincomposecourse.dialogs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun ReusableDialogComp(onYesClicked:() -> Unit, onNoClicked: () -> Unit) {
    Dialog(onDismissRequest = {  }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {

            Box (modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)){
                Text(
                    text = "Do you want to close App?",
                )
                Row(modifier = Modifier.align(Alignment.BottomEnd)) {
                    TextButton(onClick = {
                        onYesClicked.invoke()
                    }) {
                        Text(text = "Yes")
                    }
                    TextButton(onClick = {
                        onNoClicked.invoke()
                    }) {
                        Text(text = "No")
                    }
                }
            }
        }
    }
}