package com.example.geeksandroid6.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geeksandroid6.databinding.ActivityMainBinding
import com.example.geeksandroid6.ui.adapter.PlaylistsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { PlaylistsAdapter(this::onClick) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
        }

        viewModel.getPlaylist().observe(this) {
            adapter.submitList(it)
        }
    }

    private fun onClick(playlistId: String, imageUrl: String){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("playlist", playlistId)
        intent.putExtra("url", imageUrl)
        startActivity(intent)
    }
}