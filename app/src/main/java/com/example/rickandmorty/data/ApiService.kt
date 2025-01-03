package com.example.rickandmorty.data

import retrofit2.Response
import retrofit2.http.GET
import com.example.rickandmorty.data.models.CharacterResponse
import com.example.rickandmorty.data.models.EpisodeResponse
import com.example.rickandmorty.data.models.LocationResponse
import retrofit2.http.Query

interface ApiService {

    @GET("location")
    suspend fun getLocations(): Response<LocationResponse>

    @GET("character/{id}")
    suspend fun getCharacterById(@retrofit2.http.Path("id") id: Int): Response<CharacterResponse.Character>

    @GET("location/{id}")
    suspend fun getLocationById(@retrofit2.http.Path("id") id: Int): Response<LocationResponse.Location>

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): Response<CharacterResponse>

    @GET("episode")
    suspend fun getEpisodes(@Query("page") page: Int): Response<EpisodeResponse>
}