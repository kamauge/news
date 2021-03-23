package com.regera.news.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.regera.news.utils.Constants.Companion.KEY_COUNT_VALUE
import java.text.SimpleDateFormat
import java.util.*

class UploadWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {

        try {
            val count : Int = inputData.getInt(KEY_COUNT_VALUE,0)
            for (i : Int in 0 until count){
                Log.d("TAG","message${i}")
            }

            val time = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = time.format(Date())

            val outPutData = Data.Builder()
                    .putString(KEY_COUNT_VALUE,currentDate)
                    .build()
            return Result.success(outPutData)
        }
        catch (e:Exception){

            return Result.failure()
        }


    }
}