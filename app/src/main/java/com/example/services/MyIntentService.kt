package com.example.services

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {
    private val TAG = "MyIntentService"

    override fun onHandleIntent(p0: Intent?) {
        Log.i(TAG, "Handle intent")
        for (i in 1..3) {
            Log.i(TAG, "Service iteration $i!")
            Thread.sleep(5000)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "Service started!")

        return super.onStartCommand(intent, flags, startId)
    }
}