package com.example.tendodemo.ui.survey.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tendodemo.R
import com.example.tendodemo.ui.survey.SurveyScreenState
import com.example.tendodemo.ui.survey.SurveyScreenViewModel
import com.example.tendodemo.ui.theme.TendoPink
import com.example.tendodemo.ui.theme.TendoTeal
import com.example.tendodemo.ui.theme.TendoTextGray
import com.example.tendodemo.ui.theme.TendoWhite

@Composable
fun ReviewPage(
    uiState: SurveyScreenState,
    navController: NavController
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
                text = stringResource(id = R.string.survey_review_header_text),
                fontSize = 16.sp,
                color = TendoTextGray,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(id = R.string.survey_review_rating_text, uiState.patientDoctorName, uiState.rating),
                fontSize = 14.sp,
                color = TendoTextGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (int in 1..10) {
                    if (int <= uiState.rating) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = stringResource(id = R.string.survey_review_star_icon_desc),
                            tint = TendoTeal
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_star_border_24),
                            contentDescription = stringResource(id = R.string.survey_review_open_star_icon_desc),
                            tint = TendoTeal
                        )
                    }
                    Spacer(modifier = Modifier.width(2.dp))
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(
                    id = R.string.survey_review_diagnosis_text,
                    uiState.patientDoctorName,
                    if (uiState.explainedDiagnosis == false) " not" else ""
                ),
                fontSize = 14.sp,
                color = TendoTextGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(
                        id = if (uiState.explainedDiagnosis == true) R.drawable.ic_baseline_sentiment_very_satisfied_24
                        else R.drawable.ic_baseline_sentiment_very_dissatisfied_24
                    ),
                    contentDescription = stringResource(id = R.string.survey_review_satisfaction_icon_desc),
                    tint = TendoTeal
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            if (uiState.feedback.isEmpty()) {
                Text(
                    text = stringResource(id = R.string.survey_review_feedback_no_feedback_text, uiState.patientDiagnosis),
                    fontSize = 14.sp,
                    color = TendoTextGray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                Text(
                    text = stringResource(id = R.string.survey_review_feedback_header_text, uiState.patientDiagnosis),
                    fontSize = 14.sp,
                    color = TendoTextGray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = uiState.feedback,
                    fontSize = 14.sp,
                    color = TendoTeal,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    fontStyle = FontStyle.Italic
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = TendoPink,
                        contentColor = TendoWhite
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = stringResource(id = R.string.survey_review_submit_btn_text).uppercase())
                }
            }
        }
    }
}