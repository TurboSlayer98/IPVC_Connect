package com.example.ipvcconnect.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ipvcconnect.models.Comment
import com.example.ipvcconnect.dataaccessobjects.CommentsDao
import com.example.ipvcconnect.dataaccessobjects.FavouritesDao
import com.example.ipvcconnect.models.Favourite

@Database(entities = [Comment::class, Favourite::class], version = 2, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun CommentsDao(): CommentsDao
    abstract fun FavouritesDao(): FavouritesDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "ipvconnectDB"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
} 