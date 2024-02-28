package com.gora_studio.data.network.storage.factory

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gora_studio.data.network.storage.dao.ArticleDao
import com.gora_studio.data.network.storage.entities.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1)
abstract class NewsAppDatabase: RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}

fun newsDatabase(applicationContext: Context): NewsAppDatabase {
    return Room.databaseBuilder(
        checkNotNull(applicationContext.applicationContext),
        NewsAppDatabase::class.java,
        "NEWS"
    ).build()
}