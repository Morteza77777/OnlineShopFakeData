package com.example.exam.presenter

import com.example.exam.ext.BaseLifeCycle
import com.example.exam.model.ModelMainActivity
import com.example.exam.view.ViewMainActivity

class PresenterMainActivity(
    private val view: ViewMainActivity,
    private val model: ModelMainActivity,
) : BaseLifeCycle {

    override fun onCreate() {
        view.initNavDrawer()
        view.initBottomNav()
        view.setImage()
    }

}

