package com.example.tendodemo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tendodemo.ui.home.HomeScreen
import com.example.tendodemo.ui.survey.SurveyScreen

@Composable
fun TendoDemoNavHost(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.SurveyScreen.route) {
            SurveyScreen(navController = navController)
        }
    }
}