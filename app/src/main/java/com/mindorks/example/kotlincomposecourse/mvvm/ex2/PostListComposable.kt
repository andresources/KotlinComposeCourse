package com.mindorks.example.kotlincomposecourse.mvvm.ex2

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text

@Composable
fun PostListComposable(viewModel: PostViewModel) {
   /* val posts = viewModel.posts
    if(posts.isEmpty()){
        Text(text = "Loading..", color = Color.Red)
    }
    LazyColumn {
        item {
            posts.forEach {
                Card(modifier = Modifier.padding(5.dp)) {
                    Text(text = it.title, color = Color.Black,modifier = Modifier.padding(5.dp))
                }
            }
        }
    }*/
    //collectAsStateWithLifecycle
    val posts = viewModel.uiState.collectAsState()
    if(posts.value.isEmpty()){
        Text(text = "Loading Data ...", color = Color.Red)
    }
    LazyColumn {
        item {
            posts.value.forEach {
                Card(modifier = Modifier.padding(5.dp)) {
                    Text(text = it.title, color = Color.Black,modifier = Modifier.padding(5.dp))
                }
            }
        }
    }
    DisposableEffect(Unit) {
        viewModel.getPosts()
        onDispose {}
    }
}