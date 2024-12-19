package com.example.rickandmorty.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.Repository
import com.example.rickandmorty.data.models.CharacterResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharactersViewModel(private val repository: Repository) : ViewModel() {

    private val _characters = MutableStateFlow<List<CharacterResponse.Character>>(emptyList())
    val characters: StateFlow<List<CharacterResponse.Character>> get() = _characters

    private var currentPage = 1

    init {
        fetchCharacters()
    }

    fun fetchNextPage() {
        currentPage++
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            val response = repository.getCharacters(currentPage)
            if (response.isSuccessful) {
                _characters.value += (response.body()?.results ?: emptyList())
            }
        }
    }
}