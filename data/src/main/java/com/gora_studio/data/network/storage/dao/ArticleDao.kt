package com.gora_studio.data.network.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gora_studio.data.network.storage.entities.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Insert
    suspend fun insert(articles: List<ArticleEntity>)

    @Query("SELECT * FROM ${ArticleEntity.TABLE_NAME}")
    fun getAllNews(): Flow<List<ArticleEntity>>

    @Query("DELETE FROM ${ArticleEntity.TABLE_NAME}")
    suspend fun clear()
}