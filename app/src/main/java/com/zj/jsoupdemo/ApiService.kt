package com.zj.jsoupdemo

import retrofit2.Retrofit
import retrofit2.http.GET

interface ApiService {

    @GET("/")
    suspend fun homePage(): HomePage
}

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("http://www.yinghuacd.com/")
    .addConverterFactory(FruitConverterFactory.create())
    .build()

val apiService: ApiService = retrofit.create(ApiService::class.java)