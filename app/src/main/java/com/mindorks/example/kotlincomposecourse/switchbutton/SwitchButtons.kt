package com.example.example1.switchbutton

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Demo_SwitchComponent() {
    var switchCheckedState by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
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
                checkedTrackColor = Color.DarkGray,
                checkedIconColor = Color.DarkGray,
                uncheckedThumbColor = Color.Red,
                uncheckedIconColor = Color.LightGray,
                //disabledCheckedThumbColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                //disabledUncheckedThumbColor = Color.Red.copy(alpha = ContentAlpha.disabled),
            )
        )
    }
}