package com.example.geeksandroid6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.geeksandroid6.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle:Bundle = intent.extras!!
        val model = bundle.getSerializable("model") as Character

        binding.apply {
            Glide
                .with(ivChar)
                .load(model.image)
                .centerCrop()
                .into(ivChar)

            tvName.text = model.name
        }
    }
}