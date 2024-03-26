package com.example.example1.button

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MyLocation
import androidx.compose.material.icons.rounded.NearMe
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun FabClickedScreen(
    sharedViewModel: SharedViewModel,
) {
    val context = LocalContext.current
    val listState = rememberLazyListState()
    val expandedFabState = remember {
        derivedStateOf {
            listState.firstVisibleItemIndex == 0
        }
    }

    LaunchedEffect(key1 = expandedFabState.value) {
        sharedViewModel.expandedFab.value = expandedFabState.value
    }

    LaunchedEffect(key1 = Unit) {
        sharedViewModel.fabOnClick.value = {
            Toast.makeText(context, "Settings FAB Clicked", Toast.LENGTH_SHORT).show()
        }

        sharedViewModel.smallFabOnClick.value = {
            Toast.makeText(context, "Settings Small FAB Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    LazyColumn(state = listState, modifier = Modifier.fillMaxSize()) {
        for (index in 0 until 100) {
            item {
                Text(
                    text = "List item - $index",
                    modifier = Modifier.padding(24.dp)
                )
            }
        }
    }
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom,
    ) {
        SmallFloatingActionButton(
            onClick = { sharedViewModel.smallFabOnClick.value.invoke() },
            containerColor = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(12.dp),
        ) {
            Icon(
                imageVector = Icons.Rounded.MyLocation,
                contentDescription = "Location FAB",
                tint = Color.White,
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        ExtendedFloatingActionButton(
            text = {
                Text(text = "Navigate", color = Color.White)
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.NearMe,
                    contentDescription = "Navigate FAB",
                    tint = Color.White,
                )
            },
            onClick = { sharedViewModel.fabOnClick.value.invoke() },
            expanded = sharedViewModel.expandedFab.value,
            containerColor = MaterialTheme.colorScheme.primary,
        )
    }
}