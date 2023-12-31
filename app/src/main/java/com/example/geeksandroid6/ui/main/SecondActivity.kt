package com.example.geeksandroid6.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.geeksandroid6.databinding.ActivitySecondBinding
import com.example.geeksandroid6.ui.adapter.VideosAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondActivity : AppCompatActivity() {
    private val viewModel: SecondViewModel by viewModel()
    private lateinit var binding: ActivitySecondBinding
    private val adapter by lazy { VideosAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val playlistId = intent.getStringExtra("playlist").toString()
        val imageUrl = intent.getStringExtra("url").toString()

        Glide.with(this)
            .load(imageUrl)
            .into(binding.ivCollapsing)

        binding.rv.apply {
            adapter = this@SecondActivity.adapter
            layoutManager = LinearLayoutManager(
                this@SecondActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
        }

        viewModel.getVideos(playlistId).observe(this) {
            adapter.submitList(it)
        }
    }
}