package com.regera.news.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    private val TAG = "MyService"

    init {
        Log.d(TAG,"mimi running.....")
    }
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val dataString = intent?.getStringExtra("EXTRA")

        dataString?.let {
            Log.d(TAG,dataString)
        }
        return START_STICKY
    }
}