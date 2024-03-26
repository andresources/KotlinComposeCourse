package com.example.example1.launched_effect

/*
LaunchedEffect is a powerful API in Jetpack Compose for managing side effects within composable functions.
LaunchedEffect: run suspend functions in the scope of a composable
*LaunchedEffect is executed once when entered inside the composition. And it is canceled when leaving the composition.
*LaunchedEffect cancels/re-launch when Keys state changes
*LaunchedEffect Scope’s Dispatcher is Main.
It allows you to run asynchronous tasks, handle external data sources, and update the UI based on their results.
1. Launches a coroutine in the background to perform your desired side effect
2. Ensures the coroutine starts only when the composable composition occurs
3. Cancels the coroutine automatically when the composable is removed from the composition
4. Automatically starts and stops coroutines based on the composable lifecycle, preventing leaks and unnecessary operations
5. Only re-runs coroutines when their dependencies change, optimizing performance and avoiding redundant work
6. Launch multiple coroutines within the same LaunchedEffect block.
7. Key arguments: Use keys to manage multiple LaunchedEffect calls within the same composable.

 LaunchedEffect(someValue) {
// This coroutine will only re-run when someValue changes
}

 */

