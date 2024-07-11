package com.example.exam.activites

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.exam.R
import com.example.exam.databinding.ActivityInformationBinding

class InformationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val color = ResourcesCompat.getColor(resources, R.color.orange, null)
        binding.buttonSend.setBackgroundColor(color)

        binding.txtNext.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        }
    }
