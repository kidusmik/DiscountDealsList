package com.kidusmichaelworku.greendeals.services

/**
 * This class is used to store the response fetched from the API
 * The response has two keys
 * [result]: holds a boolean value
 * [offers]: holds all the offers information
 */
data class Response(
    val result: Boolean,
    val offers: List<Offers>
)