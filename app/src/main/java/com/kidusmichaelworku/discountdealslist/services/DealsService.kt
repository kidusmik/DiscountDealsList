package com.kidusmichaelworku.discountdealslist.services

import retrofit2.http.GET

interface DealsService {
    @GET("posts/1")
    suspend fun getPost (): User

    @GET ("posts")
    suspend fun getPosts (): List<User>
}