package com.example.exam.ext

import android.content.Intent
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import de.hdodenhof.circleimageview.CircleImageView


interface  ActivityUtils{

    fun setFragment(fragment:Fragment){}

    fun setActionBar(toolbar: Toolbar){}

    fun setImage(circleImageView: CircleImageView){}

    fun setImage1(circleImageView: CircleImageView,imageButton: ImageButton){}

    fun starActivity (intent: Intent,requestCode : Int){}



}