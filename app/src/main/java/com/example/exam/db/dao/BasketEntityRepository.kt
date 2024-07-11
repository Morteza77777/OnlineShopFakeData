package com.example.exam.db.dao

import android.app.Application
import android.content.Context
import com.example.exam.db.OnlineShopDataBase
import com.example.exam.db.entity.BasketEntity


class BasketEntityRepository(context: Context) {

    private  var basketEntityDao : BasketDao

    init {
        val dataBase = OnlineShopDataBase.getInstance(context)
        basketEntityDao = dataBase.basketDao()
    }

    fun getBasketList():List<BasketEntity>{
        return basketEntityDao.getALl()
    }

    fun add(basket : BasketEntity){
        basketEntityDao.add(basket)
    }

    suspend fun exists(title: String): Boolean {
        return basketEntityDao.getItemByTitle(title) != null
    }

}