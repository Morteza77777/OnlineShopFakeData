package com.example.exam.presenter

import com.example.exam.R
import com.example.exam.adapters.recylerModel.ProductModel
import com.example.exam.ext.BaseLifeCycle
import com.example.exam.model.ModelCategoryProductFragment
import com.example.exam.view.ViewCategoryProductFragment

class PresenterCategoryProductFragment(
    val view: ViewCategoryProductFragment,
    val model : ModelCategoryProductFragment
):BaseLifeCycle{
    override fun onCreate(){
        setDataInitRecycler()
        view.setMenFragment()

    }

    private fun setDataInitRecycler(){
        val data = arrayListOf(
            ProductModel(R.drawable.img_19,"test","2141424 تومان"),
            ProductModel(R.drawable.img_20,"test","247424 تومان"),
            ProductModel(R.drawable.img_21,"test","4141424 تومان"),
            ProductModel(R.drawable.img_22,"test","4574524 تومان"),
            ProductModel(R.drawable.img_23,"test","1111141424 تومان"),
            ProductModel(R.drawable.img_24,"test","45745424 تومان"),
            ProductModel(R.drawable.img_25,"test","0000004 تومان"),
            ProductModel(R.drawable.img_26,"test","7345345 تومان")
        )
        view.initRecycler(data)
    }

}