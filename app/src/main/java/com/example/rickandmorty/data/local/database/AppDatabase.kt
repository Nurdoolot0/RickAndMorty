package com.example.rickandmorty.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickandmorty.data.local.dao.FavoriteCharacterDao
import com.example.rickandmorty.data.local.entities.FavoriteCharacter
import com.example.rickandmorty.data.local.database.DatabaseMigrations.MIGRATION_1_2  // Убедитесь, что импорт правильный


@Database(entities = [FavoriteCharacter::class], version = 3)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteCharacterDao(): FavoriteCharacterDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .addMigrations(MIGRATION_1_2)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}