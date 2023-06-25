package com.kidusmichaelworku.discountdealslist.services

import retrofit2.http.GET
import retrofit2.http.Headers

interface DealsService {
    @Headers("API_KEY=37d14706b6770e999a509def5a8ea1af")
    @GET ("getOffers")
    suspend fun getDeals (): List<Deals>
}