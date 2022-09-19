package com.example.mornhouseproject.di.roommodelu

import android.content.Context
import androidx.room.Room
import com.example.mornhouseproject.room.FACT_TABLE
import com.example.mornhouseproject.room.FactDao
import com.example.mornhouseproject.room.FactDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun providesFactDao(factDataBase: FactDataBase): FactDao = factDataBase.myDao()


    @Provides
    @Singleton
    fun providesFactDataBase(@ApplicationContext context: Context): FactDataBase {
        return Room.databaseBuilder(
            context, FactDataBase::class.java, FACT_TABLE
        ).build()
    }
}