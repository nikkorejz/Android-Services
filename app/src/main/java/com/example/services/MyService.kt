package com.example.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private val TAG = "MyService";

    override fun onCreate() {
        Log.i(TAG, "Service created!")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "Service started!")
        for (i in 1..3) {
            Log.i(TAG, "Service iteration $i!")
            Thread.sleep(5000)
        }
        return START_STICKY
    }

    override fun onDestroy() {
        Log.i(TAG, "Service destroyed!")
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}