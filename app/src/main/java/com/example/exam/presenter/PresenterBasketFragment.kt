package com.example.exam.presenter

import android.content.Context
import com.example.exam.R
import com.example.exam.adapters.recylerModel.CategoryModel
import com.example.exam.db.dao.BasketEntityRepository
import com.example.exam.db.entity.BasketEntity
import com.example.exam.ext.BaseLifeCycle
import com.example.exam.model.ModelBasketFragment
import com.example.exam.view.ViewBasketFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PresenterBasketFragment(
    val view : ViewBasketFragment,
    val model : ModelBasketFragment,
    context: Context
):BaseLifeCycle {
    val repository = BasketEntityRepository(context)
    override fun onCreate() {
       CoroutineScope(Dispatchers.IO).launch {
           val data = repository.getBasketList()
           launch(Dispatchers.Main) {
               view.initRecycler(data)
           }
       }

    }



}