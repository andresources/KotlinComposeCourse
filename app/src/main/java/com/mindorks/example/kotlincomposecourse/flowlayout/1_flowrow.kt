package com.mindorks.example.kotlincomposecourse.flowlayout

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowRowDemo() {
    var context = LocalContext.current
    var list = listOf<String>("Smoke-free","Dogs OK","Washer/Dryer","Ramp access","Garden","Cats OK")
    FlowRow(modifier = Modifier.padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    )
    {
        list.forEach {
            Box(modifier = Modifier
                .clickable {
                    Toast
                        .makeText(context, "$it", Toast.LENGTH_SHORT)
                        .show()
                }
                .padding(top = 5.dp)
                .background(Color.LightGray, RoundedCornerShape(200.dp))) {
                Text(modifier = Modifier.padding(top=5.dp,bottom=5.dp, start = 10.dp,end=10.dp), text = "$it")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun Filters() {
    var selList: MutableList<String> = mutableListOf()
    val filters = listOf(
        "Washer/Dryer", "Ramp access", "Garden", "Cats OK", "Dogs OK", "Smoke-free"
    )
    Column() {

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            filters.forEach { title ->
                var selected by remember { mutableStateOf(false) }
                val selectedItems: MutableState<List<String>> = mutableStateOf(listOf())
                val leadingIcon: @Composable () -> Unit = { Icon(Icons.Default.Check, null) }
                FilterChip(
                    selected,
                    onClick = {
                        selected = !selected
                        if (selected) {
                            selList.add(title)
                        } else {
                            selList.remove(title)
                        }

                    }, colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.Green,
                        iconColor = Color.White,
                        labelColor = Color.White,
                        selectedContainerColor = Color.Cyan,
                        selectedLabelColor = Color.Black,
                        selectedLeadingIconColor = Color.Black
                    ),
                    label = { Text(title) }, shape = RoundedCornerShape(200.dp),
                    leadingIcon = if (selected) leadingIcon else null
                )
            }
        }
        var context = LocalContext.current
        Button(onClick = {
            Toast.makeText(context.applicationContext,"${selList.size}",Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Subbmit")
        }
    }
}