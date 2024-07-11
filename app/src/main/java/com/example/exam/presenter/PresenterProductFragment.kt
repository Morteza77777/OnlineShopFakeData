package com.example.exam.presenter

import com.example.exam.ext.BaseLifeCycle
import com.example.exam.model.ModelProductFragment
import com.example.exam.view.ViewProductFragment

class PresenterProductFragment(
    val view : ViewProductFragment,
    val model : ModelProductFragment
): BaseLifeCycle {

    override fun onCreate(){
        view.setData()
    }
}