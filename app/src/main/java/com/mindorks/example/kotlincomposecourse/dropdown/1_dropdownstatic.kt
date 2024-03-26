package com.example.example1.dropdown

import androidx.compose.runtime.Composable
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun Demo_DropDownMenuStatic(str: String) {
    val context = LocalContext.current
    var selText by remember {
        mutableStateOf(str)
    }
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(25.dp)
            .fillMaxWidth()
    ) {
        Text(text = selText)
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More"
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            DropdownMenuItem(leadingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = ""
                )
            },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = ""
                    )
                },
                contentPadding = PaddingValues(5.dp),
                text = { Text("Load") },
                onClick = {
                    expanded = false
                    selText = "Load"
                    Toast.makeText(context, "Load", Toast.LENGTH_SHORT).show()
                }
            )
            Divider(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 5.dp, bottom = 5.dp))
            DropdownMenuItem(
                text = { Text("Save") },
                onClick = { expanded = false
                    selText = "Save"
                    Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show() }
            )
        }

    }
}
