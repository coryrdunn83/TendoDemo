package com.example.tendodemo.ui.survey

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.tendodemo.ui.survey.pages.DiagnosisPage
import com.example.tendodemo.ui.survey.pages.FeelingsPage
import com.example.tendodemo.ui.survey.pages.RecommendRatingPage
import com.example.tendodemo.ui.survey.pages.ReviewPage

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun SurveyScreen(
    viewModel: SurveyScreenViewModel = hiltViewModel(),
    navController: NavController
) {
    val uiState: SurveyScreenState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .testTag("Survey Screen")
    ) {
        when (uiState.currentPage) {
            SurveyPage.RECOMMEND_RATING -> {
                RecommendRatingPage(
                    viewModel = viewModel,
                    patientName = uiState.patientName,
                    doctorName = uiState.patientDoctorName
                )
            }
            SurveyPage.DIAGNOSIS -> {
                DiagnosisPage(
                    viewModel = viewModel,
                    explainedDiagnosis = uiState.explainedDiagnosis,
                    patientDiagnosis = uiState.patientDiagnosis,
                    patientDoctorName = uiState.patientDoctorName
                )
            }
            SurveyPage.FEELINGS -> {
                FeelingsPage(
                    viewModel = viewModel,
                    feedback = uiState.feedback,
                    patientDiagnosis = uiState.patientDiagnosis
                )
            }
            SurveyPage.REVIEW -> {
                ReviewPage(
                    uiState = uiState,
                    navController = navController
                )
            }
        }
    }
}