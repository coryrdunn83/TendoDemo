package com.example.tendodemo.ui.navigation

import android.net.Uri
import androidx.core.net.toUri
import com.example.tendodemo.common.Constants.NOTIF_BASE_URI

object DestinationDeepLink {
    private val baseUri = NOTIF_BASE_URI.toUri()
    val surveyDeepLink = "$baseUri/${Screen.SurveyScreen.route}"
    fun getSurveyUri(): Uri = surveyDeepLink.toUri()
}