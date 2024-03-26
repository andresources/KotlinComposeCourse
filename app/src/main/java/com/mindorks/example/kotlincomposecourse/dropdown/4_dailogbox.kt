package com.example.example1.dropdown

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun showMyDialog(){
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
        MyFun(onCancelClick = {
            openDialog.value = false
            Toast.makeText(context,"$it",Toast.LENGTH_SHORT).show()
        }){
            openDialog.value = false
            Toast.makeText(context,"Button Clicked",Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun MyFun(onCancelClick: (msg: String)->Unit ={},onOKClik: ()->Unit){
    Dialog(onDismissRequest = {  }) {
        val context = LocalContext.current
        Card( modifier = Modifier,
            shape = RoundedCornerShape(size = 20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.inverseSurface),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp)) {
            Column(modifier = Modifier.padding(20.dp)) {
                Button(onClick = onOKClik
                ) {
                    Text(text = "OK")
                }
                Button(onClick = {onCancelClick.invoke("This is from Cancelled")}
                ) {
                    Text(text = "Cancel")
                }
            }
        }
    }
}