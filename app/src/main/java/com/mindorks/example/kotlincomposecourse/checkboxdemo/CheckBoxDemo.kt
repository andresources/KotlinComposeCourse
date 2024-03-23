package com.mindorks.example.kotlincomposecourse.checkboxdemo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CheckBoxDemo() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            SimpleCheckBox()
            CheckboxWithLabelExample()
        }
    }
}

@Composable
fun SimpleCheckBox() {
    val checked = remember { mutableStateOf(false) }
    Column {
        Checkbox(
            checked = checked.value,
            onCheckedChange = { isChecked -> checked.value = isChecked }
        )
        Text("Checkbox is ${if (checked.value) "checked" else "unchecked"}")
    }
}

@Composable
fun CustomColorsCheckBox() {
    /*val checked = remember { mutableStateOf(false) }
    Column {
        Checkbox(
            checked = checked.value,
            onCheckedChange = { isChecked -> checked.value = isChecked },
            colors = CheckboxColors(
                checkedBoxColor = Color.Magenta,
                checkedCheckmarkColor = Color.Magenta,
                checkedBorderColor= Color.Magenta,
                uncheckedBoxColor = Color.Gray,
                uncheckedCheckmarkColor = Color.Red,
                uncheckedBorderColor= Color.Gray,
                disabledCheckedBoxColor= Color.Gray,
                disabledUncheckedBoxColor= Color.Gray,
                disabledIndeterminateBoxColor= Color.Gray,
                disabledBorderColor= Color.Gray,
                disabledIndeterminateBorderColor= Color.Gray
            )
        )
        Text("Checkbox is ${if (checked.value) "checked" else "unchecked"}")
    }*/
}

@Composable
fun CheckboxWithLabelExample() {
    val checked = remember { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checked.value,
            onCheckedChange = { isChecked -> checked.value = isChecked }
        )
        Spacer(modifier = Modifier.width(0.dp))
        Text(
            text ="Label for checkbox")
    }
}