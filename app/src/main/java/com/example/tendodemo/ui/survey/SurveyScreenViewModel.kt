package com.example.tendodemo.ui.survey

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tendodemo.domain.models.PatientBundle
import com.example.tendodemo.domain.repository.PatientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SurveyScreenViewModel @Inject constructor(
    patientRepository: PatientRepository
): ViewModel() {
    private var currentPage by mutableStateOf(SurveyPage.RECOMMEND_RATING)
    private var rating by mutableStateOf(0)
    private var explainedDiagnosis by mutableStateOf<Boolean?>(null)
    private var feedback by mutableStateOf("")

    val uiState: StateFlow<SurveyScreenState> = combine(
        patientRepository.patientDataFlow,
        snapshotFlow { currentPage },
        snapshotFlow { rating },
        snapshotFlow { explainedDiagnosis },
        snapshotFlow { feedback }
    ) { patient, page, rating, diagnosis, feedback ->
        SurveyScreenState(
            patientBundle = patient,
            currentPage = page,
            rating = rating,
            explainedDiagnosis = diagnosis,
            feedback = feedback
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(30000L),
            initialValue = SurveyScreenState()
        )

    fun advancePage() {
        currentPage = SurveyPage.getPageFromIndex(currentPage.index + 1)
    }

    fun updateRating(updatedRating: Int) {
        rating = updatedRating
    }

    fun updateExplainedDiagnosis(answer: Boolean) {
        explainedDiagnosis = answer
    }

    fun updateFeedback(answer: String) {
        feedback = answer
    }
}

data class SurveyScreenState(
    val patientBundle: PatientBundle? = null,
    val currentPage: SurveyPage = SurveyPage.RECOMMEND_RATING,
    val rating: Int = 0,
    val explainedDiagnosis: Boolean? = null,
    val feedback: String = ""
) {
    val patientName: String
        get() = patientBundle?.entry?.firstOrNull()?.resource?.name?.firstOrNull()?.given?.firstOrNull() ?: ""

    val patientDoctorName: String
        get() = patientBundle?.entry?.firstOrNull {
            it.resource.resourceType == "Doctor"
        }?.resource?.name?.firstOrNull()?.family ?: ""

    val patientDiagnosis: String
        get() = patientBundle?.entry?.firstOrNull {
            it.resource.resourceType == "Diagnosis"
        }?.resource?.code?.coding?.firstOrNull()?.name ?: ""
}