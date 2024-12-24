package com.example.rickandmorty.di

import com.example.rickandmorty.ui.favorites.FavoriteCharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.rickandmorty.data.ApiService
import com.example.rickandmorty.data.Repository
import com.example.rickandmorty.data.local.database.AppDatabase
import com.example.rickandmorty.data.repository.EpisodesRepository
import com.example.rickandmorty.data.repository.EpisodesRepositoryImpl
import com.example.rickandmorty.data.repository.FavoriteCharacterRepository
import com.example.rickandmorty.ui.characters.CharacterDetailViewModel
import com.example.rickandmorty.ui.characters.CharactersViewModel
import com.example.rickandmorty.ui.locations.LocationDetailViewModel
import com.example.rickandmorty.ui.locations.LocationsViewModel
import com.example.rickandmorty.ui.episodes.EpisodesViewModel
import org.koin.android.ext.koin.androidContext

object AppModule {
    val module = module {
        single {
            Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }

        single { AppDatabase.getDatabase(androidContext()) }
        single { get<AppDatabase>().favoriteCharacterDao() }
        single { FavoriteCharacterRepository(get()) }
        single<EpisodesRepository> { EpisodesRepositoryImpl(get()) }
        single { Repository(get()) }

        viewModel { FavoriteCharacterViewModel(get()) }
        viewModel { CharactersViewModel(get(), get()) }
        viewModel { LocationsViewModel(get()) }
        viewModel { CharacterDetailViewModel(get()) }
        viewModel { LocationDetailViewModel(get()) }
        viewModel { EpisodesViewModel(get()) }
    }
}