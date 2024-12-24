package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.models.Episode

interface EpisodesRepository {
    suspend fun getNextPageEpisodes(): List<Episode>
}