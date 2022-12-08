package com.example.tendodemo.ui.navigation

import com.example.tendodemo.common.Constants.HOME_SCREEN
import com.example.tendodemo.common.Constants.SURVEY_SCREEN

sealed class Screen(val route: String) {
    object HomeScreen: Screen(HOME_SCREEN)
    object SurveyScreen: Screen(SURVEY_SCREEN)
}
