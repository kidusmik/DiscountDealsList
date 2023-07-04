package com.kidusmichaelworku.greendeals.services

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Builds the Retrofit Client and returns a [Retrofit.Builder]
 */
object DealsNetwork {
    fun getRetrofitClient(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("https://feed.linkmydeals.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}