package com.example.exam.presenter

import com.example.exam.R
import com.example.exam.adapters.recylerModel.CategoryModel
import com.example.exam.ext.BaseLifeCycle
import com.example.exam.model.ModelCategoryFragment
import com.example.exam.view.ViewCategoryFragment

class PresenterCategoryFragment(
    val view: ViewCategoryFragment,
    val model: ModelCategoryFragment
):BaseLifeCycle {
    override fun onCreate() {
        setDataRecycler()

    }

    private fun setDataRecycler() {
        val data = arrayListOf(
            CategoryModel(R.drawable.img_18, "زنانه"),
            CategoryModel(R.drawable.img_17, "مردانه"),
            CategoryModel(R.drawable.img_19, "پسرانه"),
            CategoryModel(R.drawable.img_20, "بچه گانه"),
            CategoryModel(R.drawable.img_22, "دخترانه"),
            CategoryModel(R.drawable.img_21, "کفش")
        )
        view.initRecycler(data)
    }
}