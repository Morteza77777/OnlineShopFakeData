package com.example.exam.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exam.ext.ActivityUtils
import com.example.exam.model.ModelPasswordFragment
import com.example.exam.model.ModelProductFragment
import com.example.exam.presenter.PresenterPasswordFragment
import com.example.exam.presenter.PresenterProductFragment
import com.example.exam.view.ViewPasswordFragment
import com.example.exam.view.ViewProductFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ProductFragment :
    Fragment() {
    lateinit var context5 : Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context5 = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = ViewProductFragment(context5)
        val presenter = PresenterProductFragment(view, ModelProductFragment())
        val arg = this.arguments
        val input = arg?.getString("title","test")
        val img = arg?.getInt("img")
        if (img != null) {
            view.binding.imgProduct.setImageResource(img)
        }
        view.binding.txtProduct.text = input
        presenter.onCreate()
        return view.binding.root
    }
}