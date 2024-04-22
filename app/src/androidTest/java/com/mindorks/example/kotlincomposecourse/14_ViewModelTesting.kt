package com.mindorks.example.kotlincomposecourse

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mindorks.example.kotlincomposecourse.testing.viewmodel.TestingComposable
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class `14_ViewModelTesting` {
    @get:Rule
    val composeTestRule = createComposeRule()
    @OptIn(ExperimentalTestApi::class)
    @Test
    fun ViewModelTestingComp() {
        composeTestRule.setContent {
            TestingComposable()
        }
        composeTestRule.waitUntilDoesNotExist(hasText("Loading"),timeoutMillis = 20000)
        /*composeTestRule.waitUntil(timeoutMillis = 20000) {
            composeTestRule
                .onAllNodesWithText("Welcome")
                .fetchSemanticsNodes().size == 1
        }*/
        composeTestRule.onNodeWithText("Welcome").assertExists()
    }
}