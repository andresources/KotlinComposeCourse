package com.mindorks.example.kotlincomposecourse.kotlinflows
//https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/as-state-flow.html
/*
    Flows is streams of data whose values are being computed asynchronously.
    There are 2 types of flows: 1.hot flows and 2.cold flows
    Cold flows don’t produce any values until we collect them with one of the operators such as collect(), first(), toList()
    Hot flows on the other hand will start producing values as soon as they are created, regardless if nobody is consuming them.

    Flow builders:
    There are the following basic ways to create a flow:
    1.flowOf(...) functions to create a flow from a fixed set of values.
    2.asFlow() extension functions on various types to convert them into flows.
    3.flow { ... } builder function to construct arbitrary flows from sequential calls to "emit" function.
    4.channelFlow { ... } builder function to construct arbitrary flows from potentially concurrent calls to the "send" function.
    5.MutableStateFlow and MutableSharedFlow

    The great thing about flows is that they’re designed to work seamlessly with coroutines.
    This gives us the ability to fetch data from different data sources or update the UI without blocking the main thread in Android.

    If we imagine flows as pipelines, the components that are required to make the pipeline work are:
    Producer – Puts data inside the pipeline
    Consumer – Receives data from the pipeline


 */