package com.example.tendodemo.ui.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
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

        composable(
            route = Screen.SurveyScreen.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = DestinationDeepLink.surveyDeepLink
                    action = Intent.ACTION_VIEW
                }
            )
        ) {
            SurveyScreen(navController = navController)
        }
    }
}