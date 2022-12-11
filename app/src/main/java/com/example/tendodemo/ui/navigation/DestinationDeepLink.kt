package com.example.tendodemo.ui.navigation

import android.net.Uri
import androidx.core.net.toUri

object DestinationDeepLink {
    private val baseUri = "https://coryrdunn.com".toUri()
    val surveyDeepLink = "$baseUri/${Screen.SurveyScreen.route}"
    fun getSurveyUri(): Uri = surveyDeepLink.toUri()
}