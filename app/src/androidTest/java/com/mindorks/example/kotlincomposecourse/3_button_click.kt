package com.mindorks.example.kotlincomposecourse

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mindorks.example.kotlincomposecourse.testing.TestingComp2ButtonClick
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ButtonClickComposableTesting {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testingComp2ButtonClick() {
        // Start the app
        composeTestRule.setContent {
            TestingComp2ButtonClick()
        }
        composeTestRule.onNodeWithText("Submit").performClick() //
        composeTestRule.onNodeWithText("Hai")
            .assertIsDisplayed() //Assertions are employed to confirm expected UI states or behaviors.
        composeTestRule.waitUntilTimeout(5000L)
    }
}