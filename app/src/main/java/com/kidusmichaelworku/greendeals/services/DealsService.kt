package com.kidusmichaelworku.greendeals.services

import retrofit2.http.GET

/** This is LinkMyDeals API key, change this with your own API Key **/
const val API_KEY = "c174b7f5abadf7e1ab08123212fa26ad"
/** This is the format of the data that is returned from LinkMyDeals API **/
const val FORMAT = "json"

/**
 * Sends a GET request to LinkMyDeal API
 * Returns a [Response] data class
 */
interface DealsService {
    @GET("/getOffers/?API_KEY=$API_KEY&format=$FORMAT")
    suspend fun getOffers(): Response
}