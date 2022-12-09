package com.example.tendodemo.ui.survey

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SurveyScreenViewModel @Inject constructor(

): ViewModel() {
    private var currentPage by mutableStateOf(SurveyPage.RECOMMEND_RATING)
    private var rating by mutableStateOf(0)
    private var explainedDiagnosis by mutableStateOf<Boolean?>(null)
    private var feedback by mutableStateOf("")

    val uiState: StateFlow<SurveyScreenState> = combine(
        snapshotFlow { currentPage },
        snapshotFlow { rating },
        snapshotFlow { explainedDiagnosis },
        snapshotFlow { feedback }
    ) { page, rating, diagnosis, feedback ->
        SurveyScreenState(
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
    val currentPage: SurveyPage = SurveyPage.RECOMMEND_RATING,
    val rating: Int = 0,
    val explainedDiagnosis: Boolean? = null,
    val feedback: String = ""
)