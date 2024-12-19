package com.example.rickandmorty.ui.characters

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rickandmorty.ui.common.CharacterCard
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharactersScreen(navController: NavController) {

    val viewModel: CharactersViewModel = koinViewModel()
    val characters = viewModel.characters.collectAsState()
    val isLoading = characters.value.isEmpty()

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(characters.value) { character ->
            CharacterCard(character) {
                navController.navigate("character_detail/${character.id}")
            }
        }

        if (!isLoading) {
            item {
                Button(
                    onClick = { viewModel.fetchNextPage() },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(text = "Load More")
                }
            }
        }

        if (isLoading) {
            item {
                CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
            }
        }
    }

    LaunchedEffect(key1 = characters.value.size) {
        if (characters.value.size >= 20) {
            viewModel.fetchNextPage()
        }
    }
}