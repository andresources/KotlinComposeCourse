package com.mindorks.example.kotlincomposecourse

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mindorks.example.kotlincomposecourse.testing.TestingComp1
import com.mindorks.example.kotlincomposecourse.testing.TestingComp2ButtonClick
import com.mindorks.example.kotlincomposecourse.ui.theme.KotlinComposeCourseTheme
import kotlinx.coroutines.time.delay
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Timer
import kotlin.concurrent.schedule

//Instrumented test, which will execute on an Android device.
@RunWith(AndroidJUnit4::class)
class ComposableTesting {
    @get:Rule
    val composeTestRule = createComposeRule()
    //createComposeRule() is employed to initialize the Compose UI framework.
    // use createAndroidComposeRule<YourActivity>() if you need access to an activity
    @Test
    fun testingComp1() {
        // Start the app
        composeTestRule.setContent { //initializes the Compose UI
                TestingComp1()
        }
        //composeTestRule.onNodeWithText("Continue").performClick()
        composeTestRule.onNodeWithText("Done").assertIsDisplayed()
    }
    @Test
    fun testingComp2ButtonClick() {
        // Start the app
        composeTestRule.setContent {
                TestingComp2ButtonClick()
        }
        composeTestRule.onNodeWithText("Submit").performClick() //
        composeTestRule.onNodeWithText("Hai").assertIsDisplayed() //Assertions are employed to confirm expected UI states or behaviors.
        composeTestRule.waitUntilTimeout(5000L)
    }
}