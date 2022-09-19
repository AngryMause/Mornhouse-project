package com.example.mornhouseproject.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FactDao {
    @Query("SELECT * FROM number_fact")
    fun loadFact(): Flow<List<NumbersFactBDEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addToDao(listEntity: NumbersFactBDEntity)

    @Query("DELETE FROM number_fact WHERE id=:id")
    suspend fun deleteFact(id: Long)
}