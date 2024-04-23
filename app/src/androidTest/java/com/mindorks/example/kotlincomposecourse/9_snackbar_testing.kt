package com.mindorks.example.kotlincomposecourse

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mindorks.example.kotlincomposecourse.snackbarhost.SnackBarHostComposable
import com.mindorks.example.kotlincomposecourse.testing.TestingComp1
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SnackbarComposableTesting {
    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun testingComp1() {
        // Start the app
        composeTestRule.setContent { //initializes the Compose UI
            SnackBarHostComposable()
        }
        composeTestRule.onNodeWithText("Submit").performClick()
        composeTestRule.onNodeWithText("Action").isDisplayed()
        composeTestRule.onNodeWithText("This is snackbar").isDisplayed()
        composeTestRule.waitUntilTimeout(3000)
        composeTestRule.onNodeWithText("Action").performClick()
        composeTestRule.onNodeWithText("Actioned").isDisplayed()
        composeTestRule.waitUntilTimeout(3000)
        composeTestRule.onNodeWithText("Submit").performClick()
        composeTestRule.waitUntilTimeout(1000)
        composeTestRule.onNodeWithText("Submit").performClick()
        composeTestRule.waitUntilTimeout(1000)
        composeTestRule.onNodeWithContentDescription("dismissAction").performClick()
        composeTestRule.onNodeWithText("Dismissed").isDisplayed()
        composeTestRule.waitUntilTimeout(3000)
        /*composeTestRule.onNodeWithText("Done").assertIsDisplayed()
        composeTestRule.onNodeWithText("Done").assert(hasText("Done"))*/
    }
}