package com.mindorks.example.kotlincomposecourse.mvvm.ex3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import com.mindorks.example.kotlincomposecourse.mvvm.ex2.Post
import com.mindorks.example.kotlincomposecourse.mvvm.ex2.PostViewModel

@Composable
fun Ex3PostListComposable(viewModel: GenericPostsViewModel) {
    val state by viewModel.state.collectAsState()
    when(state){
        is State.START ->{
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
               Text(text = "Started", color = Color.Red)
            }
        }
        is State.LOADING ->{
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
            }
        }
        is State.SUCCESS ->{
            loadData((state as State.SUCCESS).posts)
        }
        is State.FAILURE ->{

        }
    }
}

@Composable
fun loadData(posts: List<Post>) {
    LazyColumn {
        item {
            posts.forEach {
                Card(modifier = Modifier.padding(5.dp)) {
                    Text(text = it.title, color = Color.Black,modifier = Modifier.padding(5.dp))
                }
            }
        }
    }
}