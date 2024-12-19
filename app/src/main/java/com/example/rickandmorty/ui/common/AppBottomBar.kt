package com.example.rickandmorty.ui.common

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.LocationOn

@Composable
fun AppBottomBar(navController: NavController) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Characters") },
            label = { Text("Characters") },
            selected = navController.currentBackStackEntry?.destination?.route == "characters",
            onClick = {
                navController.navigate("characters") {
                    popUpTo("characters") { inclusive = true }
                    launchSingleTop = true
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.LocationOn, contentDescription = "Locations") },
            label = { Text("Locations") },
            selected = navController.currentBackStackEntry?.destination?.route == "locations",
            onClick = {
                navController.navigate("locations") {
                    popUpTo("locations") { inclusive = true }
                    launchSingleTop = true
                }
            }
        )
    }
}