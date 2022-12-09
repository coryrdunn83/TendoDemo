package com.example.tendodemo.ui.survey

enum class SurveyPage(val index: Int) {
    RECOMMEND_RATING(0),
    DIAGNOSIS(1),
    FEELINGS(2),
    REVIEW(3);

    companion object {
        fun getPageFromIndex(index: Int): SurveyPage {
            return when (index) {
                0 -> RECOMMEND_RATING
                1 -> DIAGNOSIS
                2 -> FEELINGS
                3 -> REVIEW
                else -> error("Invalid page index: $index")
            }
        }
    }
}