package com.bestemorgul.coffeeapp.data.network

import com.bestemorgul.coffeeapp.data.model.CoffeeTypes
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.sampleapis.com/coffee/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CoffeeApiService {
    @GET("iced")
    suspend fun getIcedCoffee (): List<CoffeeTypes>

    @GET("hot")
    suspend fun getHotCoffee (): List<CoffeeTypes>

}

object CoffeeApi {

    val retrofitService : CoffeeApiService by lazy {
        retrofit.create(CoffeeApiService::class.java)
    }

}