package com.mindorks.example.kotlincomposecourse.livedata

/*
https://vtsen.hashnode.dev/exploring-android-livedata-usages-and-behaviors

    -LiveData : behaviors - setValue(), postValue(), observe(), and observeAsState().
    -Android LiveData is observable and lifecycle-aware data.
    -lifecycle owner is an activity
    -lifecycle-aware means it will only send updates to the UI when the activity is active
    -Activity is active means the UI is visible either in the background (started state) or in the foreground (resumed state).
    -LiveData also automatically removes all Observer objects when the activity is destroyed.

    Emit LiveData - setValue() / postValue()
    ----------------------------------------

 */