package com.example.exam.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.exam.databinding.ProductFragmentBinding

class ViewProductFragment(contextInstance: Context)
    : FrameLayout(contextInstance) {
    val binding = ProductFragmentBinding.inflate(LayoutInflater.from(context))

    fun setData(){


    }
}