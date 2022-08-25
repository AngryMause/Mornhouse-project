package com.example.mornhouseproject.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MyDao {
    @Query("SELECT * FROM ${NumbersFactBDEntity.TABLE_NAME}")
    suspend fun loadFact(): NumbersFactBDEntity?

    @Insert(entity = NumbersFactBDEntity::class)
    suspend fun addToDao(listEntity: NumbersFactBDEntity)
}