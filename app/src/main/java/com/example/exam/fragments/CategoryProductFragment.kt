package com.example.exam.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exam.ext.ActivityUtils
import com.example.exam.model.ModelCategoryProductFragment
import com.example.exam.presenter.PresenterCategoryProductFragment
import com.example.exam.view.ViewCategoryProductFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
@AndroidEntryPoint
class CategoryProductFragment : Fragment() {

    @Inject
    lateinit var activityUtils3 : ActivityUtils

    lateinit var context3 : Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        context3 = context
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = ViewCategoryProductFragment(context3,activityUtils3)
        val presenter = PresenterCategoryProductFragment(view, ModelCategoryProductFragment())
        presenter.onCreate()
        return view.binding.root
    }
}