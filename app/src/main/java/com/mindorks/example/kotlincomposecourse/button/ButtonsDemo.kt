package com.example.example1.button

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.rounded.AcUnit
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.AddCard
import androidx.compose.material.icons.rounded.AddCircleOutline
import androidx.compose.material.icons.rounded.Mail
import androidx.compose.material.icons.rounded.MyLocation
import androidx.compose.material.icons.rounded.NearMe
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonsEx(sharedViewModel: SharedViewModel=SharedViewModel()) {
    //var checked by remember { mutableStateOf(true) }
    val context = LocalContext.current
    Column {
        Button(onClick = {
            Toast.makeText(context,"Button Clicked",Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Submit")
        }
        ElevatedButton(onClick = { }, elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 2.dp, pressedElevation = 5.dp, disabledElevation = 3.dp
        )) {
            Text(text = "Elevated Button")
        }
        FloatingActionButton(containerColor = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(16.dp), onClick = {}){
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "",
                tint = Color.White
            )
        }
        FilledIconButton(onClick = {

        }){
            Icon(
                imageVector = Icons.Rounded.Settings,
                contentDescription = "",
                tint = Color.White,
            )
        }
        FilledTonalButton(onClick = {

        }){
            Text(text = "FilledTonalButton")
        }
        IconButton(onClick = {

        }){
            Icon(
                imageVector = Icons.Rounded.AccessTime,
                contentDescription = "Location FAB",
                tint = Color.Black,
            )
        }
        OutlinedIconButton(onClick = { }){
            Icon(
                imageVector = Icons.Rounded.AddCard,
                contentDescription = "Location FAB",
                tint = Color.Black,
            )
        }
        OutlinedButton(onClick = {

        }){
            Text(text = "OutlinedButton")
        }
        TextButton(onClick = {  }) {
            Text(text = "TextButton")
        }
        /*var txt by remember { mutableStateOf("") }
        Text(text = "$txt")
        //1-Button
        Button(onClick = { txt = "Normal Button clicked." }) {
            Icon(
                modifier = Modifier.padding(end = 8.dp), imageVector = Icons.Rounded.NearMe,
                contentDescription = "Navigate FAB",
               *//* tint = Color.Black*//*
            )
            Text(text = "Normal Button")
        }
        //2-ElevatedButton
        ElevatedButton(
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 2.dp, pressedElevation = 5.dp
            ),
            onClick = { txt = "Elevated Button clicked." }, modifier = Modifier.padding(5.dp)
        ) {
            Text(text = "Elevated Button")
        }

        //3-ExtendedFloatingActionButton
        ExtendedFloatingActionButton(
            shape = RoundedCornerShape(100),
            modifier = Modifier.padding(5.dp),
            onClick = {
            }) {
            Icon(
                imageVector = Icons.Rounded.NearMe,
                contentDescription = "Navigate FAB",
                tint = Color.Black
            )
            Text(text = "Extended Floating Action Button")
        }

        //4-FloatingActionButton
        FloatingActionButton(
            onClick = {
                //OnClick Method
            },
            containerColor = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(16.dp),
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "Add FAB",
                tint = Color.White,
            )
        }

        //5-LargeFloatingActionButton
        LargeFloatingActionButton(
            onClick = {
                //OnClick Method
            },
            containerColor = MaterialTheme.colorScheme.primary,
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "Add FAB",
                tint = Color.White,
            )
        }

        //6-SmallFloatingActionButton
        SmallFloatingActionButton(
            onClick = { //sharedViewModel.smallFabOnClick.value.invoke()
            },
            containerColor = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(12.dp),
        ) {
            Icon(
                imageVector = Icons.Rounded.MyLocation,
                contentDescription = "Location FAB",
                tint = Color.White,
            )
        }
        //Multiselected
        val checkedList = remember { mutableStateListOf<Int>() }
        val options1 = listOf("Favorites", "Trending", "Saved")
        val icons = listOf(
            Icons.Filled.StarBorder,
            Icons.AutoMirrored.Filled.TrendingUp,
            Icons.Filled.BookmarkBorder
        )
        MultiChoiceSegmentedButtonRow(modifier = Modifier.padding(5.dp)) {
            options1.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = options1.size),
                    icon = {
                        SegmentedButtonDefaults.Icon(active = index in checkedList) {
                            Icon(
                                imageVector = icons[index],
                                contentDescription = null,
                                modifier = Modifier.size(SegmentedButtonDefaults.IconSize)
                            )
                        }
                    },
                    onCheckedChange = {
                        if (index in checkedList) {
                            checkedList.remove(index)
                        } else {
                            checkedList.add(index)
                        }
                    },
                    checked = index in checkedList
                ) {
                    Text(label)
                }
            }
        }

        /// FilledIconButton
        FilledIconButton(onClick = {
            txt = "FilledIconButton Clicked"
        }){
            Icon(
                imageVector = Icons.Rounded.MyLocation,
                contentDescription = "Location FAB",
                tint = Color.White,
            )
        }
        var selectedIndex by remember { mutableStateOf(0) }
        val options = listOf("Day", "Month", "Week")

        SingleChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                    onClick = { selectedIndex = index },
                    selected = index == selectedIndex
                ) {
                    Text(label)
                }
            }
        }
        //https://developer.android.com/jetpack/compose/components/switch
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,
                checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            thumbContent = if (checked) {
                {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize),
                    )
                }
            } else {
                null
            }
        )

        FilledIconToggleButton(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        ){
            if(checked){
                Icon(
                    imageVector = Icons.Rounded.MyLocation,
                    contentDescription = "Location FAB",
                    tint = Color.White,
                )
            }else{
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Location FAB",
                    tint = Color.White,
                )
            }

        }

        FilledTonalButton(onClick = {
            
        }){
            Text(text = "FilledTonalButton")
        }

        FilledTonalIconButton(onClick = {}){
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "Location FAB",
                tint = Color.Black,
            )
        }

        FilledTonalIconToggleButton(checked  = checked, onCheckedChange = {
            checked = it
        }){
            Icon(
                imageVector = Icons.Rounded.MyLocation,
                contentDescription = "Location FAB",
                tint = Color.Black,
            )
        }

        IconButton(onClick = {

        }){
            Icon(
                imageVector = Icons.Rounded.AccessTime,
                contentDescription = "Location FAB",
                tint = Color.Black,
            )
        }
        OutlinedIconToggleButton(checked = true, onCheckedChange = {

        }){
            Icon(
                imageVector = Icons.Rounded.AcUnit,
                contentDescription = "Location FAB",
                tint = Color.Black,
            )
        }
        OutlinedIconButton(onClick = { }){
            Icon(
                imageVector = Icons.Rounded.AddCard,
                contentDescription = "Location FAB",
                tint = Color.Black,
            )
        }
        OutlinedButton(onClick = {

        }){
            Text(text = "OutlinedButton")
        }
        IconToggleButton(checked = checked, onCheckedChange = {checked = true}){
            Icon(
                imageVector = Icons.Rounded.AddCircleOutline,
                contentDescription = "Location FAB",
                tint = Color.Black,
            )
        }

        TextButton(onClick = {  }) {
            Text(text = "TextButton")
        }*/

        //MultiChoiceSegmentedButtonRow
        //SegmentedButton
        //SingleChoiceSegmentedButtonRow


    }
}