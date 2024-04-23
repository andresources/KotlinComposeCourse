package com.mindorks.example.kotlincomposecourse

import androidx.compose.ui.semantics.Role.Companion.RadioButton
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mindorks.example.kotlincomposecourse.radiobutton.MultipleRadioButtons
import com.mindorks.example.kotlincomposecourse.testing.TestingComp1
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RadioButtonComposableTesting {
    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun testingComp1() {
        // Start the app
        composeTestRule.setContent { //initializes the Compose UI
            MultipleRadioButtons()
        }
        composeTestRule.onNodeWithText("Item 1").performClick()
        composeTestRule.waitUntilTimeout(3000)
        composeTestRule.onNodeWithText("Item 2").performClick()
        composeTestRule.waitUntilTimeout(3000)
        composeTestRule.onNodeWithText("Item 3").performClick()

    }
}