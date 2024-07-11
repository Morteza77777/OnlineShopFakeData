package com.example.exam.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.res.ResourcesCompat
import com.example.exam.R
import com.example.exam.databinding.PasswordFragmentBinding

class ViewPasswordFragment(contextInstance :Context):FrameLayout(contextInstance) {
    val binding = PasswordFragmentBinding.inflate(LayoutInflater.from(context))

    @SuppressLint("SetTextI18n")
    fun viewHandler(){
        binding.textView.text = "در انتخاب رمز عبور موارد زیر را در نظر بگیرید:\n" +
                "رمز عبور باید خداقل 8 کارکتر باشد\n" +
                "شامل حروف و عدد باشد\n" +
                "شامل علامت باشد(!@#\$%)\n" +
                "از حروف بزرگ و کوچک استفاده شود."
        val color = ResourcesCompat.getColor(resources,R.color.orange,null)
        binding.button2.setBackgroundColor(color)
    }
}