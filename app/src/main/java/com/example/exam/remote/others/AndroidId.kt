package com.example.exam.remote.others

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings

object AndroidId {

    private var androidId : String? =null
    @SuppressLint("HardwareIds")
    fun deviceInfo(context: Context):String {
        if (androidId==null)
            androidId = Settings.Secure.getString(
                context.contentResolver,
                Settings.Secure.ANDROID_ID
            )

        return androidId?: ""

    }
}