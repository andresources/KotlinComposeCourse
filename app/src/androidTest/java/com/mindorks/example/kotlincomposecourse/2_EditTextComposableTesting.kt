package com.mindorks.example.kotlincomposecourse

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mindorks.example.kotlincomposecourse.testing.TestingComp3EditText
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class `2_EditTextComposableTesting` {
    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun testingComp1() {
        // Start the app
        composeTestRule.setContent { //initializes the Compose UI
            TestingComp3EditText()
        }
        composeTestRule
            .onNodeWithText("Enter Name")
            .assertExists()
        composeTestRule
            .onNodeWithText("Enter Name").performTextInput("Compose")
        composeTestRule.waitUntilTimeout(10000)
    }
}