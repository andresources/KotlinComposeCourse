package com.mindorks.example.kotlincomposecourse

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.example1.dropdown.Demo_DropDownMenu
import com.mindorks.example.kotlincomposecourse.radiobutton.MultipleRadioButtons
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DropDownComposableTesting {
    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun testingComp1() {
        // Start the app
        composeTestRule.setContent { //initializes the Compose UI
            Demo_DropDownMenu()
        }
        composeTestRule.onNodeWithContentDescription("More").performClick()
        composeTestRule.waitUntilTimeout(3000)
        composeTestRule.onNodeWithText("New").performClick()
        composeTestRule.waitUntilTimeout(3000)
        composeTestRule.onNodeWithContentDescription("More").performClick()
        composeTestRule.waitUntilTimeout(3000)
        composeTestRule.onNodeWithText("Save").performClick()
        composeTestRule.waitUntilTimeout(3000)
    }
}