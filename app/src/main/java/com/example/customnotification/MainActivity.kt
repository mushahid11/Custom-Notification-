package com.example.customnotification

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.customnotification.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val CHANNEL_ID = "exampleChannel"
    private lateinit var binding: ActivityMainBinding
    private var notificationManager: NotificationManagerCompat? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        notificationManager = NotificationManagerCompat.from(this);


        binding.showButton.setOnClickListener {
            showNotification()
        }

    }

    private fun showNotification() {
        val collapsedView = RemoteViews(
            packageName,
            R.layout.notification_collapsed
        )
        val expandedView = RemoteViews(
            packageName,
            R.layout.notification_expanded
        )

        val clickIntent = Intent(this, NotificationReceiver::class.java)
        val clickPendingIntent = PendingIntent.getBroadcast(
            this,
            0, clickIntent, 0
        )

        collapsedView.setTextViewText(R.id.text_view_collapsed_1, "Hello World!")

        expandedView.setImageViewResource(R.id.image_view_expanded, R.drawable.ic_launcher_background)
        expandedView.setOnClickPendingIntent(R.id.image_view_expanded, clickPendingIntent)

        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setCustomContentView(collapsedView)
            .setCustomBigContentView(expandedView) //.setStyle(new NotificationCompat.DecoratedCustomViewStyle())
            .build()

        notificationManager?.notify(1, notification)
    }
}