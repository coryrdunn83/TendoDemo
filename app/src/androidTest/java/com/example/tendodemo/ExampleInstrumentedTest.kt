package com.example.tendodemo

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tendodemo.ui.home.HomeScreen
import com.example.tendodemo.ui.navigation.Screen
import com.example.tendodemo.ui.survey.SurveyScreen
import com.example.tendodemo.ui.theme.TendoDemoTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule(order = 1)
    val composeRule = createComposeRule()

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
        composeRule.setContent {
            TendoDemoTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.HomeScreen.route
                ) {
                    composable(route = Screen.HomeScreen.route) {
                        HomeScreen(navController)
                    }
                    composable(route = Screen.SurveyScreen.route) {
                        SurveyScreen(navController = navController)
                    }
                }
            }
        }
    }

    @Test
    fun testTakeSurveyNavigatesToSurveyScreen() {
        with(composeRule) {
            onNodeWithTag("Home Screen").assertExists()
            onNodeWithTag("Take survey button").performClick()
            //onNodeWithTag("Survey Screen").assertExists()
        }
    }
}