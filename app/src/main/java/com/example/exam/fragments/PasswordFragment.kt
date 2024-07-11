package com.example.exam.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exam.ext.ActivityUtils
import com.example.exam.model.ModelPasswordFragment
import com.example.exam.presenter.PresenterPasswordFragment
import com.example.exam.view.ViewPasswordFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PasswordFragment : Fragment() {

    lateinit var context4 : Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context4 = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view  = ViewPasswordFragment(context4)
        val presenter = PresenterPasswordFragment(view, ModelPasswordFragment())
        presenter.onCreate()
        return view.binding.root
    }
}