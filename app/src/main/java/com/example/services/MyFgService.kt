package com.example.services

import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class MyFgService : Service() {

    private val TAG = "ForegroundService"

    override fun onCreate() {
        Log.i(TAG, "Service created!")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "onStartCommand")
        // Выполняем задачи сервиса
        val input = intent?.extras?.getString("TITLE")


        val notificationIntent = Intent(applicationContext, MainActivity::class.java)
        val pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            PendingIntent.getActivity(
                applicationContext, 0, notificationIntent, PendingIntent.FLAG_MUTABLE)
        } else {
            PendingIntent.getActivity(
                applicationContext, 0, notificationIntent, 0)
        }

        val notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setContentTitle(input)
            .setSmallIcon(android.R.drawable.btn_minus)
            .setContentText("Sample Text")
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()
        startForeground(101, notification)
//        with (applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager) {
//            this.notify(1011, notification)
//        }
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        Log.i(TAG, "Service destroyed!")
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}