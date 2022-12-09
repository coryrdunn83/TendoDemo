package com.example.tendodemo.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tendodemo.ui.navigation.Screen
import com.example.tendodemo.ui.theme.TendoPink
import com.example.tendodemo.ui.theme.TendoWhite

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { navController.navigate(Screen.SurveyScreen.route) },
            colors = ButtonDefaults.buttonColors(
                containerColor = TendoPink,
                contentColor = TendoWhite
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Send Survey")
        }
    }
}