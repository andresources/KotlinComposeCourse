package com.mindorks.example.kotlincomposecourse.radiobutton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtonsDemo() {
    Column() {
        MultipleRadioButtons()
        MultipleRadioButtonsWithCustomColors()
        CustomRadioButtonIndicator_WithIconToggleButton()
    }
}


@Composable
fun MultipleRadioButtons() {
    val selectedValue = remember { mutableStateOf("") }
    val isSelectedItem: (String) -> Boolean = { selectedValue.value == it }
    val onChangeState: (String) -> Unit = { selectedValue.value = it }
    val items = listOf("Item 1", "Item 2", "Item 3")
    Column(Modifier.padding(8.dp)) {
        Text(text = "Selected value: ${selectedValue.value.ifEmpty { "NONE" }}")
        items.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .selectable(
                        selected = isSelectedItem(item),
                        onClick = { onChangeState(item) },
                        role = Role.RadioButton
                    )
                    .padding(8.dp)
            ) {
                RadioButton(
                    selected = isSelectedItem(item),
                    onClick = null
                )
                Text(
                    text = item,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun MultipleRadioButtonsWithCustomColors() {
    val selectedValue = remember { mutableStateOf("") }
    val textToEnableList = listOf(
        "Item 1" to true,
        "Item 2" to true,
        "Item 4" to false,
        "Item 5" to true
    )

    val isSelectedItem: (String) -> Boolean = { selectedValue.value == it }
    val onChangeState: (String) -> Unit = { selectedValue.value = it }

    Column(Modifier.padding(8.dp)) {
        Text(text = "Selected value: ${selectedValue.value.ifEmpty { "NONE" }}")
        textToEnableList.forEach { textToEnableState ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .selectable(
                        selected = isSelectedItem(textToEnableState.first),
                        enabled = textToEnableState.second,
                        onClick = { onChangeState(textToEnableState.first) }
                    )
                    .padding(8.dp)
            ) {
                RadioButton(
                    selected = isSelectedItem(textToEnableState.first),
                    onClick = null,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Green,
                        unselectedColor = Color.Red,
                        disabledSelectedColor = Color.LightGray,
                                disabledUnselectedColor = Color.LightGray
                    ),
                    enabled = textToEnableState.second
                )
                Text(
                    text = textToEnableState.first,
                    color = when {
                        isSelectedItem(textToEnableState.first) -> Color.Green
                        !textToEnableState.second -> Color.LightGray
                        else -> Color.Red
                    }
                )
            }
        }
    }
}

//https://fonts.google.com/icons
@Composable
fun CustomRadioButtonIndicator_WithIconToggleButton() {
    val selectedValue = remember { mutableStateOf("") }
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
    Column(Modifier.padding(8.dp)) {
        Text(text = "Selected value: ${selectedValue.value.ifEmpty { "NONE" }}")
        items.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.selectable(
                    selected = (selectedValue.value == item),
                    onClick = { selectedValue.value = item },
                    role = Role.RadioButton
                ).padding(8.dp)
            ) {
                IconToggleButton(
                    checked = selectedValue.value == item,
                    onCheckedChange = { selectedValue.value = item },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = if (selectedValue.value == item) Icons.Filled.Add else Icons.Filled.Remove,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Text(
                    text = item,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}