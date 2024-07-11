package com.example.exam.ext

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.exam.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class ActivityUtilsImpl @Inject constructor():ActivityUtils {
    @Inject
    lateinit var appCompatActivity : AppCompatActivity
    override fun setFragment(fragment: Fragment) {
        appCompatActivity.supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout,fragment)
            .commit()
    }
}