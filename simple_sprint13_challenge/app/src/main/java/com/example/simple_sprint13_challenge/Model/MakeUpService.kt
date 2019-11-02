package com.example.simple_sprint13_challenge.Model

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MakeUpService {

    @GET("products.json")
    fun getList(@Query("brand") brand: String): Observable<List<MakeUpData>>
}