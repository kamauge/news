package com.regera.news.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.work.*
import com.regera.news.R
import com.regera.news.databinding.ActivityWorkBinding
import com.regera.news.utils.Constants.Companion.KEY_COUNT_VALUE
import com.regera.news.utils.Constants.Companion.KEY_WORKER
import java.util.concurrent.TimeUnit

class WorkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWorkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

       // val request = OneTimeWorkRequestBuilder<MyWork>().build()

        binding.workManagerBtn.setOnClickListener {

          //  oneTimeRequest()
            setPeriodWorkRequest()

            //WorkManager.getInstance(this).enqueue(request)
        }

//        WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.id)
//            .observe(this, Observer {
//
//                val status: String = it.state.name
//                Toast.makeText(this,status, Toast.LENGTH_SHORT).show()
//            })
    }



    private fun oneTimeRequest(){
        val workManager = WorkManager.getInstance(applicationContext)

        val data : Data = Data.Builder()
                .putInt(KEY_COUNT_VALUE,125)
                .build()

        val constraints = Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()
        val uploadRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
                .setConstraints(constraints)
                .setInputData(data)
                .build()

        val filteringRequest = OneTimeWorkRequest.Builder(FilterWorker::class.java)
                .build()

        val compressingRequest = OneTimeWorkRequest.Builder(CompressWorker::class.java)
                .build()


        val downloadingWorker= OneTimeWorkRequest.Builder(DownloadingWorker::class.java)
                .build()
        val parallelWorks = mutableListOf<OneTimeWorkRequest>()
        parallelWorks.add(downloadingWorker)
        parallelWorks.add(filteringRequest)
        workManager
                .beginWith(parallelWorks)
                .then(compressingRequest)
                .then(uploadRequest)
                .enqueue()

        workManager.getWorkInfoByIdLiveData(uploadRequest.id)
                .observe(this, Observer {
                    val status: String = it.state.name
                    if (it.state.isFinished){
                        val data = it.outputData
                        val message: String? = data.getString(KEY_WORKER)
                        Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()

                    }

                    binding.workManagerTv.text = status
                })
    }

    private fun setPeriodWorkRequest(){
        val periodicWorkRequest = PeriodicWorkRequest.Builder(DownloadingWorker::class.java,16,TimeUnit.MINUTES)
                .build()

        WorkManager.getInstance(applicationContext).enqueue(periodicWorkRequest)
    }
}