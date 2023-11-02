package com.example.geeksandroid6.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.geeksandroid6.databinding.ActivityMainBinding
import com.example.geeksandroid6.ui.adapter.PlaylistsAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { PlaylistsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getPlaylist()

        binding.rv.adapter = adapter


        viewModel.playlists.observe(this) {
            adapter.submitList(it)
        }

    }
}