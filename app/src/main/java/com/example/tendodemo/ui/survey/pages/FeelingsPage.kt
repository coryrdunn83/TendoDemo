package com.example.tendodemo.ui.survey.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tendodemo.R
import com.example.tendodemo.ui.survey.SurveyScreenViewModel
import com.example.tendodemo.ui.theme.TendoBlue
import com.example.tendodemo.ui.theme.TendoTextGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeelingsPage(
    viewModel: SurveyScreenViewModel,
    feedback: String = "",
    patientDiagnosis: String = ""
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.survey_feelings_question, patientDiagnosis),
                fontSize = 14.sp,
                color = TendoTextGray
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = feedback,
                onValueChange = { viewModel.updateFeedback(it) },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    textColor = TendoTextGray
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(horizontal = 6.dp, vertical = 4.dp)
                        .clickable {
                            viewModel.advancePage()
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