package com.example.customnotification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build


class App : Application() {
    val CHANNEL_ID = "exampleChannel"

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Example Channel",
                NotificationManager.IMPORTANCE_HIGH
            )
            val manager = getSystemService(
                NotificationManager::class.java
            )
            manager.createNotificationChannel(channel)
        }
    }

}