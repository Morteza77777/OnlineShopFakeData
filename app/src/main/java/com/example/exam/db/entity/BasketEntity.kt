package com.example.exam.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BasketEntity (
    @PrimaryKey val image : Int,
    val name : String,
    val price : String
)