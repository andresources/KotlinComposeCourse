package com.example.example1.state

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CreateCustomCard1(title: String, checkboxState: Boolean, onCheckboxPressed: ((Boolean) -> Unit)) {
    Row(
        modifier = Modifier.padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkboxState,
            onCheckedChange = onCheckboxPressed,
        )
        Spacer(modifier = Modifier.padding(end = 4.dp))
        Text(text = title)
    }
}

@Composable
fun CustomCardState(){
    var chkState by rememberSaveable {
        mutableStateOf(false)
    }
    CreateCustomCard1("My Card",chkState){
        chkState = it
    }
}