package com.mindorks.example.kotlincomposecourse.kotlinflows
//https://vtsen.hashnode.dev/exploring-android-livedata-usages-and-behaviors
//https://medium.com/androiddevelopers/viewmodel-one-off-event-antipatterns-16a1da869b95
/*
Kotlin Flow is a cold stream,
Kotlin Channel is a hot stream.
Cold Stream -  has only one subscriber per stream, new subscription creates new stream.
Hot stream - has no or many subscribers per stream, new subscription uses existing stream.
Cold - start emitting values only when someone start subscribing to it.
Hot - start emitting values even it does NOT have any subscribers

val flow: Flow<Int> = flow {
    repeat(10000) { value ->
        delay(1000)
        emit(value)
    }
}
The data won't be emitted until the Flow<T>.collect() is called.

viewModelScope.launch {
    flow.collect {  value ->
        /* collecting $value here */
    }
}

Create the Channel
private val channel = Channel<Int>()

Send Data into the Hot Stream
viewModelScope.launch {
    repeat(10000) { value ->
        delay(1000)
        channel.send(value)
    }
}
Hot stream is like a buffer, which has the buffer capacity. The default buffer capacity is zero.
To receive the channel’s data
viewModelScope.launch {
    while(true) {
        val value = channel.receive()
    }
}
Flow - store single value that changes over time.
Channel - store one-time event
 */
