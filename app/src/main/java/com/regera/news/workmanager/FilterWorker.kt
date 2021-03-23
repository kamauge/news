package com.regera.news.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.regera.news.utils.Constants
import java.text.SimpleDateFormat
import java.util.*

class FilterWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        try {

            for (i in 0 ..3000) {
                Log.i("TAG", "Filtering $i")
            }

            return Result.success()
        } catch (e:Exception){
            return Result.failure()
        }
    }
}