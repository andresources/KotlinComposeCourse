package com.mindorks.example.kotlincomposecourse.kotlinflows.stateflow

/*
Normal Flow:
--------------
val activeUsers = flow<List<String>> { emit(listOf("user1", "user2", "user")) }

Convert to StateFlow
---------------------
 val activeUsers = flow<List<String>> { emit(listOf("user1", "user2", "user")) }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

SharingStarted is an interface that is used to define the behavior of shared coroutines.
1.SharingStarted.WhileSubscribed – Coroutine will be active as long as it has at least one active collector. In the case of multiple collectors, once the last one is canceled or completed, the coroutine will be paused or canceled.
2.SharingStarted.Eagerly – Coroutine will start regardless of whether there are active collectors or not.
3.SharingStarted.Lazily – Coroutine will start only when there is at least one active collector.

How to collect flows
-----------------------
We mentioned already that in order to consume flow we have to use one of the terminal operators such as collect.
When it comes to Jetpack Compose and consuming flows, things are a little bit different. Because now we have to deal with the state,
   Google provided us with the collectAsState() function.
collectAsState() is used to collect values from a Flow and convert them into state objects.
So every time a new value is posted into a pipeline returned state object which then will cause recomposition of every composable function that is using our flow value.


Let’s say you have a simple counter that counts indefinitely.
class MyViewModel : ViewModel() {
   private var secondsCounter = 0
   val secondsPassed = flow {
       while (true) {
           delay(1000)
           secondsCounter += 1
           emit(secondsCounter)
       }
   }.stateIn(viewModelScope,SharingStarted.WhileSubscribed(5000L),0)
}

@Composable
fun MyScreen(myViewModel: MyViewModel) {
   Surface {
       val secondsPassed by myViewModel.secondsPassed.collectAsState(0) //it is not goog solution
       val secondsPassed by myViewModel.secondsPassed.collectAsStateWithLifecycle() //Good Solution
       Text(text = secondsPassed.toString())
   }
}
collectAsState() is not lifecycle-aware
collectAsStateWithLifecycle()
implementation "androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version"
This will make sure that our composables are only recomposed when the composing component is active and visible on the screen.
It will automatically stop collecting values when the component is not active anymore, preventing unnecessary updates and reducing resource usage.
 */