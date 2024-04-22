package com.mindorks.example.kotlincomposecourse

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.example1.dropdown.listsgrids.LazyColumnList
import com.example.example1.dropdown.listsgrids.LazyRowEmpList
import com.mindorks.example.kotlincomposecourse.testing.TestingComp1
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListComposableTesting {
    @get:Rule
    val composeTestRule = createComposeRule()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testingComp1() {
        val itemList = listOf("Header")
        composeTestRule.setContent { //initializes the Compose UI
            LazyColumnList()
        }
        // Test Case 1: Check if all items are displayed
        itemList.forEach { item ->
            composeTestRule.onNodeWithText(item).assertExists()
        }
        composeTestRule.waitUntilTimeout(3000)
        // Test Case 2: Scroll to a specific item and check if it's displayed
        composeTestRule.onNodeWithText("Name: 8").performScrollTo()
        composeTestRule.onNodeWithText("Name: 8").assertIsDisplayed()
        // Test Case 3: Click on an item and verify the action (assuming a click action)
        composeTestRule.onNodeWithText("Name: 8").performClick()
        composeTestRule.waitUntilTimeout(3000)

    }
}
