package com.example.geeksandroid6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.geeksandroid6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {ViewModelProvider(this)[MainViewModel::class.java]}
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getCharacters()

        viewModel.charactersData.observe(this) {
            val adapter = viewModel.getAdapter(this::onClick)
            binding.rv.adapter = adapter
        }
    }

    private fun onClick(model: Character) {
        intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("model", model)
        startActivity(intent)
    }
}