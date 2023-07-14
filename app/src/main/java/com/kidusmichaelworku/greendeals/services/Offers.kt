package com.kidusmichaelworku.greendeals.services

/**
 * This is a data class that is used by Retrofit to map the fetched data to it.
 */
data class Offers(
    val lmd_id: Int,
    val store: String?,
    val merchant_homepage: String?,
    val long_offer: String?,
    val title: String?,
    val description: String?,
    val code: String?,
    val terms_and_conditions: String?,
    val categories: String?,
    val featured: String?,
    val publisher_exclusive: String?,
    val url: String?,
    val smartlink: String?,
    val image_url: String?,
    val type: String?,
    val offer: String?,
    val offer_value: String?,
    val status: String?,
    val start_date: String?,
    val end_date: String?
)