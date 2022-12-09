package com.example.tendodemo.ui.survey.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tendodemo.ui.survey.SurveyScreenViewModel
import com.example.tendodemo.ui.theme.TendoPink
import com.example.tendodemo.ui.theme.TendoWhite

@Composable
fun ReviewPage(
    viewModel: SurveyScreenViewModel,
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Thanks again! Here's what we heard:")
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