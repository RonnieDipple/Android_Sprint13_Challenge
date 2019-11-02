package com.example.simple_sprint13_challenge.di

import com.example.simple_sprint13_challenge.Model.MakeUpService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object AppModule {

    private const val BASE_URL = "http://makeup-api.herokuapp.com/api/v1/"

    @Singleton
    @Provides
    @JvmStatic
    fun retrofitInstance() =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    @JvmStatic
    fun provideMakeUpService(retrofit: Retrofit) =
        retrofit.create(MakeUpService::class.java)
}