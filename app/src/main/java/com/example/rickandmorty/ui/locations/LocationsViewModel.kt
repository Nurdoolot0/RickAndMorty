package com.example.rickandmorty.ui.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.Repository
import com.example.rickandmorty.data.models.LocationResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocationsViewModel(private val repository: Repository) : ViewModel() {

    private val _locations = MutableStateFlow<List<LocationResponse.Location>>(emptyList())
    val locations: StateFlow<List<LocationResponse.Location>> get() = _locations

    init {
        fetchLocations()
    }

    private fun fetchLocations() {
        viewModelScope.launch {
            val response = repository.getLocations()
            if (response.isSuccessful) {
                _locations.value = response.body()?.results ?: emptyList()
            }
        }
    }
}