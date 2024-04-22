package com.mindorks.example.kotlincomposecourse

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.example1.navcontroler.NavControllerDemo
import com.example.example1.navcontroler.NavControllerDemoWithData
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class nav_data_testing() {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testingNav() {
        // Start the app
        composeTestRule.setContent { //initializes the Compose UI
            NavControllerDemoWithData()
        }
        composeTestRule
            .onNodeWithText("Enter something").performTextInput("Compose")
        composeTestRule.waitUntilTimeout(3000)
        composeTestRule
            .onNodeWithText("Go to Screen 2 with data").performClick()

        composeTestRule
            .onNodeWithText("Received data: Compose")
        composeTestRule.waitUntilTimeout(3000)


    }
}