package com.mindorks.example.kotlincomposecourse

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.click
import androidx.compose.ui.test.doubleClick
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performGesture
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mindorks.example.kotlincomposecourse.gesture.ButtonGesturesComposable
import com.mindorks.example.kotlincomposecourse.testing.TestingComp2ButtonClick
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GesturesComposableTesting {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testingComp2ButtonClick() {
        // Start the app
        composeTestRule.setContent {
            ButtonGesturesComposable()
        }

        composeTestRule.onNodeWithTag("box_tag").performGesture {
            this.doubleClick()
        }
        composeTestRule.onNodeWithText("onDoubleClicked").assertIsDisplayed()
        composeTestRule.waitUntilTimeout(5000L)
        composeTestRule.onNodeWithTag("box_tag").performGesture {
            this.longClick()
        }
        composeTestRule.onNodeWithText("onLongClicked").assertIsDisplayed()
        composeTestRule.waitUntilTimeout(5000L)
        composeTestRule.onNodeWithTag("box_tag").performGesture {
            this.click()
        }
        composeTestRule.onNodeWithText("onClicked").assertIsDisplayed()
        composeTestRule.waitUntilTimeout(5000L)
    }
}