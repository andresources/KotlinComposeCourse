package com.mindorks.example.kotlincomposecourse.composephases

/*
https://medium.com/androiddevelopers/jetpack-compose-debugging-recomposition-bfcf4a6f8d37
-----
Compose Phases:
1.Composition:(what to show) determines what to show by building a tree of Composables.
2.Layout(where to show): takes that tree and works out where on screen they will be shown
3.Drawing: then draws the composables to the screen.


******prefer lambda modifiers when using frequently changing state
Using lambda modifiers, we can improve the performance.
 */