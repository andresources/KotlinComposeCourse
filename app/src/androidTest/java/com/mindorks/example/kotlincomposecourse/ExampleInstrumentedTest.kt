package com.mindorks.example.kotlincomposecourse

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mindorks.example.kotlincomposecourse.testing.TestingComp1
import com.mindorks.example.kotlincomposecourse.ui.theme.KotlinComposeCourseTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to an activity
    @Test
    fun myTest() {
        // Start the app
        composeTestRule.setContent {
            KotlinComposeCourseTheme {
                TestingComp1()
            }
        }
        //composeTestRule.onNodeWithText("Continue").performClick()
        composeTestRule.onNodeWithText("Done").assertIsDisplayed()
    }
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.mindorks.example.kotlincomposecourse", appContext.packageName)
    }
}