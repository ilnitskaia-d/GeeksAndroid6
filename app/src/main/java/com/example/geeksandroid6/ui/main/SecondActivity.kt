package com.example.geeksandroid6.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.geeksandroid6.R
import com.example.geeksandroid6.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}