package com.example.exam.module

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.exam.R
import com.example.exam.activites.MainActivity
import com.example.exam.ext.ActivityUtils
import com.example.exam.ext.ActivityUtilsImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityComponent::class)
class Module{

    @Provides
    fun provideFragmentManager(@ActivityContext context: Context): FragmentManager {
        return (context as AppCompatActivity).supportFragmentManager
    }

    @Provides
    fun provideActionBar(@ActivityContext context: Context) : AppCompatActivity {
        return (context as AppCompatActivity)
    }

    @Provides
    fun provideActivityUtils(fragmentManager: FragmentManager,appCompatActivity: AppCompatActivity): ActivityUtils {
        return object :ActivityUtils{
            override fun setFragment(fragment: Fragment) {
                fragmentManager.beginTransaction()
                    .replace(R.id.frame_layout,fragment)
                    .commit()

            }

            override fun setActionBar(toolbar: Toolbar) {
                appCompatActivity.setSupportActionBar(toolbar)
            }
        }
    }


    }
