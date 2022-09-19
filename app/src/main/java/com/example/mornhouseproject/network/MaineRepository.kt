package com.example.mornhouseproject.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MaineRepository @Inject constructor(private val remoteData: NumberService) {
    suspend fun getNumberFact(int: Int) = remoteData.getNumberFact(int)
    suspend fun getRandomFact() = remoteData.getRandomFact()
}
