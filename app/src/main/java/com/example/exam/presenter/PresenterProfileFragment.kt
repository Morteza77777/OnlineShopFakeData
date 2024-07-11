package com.example.exam.presenter

import com.example.exam.ext.BaseLifeCycle
import com.example.exam.model.ModelProfileFragment
import com.example.exam.view.ViewProfileFragment

class PresenterProfileFragment(
    val view: ViewProfileFragment,
    val model: ModelProfileFragment
) : BaseLifeCycle {

    override fun onCreate() {
        view.onClickHandler()

    }
}