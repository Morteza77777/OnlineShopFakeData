package com.example.exam.presenter

import com.example.exam.R
import com.example.exam.adapters.recylerModel.CategoryModel
import com.example.exam.adapters.recylerModel.ProductModel
import com.example.exam.ext.BaseLifeCycle
import com.example.exam.model.ModelHomeFragment
import com.example.exam.view.ViewHomeFragment

class PresenterHomeFragment(
    private val view: ViewHomeFragment,
    private val model: ModelHomeFragment
) :BaseLifeCycle{

    override fun onCreate() {
        setDataInitRecycler()
        setDataProductRecycler()


    }

    private fun setDataInitRecycler() {
        val data = arrayListOf(
            CategoryModel(R.drawable.img_17, "مردانه"),
            CategoryModel(R.drawable.img_18, "زنانه"),
            CategoryModel(R.drawable.img_19, "بچه گانه"),
            CategoryModel(R.drawable.img_20, "نوزادی"),
            CategoryModel(R.drawable.img_21, "کفش"),
            CategoryModel(R.drawable.img_22, "دخترانه")
        )
        view.initRecycler(data)

    }

    private fun setDataProductRecycler(){
        val data = arrayListOf(
            ProductModel(R.drawable.img_19,"test","10000000 تومان"),
            ProductModel(R.drawable.img_20,"are","345345 تومان"),
            ProductModel(R.drawable.img_21,"na","666666 تومان"),
            ProductModel(R.drawable.img_19,"bad","7777777777 تومان"),
            ProductModel(R.drawable.img_21,"good","2424234 تومان"),
            ProductModel(R.drawable.img_17,"nice","2342342 تومان")
        )
        view.initRecyclerProduct(data)
    }

}