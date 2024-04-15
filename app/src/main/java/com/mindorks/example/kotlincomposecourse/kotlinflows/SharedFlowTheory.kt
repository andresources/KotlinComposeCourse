package com.mindorks.example.kotlincomposecourse.kotlinflows

/*  How to handle one-shot operations in Jetpack Compose? - Ans : SharedFlow
    SharedFlow : is a hot flow that emits values to all consumers that collect from it.
    SharedFlow can be used for one-time events.()
    We cannot use collectAsState() in our Composable
       since this is a one time event that does not get assigned an initial value

       Flow.ShareIn() converts Flow to SharedFlow

    If we don’t use LaunchedEffect, the Flow will be collect ed every time this Composable is recomposed.
    We use LaunchedEffect(true) and pass true as key to ensure that side effect gets called only once when the Composable gets composed initially.
 */