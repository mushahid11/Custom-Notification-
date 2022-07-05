package com.example.customnotification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat


class NotificationReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Toast.makeText(p0, "Image clicked", Toast.LENGTH_SHORT).show()

        val notificationManager = NotificationManagerCompat.from(p0!!.applicationContext)
        notificationManager.cancel(1)
    }

}