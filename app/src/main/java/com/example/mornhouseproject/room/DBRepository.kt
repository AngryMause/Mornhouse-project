package com.example.mornhouseproject.room

import com.example.mornhouseproject.model.NumberFactModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class DBRepository @Inject constructor(
    private val factDao: FactDao,
) {
    fun listFact(): Flow<List<NumberFactModel>> {
        return factDao.loadFact()
            .map { list ->
                list.map {
                    it.toNumberFactModel()
                }
            }
    }

    fun factFromDao(id: Long): Flow<NumberFactModel> {
        return factDao.getById(id)
            .map { factDBEntity ->
                factDBEntity.toNumberFactModel()
            }
    }

    suspend fun deleteFromDao(id: Long) {
        factDao.deleteFact(id)
    }


    suspend fun addFact(numbersFactBDEntity: NumbersFactBDEntity) {
        factDao.addToDao(numbersFactBDEntity)
    }


}