package com.mindorks.example.kotlincomposecourse.interactors

/*
1. If a user touches a button, the button generates PressInteraction.Press.
2. If the user lifts their finger inside the button, it generates a PressInteraction.Release.
3. You can see the interactions for a particular component by observing its InteractionSource
4. InteractionSource is built on top of Kotlin flows
 */