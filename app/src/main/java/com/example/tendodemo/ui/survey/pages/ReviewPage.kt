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
    viewModel: SurveyScreenViewModel,
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
                text = "Thanks again! Here's what we heard:",
                fontSize = 16.sp,
                color = TendoTextGray,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "You rated your likelihood of recommending Dr. Name to friends and family" +
                    " as ${uiState.rating}/10",
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
                            contentDescription = "Star",
                            tint = TendoTeal
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_star_border_24),
                            contentDescription = "Star",
                            tint = TendoTeal
                        )
                    }
                    Spacer(modifier = Modifier.width(2.dp))
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Dr. Name did ${if (uiState.explainedDiagnosis == false) "not " else ""}manage " +
                    "to explain your diagnosis in a way that you understood.",
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
                    contentDescription = "Satisfaction Icon",
                    tint = TendoTeal
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            if (uiState.feedback.isEmpty()) {
                Text(
                    text = "You did not provide any feedback on your feelings about being diagnosed with blank.",
                    fontSize = 14.sp,
                    color = TendoTextGray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                Text(
                    text = "You expressed the following on your feelings about being diagnosed with blank:",
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
                    Text(text = "Submit")
                }
            }
        }
    }
}