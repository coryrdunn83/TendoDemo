package com.example.tendodemo.ui.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.tendodemo.R
import com.example.tendodemo.common.Constants.SURVEY_CHANNEL
import com.example.tendodemo.common.Constants.SURVEY_NOTIF_CONTENT
import com.example.tendodemo.common.Constants.SURVEY_NOTIF_DESC_TEXT
import com.example.tendodemo.common.Constants.SURVEY_NOTIF_TITLE
import com.example.tendodemo.ui.MainActivity

class SurveyNotification(private val context: Context) {
    fun showNotification() {
        val intent = Intent(context, MainActivity::class.java)

        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(context, SURVEY_CHANNEL)
            .setSmallIcon(R.drawable.ic_baseline_star_border_24)
            .setContentTitle(SURVEY_NOTIF_TITLE)
            .setContentText(SURVEY_NOTIF_CONTENT)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(context)) {
            notify(1, builder.build())
        }
    }
}

fun createNotificationChannel(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = SURVEY_CHANNEL
        val descriptiveText = SURVEY_NOTIF_DESC_TEXT
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(name, name, importance).apply {
            description = descriptiveText
        }

        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}