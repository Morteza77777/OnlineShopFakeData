package com.example.exam.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.exam.ext.ActivityUtils
import com.example.exam.model.ModelCategoryFragment
import com.example.exam.presenter.PresenterCategoryFragment
import com.example.exam.view.ViewCategoryFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
@AndroidEntryPoint
class CategoryFragment :Fragment() {

    @Inject
    lateinit var activityUtils1 : ActivityUtils

    lateinit var context1 : Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context1 = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = ViewCategoryFragment(context1,activityUtils1)
        val presenter = PresenterCategoryFragment(view, ModelCategoryFragment())
        presenter.onCreate()
        return view.binding.root
    }
}