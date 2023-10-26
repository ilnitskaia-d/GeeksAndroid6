package com.example.geeksandroid6

import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("characters")
    fun getCharacters(): Response<List<Character>>
}