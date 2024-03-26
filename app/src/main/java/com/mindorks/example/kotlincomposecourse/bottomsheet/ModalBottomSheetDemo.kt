package com.example.example1.bottomsheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetDemo() {
    var showSheet by remember { mutableStateOf(false) }

    if (showSheet) {
        MyBottomSheet{
            showSheet = false
        }
    }
    Button(modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight(), onClick = { showSheet = true }) {
       Text(text = "Show Model")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomSheet(onDismiss: ()->Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        onDismissRequest = {onDismiss.invoke() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Column {
            Button(onClick = { onDismiss.invoke() }) {
                Text(text = "Close")
            }
            repeat(10){
                Text(text = "Title - $it")
            }
        }
    }
}