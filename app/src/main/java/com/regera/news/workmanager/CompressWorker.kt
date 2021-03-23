package com.regera.news.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.regera.news.utils.Constants
import java.text.SimpleDateFormat
import java.util.*

class CompressWorker (context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        try {

            for (i in 0 ..300) {
                Log.i("TAG", "Compressing $i")
            }

            return Result.success()
        } catch (e:Exception){
            return Result.failure()
        }
    }
}