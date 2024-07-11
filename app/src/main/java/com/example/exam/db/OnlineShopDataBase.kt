package com.example.exam.db

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.Entity
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.exam.db.dao.BasketDao
import com.example.exam.db.entity.BasketEntity

@Database(entities = [BasketEntity::class], version = 1)
abstract class OnlineShopDataBase : RoomDatabase() {

    abstract fun basketDao() : BasketDao

    companion object{
        private var instance : OnlineShopDataBase? = null
        fun getInstance(context: Context):OnlineShopDataBase{
            if (instance==null){
                instance = Room.databaseBuilder(
                    context,
                    OnlineShopDataBase::class.java,
                    "onlineshop.db"
                ).fallbackToDestructiveMigration().build()
            }
            return instance as OnlineShopDataBase

        }
    }



}