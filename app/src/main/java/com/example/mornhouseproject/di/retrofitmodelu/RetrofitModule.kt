package com.example.mornhouseproject.di.retrofitmodelu

import com.example.mornhouseproject.network.MaineRepository
import com.example.mornhouseproject.network.NumberService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL = "http://numbersapi.com/"

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Provides
    fun providesBaseUrl(): String = BASE_URL

    @Provides
    @Singleton
    fun provideOKHTTPClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(BASE_URL: String, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideNumberService(retrofit: Retrofit): NumberService =
        retrofit.create(NumberService::class.java)

    @Provides
    @Singleton
    fun providesMaineRemoteData(numberService: NumberService): MaineRepository =
        MaineRepository(numberService)

}