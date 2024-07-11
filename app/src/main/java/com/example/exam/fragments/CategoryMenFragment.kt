package com.example.exam.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exam.ext.ActivityUtils
import com.example.exam.model.ModelCategoryMenFragment
import com.example.exam.presenter.PresenterCategoryMenFragment
import com.example.exam.view.ViewCategoryMenFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
@AndroidEntryPoint
class CategoryMenFragment: Fragment() {

    @Inject
    lateinit var activityUtils2 : ActivityUtils

    lateinit var context2 : Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        context2 = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = ViewCategoryMenFragment(context2,activityUtils2)
        val presenter = PresenterCategoryMenFragment(view, ModelCategoryMenFragment())
        presenter.onCreate()
        return view.binding.root
    }
}