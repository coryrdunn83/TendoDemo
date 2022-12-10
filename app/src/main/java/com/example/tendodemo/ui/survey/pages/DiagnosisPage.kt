package com.example.tendodemo.ui.survey.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tendodemo.ui.survey.SurveyScreenViewModel
import com.example.tendodemo.ui.theme.TendoBlue
import com.example.tendodemo.ui.theme.TendoPink
import com.example.tendodemo.ui.theme.TendoTextGray
import com.example.tendodemo.ui.theme.TendoWhite

@Composable
fun DiagnosisPage(
    viewModel: SurveyScreenViewModel,
    explainedDiagnosis: Boolean? = null
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
                text = "Thank you. You were diagnosed with blank. Did Dr. Name explain how to manage" +
                    " this diagnosis in a way you could understand?",
                fontSize = 14.sp,
                color = TendoTextGray
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { viewModel.updateExplainedDiagnosis(true) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (explainedDiagnosis == true) TendoPink else Color.Transparent,
                        contentColor = if (explainedDiagnosis == true) TendoWhite else TendoPink
                    ),
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(width = 1.dp, color = TendoPink),
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(text = "Yes")
                }
                Spacer(modifier = Modifier.width(12.dp))
                Button(
                    onClick = { viewModel.updateExplainedDiagnosis(false) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (explainedDiagnosis == false) TendoPink else Color.Transparent,
                        contentColor = if (explainedDiagnosis == false) TendoWhite else TendoPink
                    ),
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(width = 1.dp, color = TendoPink),
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(text = "No")
                }
            }
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