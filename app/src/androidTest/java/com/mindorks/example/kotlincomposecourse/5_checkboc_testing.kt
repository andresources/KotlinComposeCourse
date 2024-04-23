package com.mindorks.example.kotlincomposecourse

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mindorks.example.kotlincomposecourse.checkboxdemo.CheckboxWithLabelExample
import com.mindorks.example.kotlincomposecourse.radiobutton.MultipleRadioButtons
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CheckboxComposableTesting {
    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun testingComp1() {
        // Start the app
        composeTestRule.setContent { //initializes the Compose UI
            CheckboxWithLabelExample()
        }
        composeTestRule.onNodeWithTag("TEST_TAG").performClick()

        composeTestRule.waitUntilTimeout(3000)

    }
}