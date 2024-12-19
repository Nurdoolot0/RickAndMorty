package com.example.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import com.example.rickandmorty.di.AppModule
import com.example.rickandmorty.ui.MainScreen
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            modules(AppModule.module)
        }

        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }
}