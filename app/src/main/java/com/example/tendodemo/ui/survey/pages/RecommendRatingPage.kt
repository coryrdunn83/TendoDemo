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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tendodemo.R
import com.example.tendodemo.ui.survey.SurveyScreenViewModel
import com.example.tendodemo.ui.theme.TendoBlue
import com.example.tendodemo.ui.theme.TendoTextGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendRatingPage(
    viewModel: SurveyScreenViewModel,
    patientName: String = stringResource(id = R.string.survey_general_next_btn_text),
    doctorName: String = ""
) {
    val rating = remember{ mutableStateOf("") }
    val ratings = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
    val isError = remember{ mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize().testTag("RRP")
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.survey_rating_question, patientName, doctorName),
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
                            text = stringResource(id = R.string.survey_general_next_btn_text).uppercase(),
                            color = TendoBlue,
                            fontSize = 16.sp
                        )
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowRight,
                            contentDescription = stringResource(id = R.string.survey_general_next_icon_desc),
                            tint = TendoBlue,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    }
}