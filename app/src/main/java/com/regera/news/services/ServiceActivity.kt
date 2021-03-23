package com.regera.news.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.regera.news.R
import com.regera.news.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityServiceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}