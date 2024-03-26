package com.example.example1.launched_effect

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.example1.dropdown.Demo_DropDownMenu

@Composable
fun DropDownMenuLaunchedEffectDemo() {
    var txt by remember { mutableStateOf("") }
    var lanch_txt by remember { mutableStateOf("No Data") }
    Column {
        Text(text = lanch_txt)
        Demo_ExposedDropdownMenuBox1{
            if(it.contains("Select Drink").not()){
                txt = it
            }
        }
    }

    LaunchedEffect(key1 =  txt){
        //API Calls from ViewModel
        if(txt.isNotBlank()){
            lanch_txt = "Launch : $txt"
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Demo_ExposedDropdownMenuBox1(onDataChang:(String)->Unit) {
    val context = LocalContext.current
    val coffeeDrinks = arrayOf("Select Drink","A1mericano", "Cappuccino", "Espresso", "Latte", "Mocha")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(coffeeDrinks[0]) }
    var selectedItemIndex by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        Text( modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp),text = selectedText)
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                coffeeDrinks.forEachIndexed  {index, item ->
                    DropdownMenuItem(
                        text = {
                            (if (index == selectedItemIndex) Color.Green else Color.Black)?.let {
                                Text(text = item,
                                    fontWeight = if (index == selectedItemIndex) FontWeight.Bold else null,
                                    color = it
                                )
                            }
                        },
                        onClick = {
                            selectedItemIndex = index
                            selectedText = item
                            expanded = false
                            onDataChang(item)
                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}

