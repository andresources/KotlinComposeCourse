package com.mindorks.example.kotlincomposecourse

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mindorks.example.kotlincomposecourse.mvvm.ex1.CreditCardScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class `13_RetrofitTesting` {
    @get:Rule
    val composeTestRule = createComposeRule()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun apiTesting() {

        composeTestRule.setContent { //initializes the Compose UI
            CreditCardScreen()
        }
        composeTestRule.waitUntilDoesNotExist(hasText("Loading..."),timeoutMillis = 20000)
        composeTestRule.onNodeWithText("success").assertIsDisplayed()
        composeTestRule.waitUntilTimeout(3000)
    }
}