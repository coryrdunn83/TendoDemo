package com.example.tendodemo.ui.home

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tendodemo.R
import com.example.tendodemo.ui.navigation.Screen
import com.example.tendodemo.ui.notification.SurveyNotification
import com.example.tendodemo.ui.notification.createNotificationChannel
import com.example.tendodemo.ui.theme.TendoPink
import com.example.tendodemo.ui.theme.TendoWhite

@Composable
fun HomeScreen(
    navController: NavController
) {
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) {
        isGranted: Boolean ->
        if (isGranted) {
            SurveyNotification(context).showNotification()
        }
    }

    LaunchedEffect(Unit) {
        createNotificationChannel(context)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .testTag("Home Screen"),
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
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.testTag("Take survey button")
            ) {
                Text(text = stringResource(id = R.string.home_take_survey_btn_text))
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
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