package com.example.tendodemo

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.tendodemo.di.DataModule
import com.example.tendodemo.ui.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@HiltAndroidTest
@UninstallModules(DataModule::class)
class ExampleInstrumentedTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun testTakeSurveyNavigatesToSurveyScreen() {
        with(composeRule) {
            // Make sure Home Screen exists
            onNodeWithTag("Home Screen").assertExists()
            // Perform click on survey button
            onNodeWithTag("Take survey button").performClick()

            // Make sure app successfully navigates to Survey Screen displaying Recommended Rating Page
            onNodeWithTag("RRP").assertIsDisplayed()
        }
    }
}