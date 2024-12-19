package com.example.rickandmorty.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmorty.ui.characters.CharacterDetailScreen
import com.example.rickandmorty.ui.characters.CharactersScreen
import com.example.rickandmorty.ui.common.AppBottomBar
import com.example.rickandmorty.ui.common.AppTopBar
import com.example.rickandmorty.ui.locations.LocationDetailScreen
import com.example.rickandmorty.ui.locations.LocationsScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { AppTopBar(navController) },
        bottomBar = { AppBottomBar(navController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(navController = navController, startDestination = "characters") {
                composable("characters") { CharactersScreen(navController) }
                composable("locations") { LocationsScreen(navController) }
                composable("character_detail/{characterId}") { backStackEntry ->
                    val characterId =
                        backStackEntry.arguments?.getString("characterId")?.toIntOrNull()
                    if (characterId != null) {
                        CharacterDetailScreen(characterId)
                    }
                }
                composable("location_detail/{locationId}") { backStackEntry ->
                    val locationId =
                        backStackEntry.arguments?.getString("locationId")?.toIntOrNull()
                    if (locationId != null) {
                        LocationDetailScreen(locationId)
                    }
                }
            }
        }
    }
}