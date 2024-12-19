package com.example.rickandmorty.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rickandmorty.data.models.CharacterResponse
import coil.compose.AsyncImage

@Composable
fun CharacterCard(character: CharacterResponse.Character, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier
                    .size(84.dp)
                    .padding(end = 16.dp)
            )
            Column {
                Text(text = character.name, style = MaterialTheme.typography.bodyLarge)
                Text(
                    text = "${character.species} - ${character.status}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}