package com.mindorks.example.kotlincomposecourse.kotlinflows
//https://www.valueof.io/blog/stateflow-vs-sharedflow-jetpack-compose
/*
    If you write primarily Android code in Kotlin, it’s time "to adopt StateFlow for tasks you used LiveData for."
    So in your ViewModel, your LiveData code:

   Live Data :
        private val _myLiveData = MutableLiveData<String>()
        val myLiveData = _myLiveData

               CAN BE REPLACED WITH

   State Flow :
        private val _myStateFlow = MutableStateFlow("")
        val myStateFlow = _myStateFlow.asStateFlow()


   What is the StateFlow?
   ======================
   *StateFlow is a state-holder observable flow that emits the current and new state updates to its collectors.
   *StateFlow is suitable for showing current state and preserving it during configuration changes such as screen rotations.

 */
/*
1.StateFlow provides built-in lifecycle awareness.That means collecting StateFlow within a composable will start only after the component is active

 */