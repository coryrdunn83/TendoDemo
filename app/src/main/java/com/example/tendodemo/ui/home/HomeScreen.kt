package com.example.tendodemo.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tendodemo.R
import com.example.tendodemo.ui.navigation.Screen
import com.example.tendodemo.ui.notification.SurveyNotification
import com.example.tendodemo.ui.notification.createNotificationChannel
import com.example.tendodemo.ui.theme.TendoPink
import com.example.tendodemo.ui.theme.TendoWhite

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navController: NavController
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        createNotificationChannel(context)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    navController.navigate(Screen.SurveyScreen.route)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = TendoPink,
                    contentColor = TendoWhite
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = stringResource(id = R.string.home_take_survey_btn_text))
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    SurveyNotification(context).showNotification()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = TendoPink,
                    contentColor = TendoWhite
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = stringResource(id = R.string.home_send_notif_btn_text))
            }
        }
    }
}