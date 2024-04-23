package com.mindorks.example.kotlincomposecourse.snackbarhost


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SnackBarHostComposable(status: SnackBarHostViewModel = viewModel()) {
    /*val snackbarHostState = remember { SnackbarHostState() }.also {
        SnackbarHost(hostState = it)
    }*/
    var txt = remember {
        mutableStateOf("")
    }
    val snackbarHostState = remember { SnackbarHostState() }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)){
        LaunchedEffect(key1 = status._sb_status.value)
        {
            if(status._sb_status.value){
                snackbarHostState.showSnackbar("This is snackbar", duration = SnackbarDuration.Indefinite)
            }
        }
        Column{
            Button(onClick = {
                status._sb_status.value = !status._sb_status.value
            }) {
                Text(text = "Submit")
            }
            Text(text = txt.value, color = Color.Black)
        }

           Column(modifier = Modifier.align(Alignment.BottomCenter)){
               DefaultSnackbar(snackbarHostState){
                   when(it){
                       SnackbarResult.ActionPerformed -> {
                           txt.value = "Actioned"
                       }
                       SnackbarResult.Dismissed -> {
                           txt.value = "Dismissed"
                       }
                   }
               }
           }
    }

}

@Composable
fun DefaultSnackbar(
    snackbarHostState: SnackbarHostState,
    onActionsClicked :(SnackbarResult) -> Unit,
) {
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = {
            Snackbar(
                modifier = Modifier.padding(16.dp),
                content = {
                    Text(
                        text = it.visuals.message
                    )
                },
                contentColor = Color.White,
                action = {
                        TextButton(onClick = {
                            it.dismiss()
                            onActionsClicked(SnackbarResult.ActionPerformed)
                        }) {
                            Text(
                                text = "Action",
                            )
                        }
                },
                actionContentColor = Color.Yellow,
                dismissAction = {
                   Icon(
                       imageVector = Icons.Rounded.Close,
                       contentDescription = "dismissAction",
                       tint = Color.White, modifier = Modifier.clickable {
                           it.dismiss()
                           onActionsClicked(SnackbarResult.Dismissed)
                       }
                   )
               }
            )
        }
    )
}