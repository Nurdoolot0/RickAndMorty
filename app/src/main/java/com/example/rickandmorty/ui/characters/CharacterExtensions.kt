package com.example.rickandmorty.ui.characters

import com.example.rickandmorty.data.local.entities.FavoriteCharacter
import com.example.rickandmorty.data.models.CharacterResponse

fun CharacterResponse.Character.toFavoriteCharacter(): FavoriteCharacter {
    return FavoriteCharacter(
        id = this.id,
        name = this.name,
        species = this.species,
        image = this.image,
        status = this.status,
        isFavorite = 1
    )
}

fun FavoriteCharacter.toCharacterResponse(): CharacterResponse.Character {
    return CharacterResponse.Character(
        id = this.id,
        name = this.name,
        species = this.species,
        status = this.status,
        image = this.image
    )
}