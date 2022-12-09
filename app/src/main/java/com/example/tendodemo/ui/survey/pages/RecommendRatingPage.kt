package com.example.tendodemo.ui.survey.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.tendodemo.ui.survey.SurveyScreenViewModel
import com.example.tendodemo.ui.theme.TendoBlue
import com.example.tendodemo.ui.theme.TendoTextGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendRatingPage(
    viewModel: SurveyScreenViewModel
) {
    val rating = remember{ mutableStateOf("") }
    val ratings = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
    var isError = remember{ mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hi Patient, on a scale of 1-10, would you recommend Dr. Name to a friend or family member?",
                fontSize = 14.sp,
                color = TendoTextGray
            )
            TextField(
                value = rating.value,
                onValueChange = { rating.value = it },
                isError = isError.value,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    textColor = TendoTextGray
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(
                    onClick = {
                        if (ratings.contains(rating.value)) {
                            viewModel.updateRating(rating.value.toInt())
                            viewModel.advancePage()
                        } else {
                            isError.value = true
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Next",
                        tint = TendoBlue
                    )
                }
            }
        }
    }
}