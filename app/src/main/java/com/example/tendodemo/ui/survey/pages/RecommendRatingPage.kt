package com.example.tendodemo.ui.survey.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tendodemo.domain.models.PatientBundle
import com.example.tendodemo.ui.survey.SurveyScreenViewModel
import com.example.tendodemo.ui.theme.TendoBlue
import com.example.tendodemo.ui.theme.TendoTextGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendRatingPage(
    viewModel: SurveyScreenViewModel,
    patient: PatientBundle? = null
) {
    val rating = remember{ mutableStateOf("") }
    val ratings = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
    var isError = remember{ mutableStateOf(false) }

    val patientName = patient?.entry?.first()?.resource?.name?.first()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hi ${patientName ?: "patient"}, on a scale of 1-10, would you recommend Dr. Name to a friend or family member?",
                fontSize = 14.sp,
                color = TendoTextGray
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = rating.value,
                onValueChange = { rating.value = it },
                isError = isError.value,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    textColor = TendoTextGray
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(horizontal = 6.dp, vertical = 4.dp)
                        .clickable {
                            if (ratings.contains(rating.value)) {
                                viewModel.updateRating(rating.value.toInt())
                                viewModel.advancePage()
                            } else {
                                isError.value = true
                            }
                        }
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "NEXT",
                            color = TendoBlue,
                            fontSize = 16.sp
                        )
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowRight,
                            contentDescription = "Next",
                            tint = TendoBlue,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    }
}