package com.example.exam.presenter

import com.example.exam.ext.BaseLifeCycle
import com.example.exam.model.ModelPasswordFragment
import com.example.exam.view.ViewPasswordFragment

class PresenterPasswordFragment(
    val view : ViewPasswordFragment,
    val model : ModelPasswordFragment
) :BaseLifeCycle{
    override fun onCreate() {
        view.viewHandler()
    }
}