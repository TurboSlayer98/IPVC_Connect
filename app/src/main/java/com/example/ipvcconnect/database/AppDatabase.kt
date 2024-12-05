package com.example.ipvcconnect.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ipvcconnect.models.Comment
import com.example.ipvcconnect.dataaccessobjects.CommentsDao

@Database(entities = [Comment::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun CommentsDao(): CommentsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "comments_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
} 