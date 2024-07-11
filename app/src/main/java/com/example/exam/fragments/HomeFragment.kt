package com.example.exam.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exam.ext.ActivityUtils
import com.example.exam.model.ModelHomeFragment
import com.example.exam.presenter.PresenterHomeFragment
import com.example.exam.view.ViewHomeFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
@AndroidEntryPoint
class HomeFragment  : Fragment() {

    @Inject lateinit var activityUtils4 : ActivityUtils

    lateinit var appContext : Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        appContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = ViewHomeFragment(appContext, activityUtils4)
        val presenter = PresenterHomeFragment(view, ModelHomeFragment())
        presenter.onCreate()
        return view.binding.root

    }

}