package com.example.exam.presenter

import com.example.exam.R
import com.example.exam.adapters.recylerModel.ProductModel
import com.example.exam.ext.BaseLifeCycle
import com.example.exam.model.ModelCategoryMenFragment
import com.example.exam.view.ViewCategoryMenFragment

class PresenterCategoryMenFragment(
    private val view: ViewCategoryMenFragment,
    private val model: ModelCategoryMenFragment
):BaseLifeCycle {
    override fun onCreate() {
        setDataInitRecycler()
    }

    private fun setDataInitRecycler() {
        val data = arrayListOf(
            ProductModel(R.drawable.img_19, "test", "1231243 تومان"),
            ProductModel(R.drawable.img_20, "test2", "1235643 تومان"),
            ProductModel(R.drawable.img_22, "test3", "6643 تومان"),
            ProductModel(R.drawable.img_21, "test4", "7231243 تومان"),
            ProductModel(R.drawable.img_35, "test5", "8231243 تومان"),
            ProductModel(R.drawable.img_25, "test6", "9931243 تومان"),
            ProductModel(R.drawable.img_34, "test7", "19231243 تومان"),
            ProductModel(R.drawable.img_31, "test8", "957243 تومان"),
            ProductModel(R.drawable.img_38, "test9", "991231243 تومان"),
            ProductModel(R.drawable.img_23, "test10", "23243 تومان"),
            ProductModel(R.drawable.img_24, "test11", "4531243 تومان"),
            ProductModel(R.drawable.img_26, "test12", "86243 تومان"),
            ProductModel(R.drawable.img_27, "test13", "8631243 تومان"),
            ProductModel(R.drawable.img_28, "test14", "1231243 تومان"),
            ProductModel(R.drawable.img_39, "test15", "1231243 تومان"),
            ProductModel(R.drawable.img_10, "test16", "1231243 تومان")
        )
        view.initRecycler(data)

    }
}