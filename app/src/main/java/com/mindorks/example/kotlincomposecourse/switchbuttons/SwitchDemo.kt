package com.mindorks.example.kotlincomposecourse.switchbuttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.wear.compose.material.ContentAlpha

@Composable
fun Demo_SwitchComponent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            SimpleSwitch()
            SimpleSwitchWithCustomColors()
            CustomThumbSwitchComponent()
        }
    }
}
@Composable
fun SimpleSwitch() {
    var switchCheckedState by remember { mutableStateOf(false) }
        Switch(
            checked = switchCheckedState,
            onCheckedChange = { switchCheckedState = it }
        )
}

@Composable
fun SimpleSwitchWithCustomColors() {
    var switchCheckedState by remember { mutableStateOf(false) }


        Switch(
            checked = switchCheckedState,
            onCheckedChange = { switchCheckedState = it },
            /*
            The "checkedIconColor" and "uncheckedIconColor" excluded from this list
            because you need to set an icon first, use the "thumbContent" parameter.
            You can find an example in the next section.
             */
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Green,
                checkedTrackColor = Color.LightGray,
                checkedBorderColor = Color.Green,
                uncheckedThumbColor = Color.Red,
                uncheckedTrackColor = Color.LightGray,
                uncheckedBorderColor = Color.Red,
                disabledCheckedThumbColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                disabledCheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                disabledCheckedBorderColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                disabledUncheckedThumbColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                disabledUncheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                disabledUncheckedBorderColor = Color.Red.copy(alpha = ContentAlpha.disabled),
            )
        )
}
@Composable
fun CustomThumbSwitchComponent() {
    var switchCheckedState by remember { mutableStateOf(false) }
    Switch(
        checked = switchCheckedState,
        onCheckedChange = { switchCheckedState = it },
        thumbContent = {
            Icon(
                imageVector = if (switchCheckedState) Icons.Filled.Check else Icons.Filled.Close,
                contentDescription = null,
                modifier = Modifier.size(SwitchDefaults.IconSize)
            )
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Green,
            checkedIconColor = Color.DarkGray,
            uncheckedThumbColor = Color.Red,
            uncheckedIconColor = Color.LightGray,
            disabledCheckedThumbColor = Color.Green.copy(alpha = ContentAlpha.disabled),
            disabledUncheckedThumbColor = Color.Red.copy(alpha = ContentAlpha.disabled),
        )
    )
    if(switchCheckedState){
        Text(text = "Selected Value")
    }
    
}