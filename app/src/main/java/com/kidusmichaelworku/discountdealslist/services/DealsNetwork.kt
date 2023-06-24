package com.kidusmichaelworku.discountdealslist.services

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DealsNetwork {
    fun getRetrofitClient (): Retrofit {
        val gson = GsonBuilder ().setLenient ().create ()
        return Retrofit.Builder ()
            .baseUrl ("https://feed.linkmydeals.com/")
            .addConverterFactory (GsonConverterFactory.create (gson))
            .build ()
    }
}