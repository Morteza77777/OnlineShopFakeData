package com.example.exam.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.activity.result.contract.ActivityResultContracts
import com.example.exam.databinding.ProfileFragmentBinding
import com.example.exam.ext.ActivityUtils
import com.example.exam.fragments.PasswordFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class ViewProfileFragment(contextInstance: Context) :
    FrameLayout(contextInstance) {
    @Inject
    lateinit var activityUtils: ActivityUtils
    val binding = ProfileFragmentBinding.inflate(LayoutInflater.from(context))

    fun onClickHandler() {
        binding.viewPassword.setOnClickListener {
            activityUtils.setFragment(PasswordFragment())
        }


    }


}