package com.example.exam.view

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.exam.R
import com.example.exam.customNav.ActiveFragment
import com.example.exam.customNav.FragmentType
import com.example.exam.databinding.ActivityMainBinding
import com.example.exam.ext.ActivityUtils
import com.example.exam.fragments.AboutUsFragment
import com.example.exam.fragments.BackUpFragment
import com.example.exam.fragments.BasketFragment
import com.example.exam.fragments.CategoryFragment
import com.example.exam.fragments.ContactFragment
import com.example.exam.fragments.HomeFragment
import com.example.exam.fragments.ProfileFragment
import com.example.exam.fragments.RulesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewMainActivity(contextInstance: Context, val activityUtils: ActivityUtils) :
    FrameLayout(contextInstance) {

    val binding = ActivityMainBinding.inflate(LayoutInflater.from(context))

    fun initBottomNav() {
        activityUtils.setFragment(HomeFragment())
        binding.bottomNav.onClickHelper(
            object : ActiveFragment {
                override fun setFragmentType(type: FragmentType) {
                    val fragment = when (type) {
                        FragmentType.HOME -> HomeFragment()
                        FragmentType.CATEGORY -> CategoryFragment()
                        FragmentType.BASKET -> BasketFragment()
                        FragmentType.PROFILE -> ProfileFragment()
                    }
                    activityUtils.setFragment(fragment)
                }


            }
        )
    }

    fun initNavDrawer() {
        binding.toolbar.title = ""
        activityUtils.setActionBar(binding.toolbar)

        val toggle = ActionBarDrawerToggle(
            context as Activity?,
            binding.drawerLayout,
            binding.toolbar,
            R.string.open,
            R.string.close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = false

        binding.imageButton2.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.END)

        }
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.profile_menu -> {
                    activityUtils.setFragment(ProfileFragment())
                    true
                }

                R.id.order_menu -> {

                    true
                }

                R.id.contact_menu -> {
                    activityUtils.setFragment(ContactFragment())
                    true
                }

                R.id.rules_menu -> {
                    activityUtils.setFragment(RulesFragment())
                    true
                }

                R.id.aboutUs_menu -> {
                    activityUtils.setFragment(AboutUsFragment())
                    true
                }

                R.id.backUp_menu -> {
                    activityUtils.setFragment(BackUpFragment())
                    true
                }

                else -> false
            }
        }
    }

    fun setImage() {
        activityUtils.setImage(binding.circleImageView)
    }
}


