package com.example.exam.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exam.model.ModelBasketFragment
import com.example.exam.presenter.PresenterBasketFragment
import com.example.exam.view.ViewBasketFragment

class BasketFragment :Fragment() {

    private lateinit var context1 : Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        context1 = context
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = ViewBasketFragment(context1)
        val presenter = PresenterBasketFragment(view, ModelBasketFragment(),context1)

        presenter.onCreate()
        return view.binding.root
    }

}