package com.example.rickandmorty.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.rickandmorty.data.ApiService
import com.example.rickandmorty.data.Repository
import com.example.rickandmorty.ui.characters.CharacterDetailViewModel
import com.example.rickandmorty.ui.characters.CharactersViewModel
import com.example.rickandmorty.ui.locations.LocationDetailViewModel
import com.example.rickandmorty.ui.locations.LocationsViewModel

object AppModule {
    val module = module {
        single {
            Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
        single { Repository(get()) }
        viewModel { CharactersViewModel(get()) }
        viewModel { LocationsViewModel(get()) }
        viewModel { CharacterDetailViewModel(get()) }
        viewModel { LocationDetailViewModel(get()) }
    }
}