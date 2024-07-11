package com.example.exam.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.exam.db.entity.BasketEntity
@Dao
interface BasketDao {

    @Insert
    fun add(basketEntity: BasketEntity)
    @Update
    fun update(basketEntity: BasketEntity)

    @Delete
    fun delete(basketEntity: BasketEntity)

    @Query("select * from BasketEntity")
    fun getALl(): List<BasketEntity>


    @Query("SELECT * FROM BasketEntity WHERE name = :title LIMIT 1")
    suspend fun getItemByTitle(title: String): BasketEntity?
}