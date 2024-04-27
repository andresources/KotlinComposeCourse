package com.mindorks.example.kotlincomposecourse

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mindorks.example.kotlincomposecourse.testing.TestingComp1
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FindComposableTesting {
    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun testingComp1() {
        // Start the app
        composeTestRule.setContent { //initializes the Compose UI
            TestingComp1()
        }
        composeTestRule.onNodeWithText("Done").assertExists() //Asserts that the component was found and is part of the component tree.
        composeTestRule.onNodeWithText("Done1").assertDoesNotExist()
        composeTestRule.onNodeWithText("Done").assertIsDisplayed()
        composeTestRule.onNodeWithText("Done").assert(hasText("Done"))
        composeTestRule.onNodeWithText("Done").printToLog("TAG")
    }
}