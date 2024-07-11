package com.example.exam.customNav

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.exam.R
import com.example.exam.databinding.CustomButtomNavBinding

class CustomBottomNav(
    context: Context,
    attr : AttributeSet
):FrameLayout(context,attr) {

    private val binding = CustomButtomNavBinding.inflate(LayoutInflater.from(context))

    init {
        addView(binding.root)
    }

    fun onClickHelper(activeItem: ActiveFragment){

        binding.viewHome.setOnClickListener {
            activeItem.setFragmentType(FragmentType.HOME)
            homeClick()

        }

        binding.viewCategory.setOnClickListener {
            activeItem.setFragmentType(FragmentType.CATEGORY)
            cateGoryClick()
        }

        binding.viewBasket.setOnClickListener {
            activeItem.setFragmentType(FragmentType.BASKET)
            basketClick()

        }

        binding.viewProfile.setOnClickListener {
            activeItem.setFragmentType(FragmentType.PROFILE)
            profileClick()

        }

    }


    private fun setTextColor(view: TextView, color: Int) {
        view.setTextColor(ContextCompat.getColor(context, color))
    }


    private fun homeClick(){
        setTextColor(binding.txtHome,R.color.orange)
        setTextColor(binding.txtCateGory,R.color.black)
        setTextColor(binding.txtBasket,R.color.black)
        setTextColor(binding.txtProfile,R.color.black)
    }
    private fun cateGoryClick(){
        setTextColor(binding.txtHome,R.color.black)
        setTextColor(binding.txtCateGory,R.color.orange)
        setTextColor(binding.txtBasket,R.color.black)
        setTextColor(binding.txtProfile,R.color.black)
    }
    private fun basketClick(){
        setTextColor(binding.txtHome,R.color.black)
        setTextColor(binding.txtCateGory,R.color.black)
        setTextColor(binding.txtBasket,R.color.orange)
        setTextColor(binding.txtProfile,R.color.black)
    }
    private fun profileClick(){
        setTextColor(binding.txtHome,R.color.black)
        setTextColor(binding.txtCateGory,R.color.black)
        setTextColor(binding.txtBasket,R.color.black)
        setTextColor(binding.txtProfile,R.color.orange)
    }

}
