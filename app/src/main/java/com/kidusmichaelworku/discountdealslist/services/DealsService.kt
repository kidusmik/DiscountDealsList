package com.kidusmichaelworku.discountdealslist.services

import retrofit2.http.GET

interface DealsService {
//    @Headers(
//        "API_KEY: 37d14706b6770e999a509def5a8ea1af",
//        "incremental: 1",
//        "format: json")
    @GET("/getOffers/?API_KEY=37d14706b6770e999a509def5a8ea1af&format=json")
    suspend fun getOffers (): Response
}