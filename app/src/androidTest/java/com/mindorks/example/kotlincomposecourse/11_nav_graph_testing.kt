package com.mindorks.example.kotlincomposecourse

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.example1.navcontroler.NavControllerDemo
import com.mindorks.example.kotlincomposecourse.testing.TestingComp1
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

    @RunWith(AndroidJUnit4::class)
    class NavControllerTesting {
        @get:Rule
        val composeTestRule = createComposeRule()

        @Test
        fun testingNav() {
            // Start the app
            composeTestRule.setContent { //initializes the Compose UI
                NavControllerDemo()
            }
            // Test Case 1: Verify initial screen (Screen1)
            composeTestRule.onNodeWithText("This is Home Screen").assertIsDisplayed()
            composeTestRule.waitUntilTimeout(3000)
            composeTestRule.onNodeWithText("Go to Add Project").performClick()
            composeTestRule.onNodeWithText("This is Add Project").assertIsDisplayed()
            composeTestRule.waitUntilTimeout(3000)
            composeTestRule.onNodeWithText("Go to Add Task").performClick()
            composeTestRule.onNodeWithText("This is Add Task").assertIsDisplayed()
            composeTestRule.waitUntilTimeout(3000)
        }
    }
