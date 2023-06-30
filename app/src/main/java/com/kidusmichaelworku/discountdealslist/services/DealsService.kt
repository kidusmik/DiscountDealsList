package com.kidusmichaelworku.discountdealslist.services

import retrofit2.http.GET

/** This is LinkMyDeals API key, change this with your own API Key **/
const val API_KEY = "c174b7f5abadf7e1ab08123212fa26ad"

/**
 * Sends a GET request to LinkMyDeal API
 * Returns a [Response] object
 */
interface DealsService {
    @GET("/getOffers/?API_KEY=$API_KEY&format=json")
    suspend fun getOffers(): Response
}