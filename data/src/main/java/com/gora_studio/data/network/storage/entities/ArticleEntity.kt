package com.gora_studio.data.network.storage.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gora_studio.data.network.models.SourceNetwork

@Entity(tableName = ArticleEntity.TABLE_NAME)
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo("author") val author: String,
    @ColumnInfo("content") val content: String,
    @ColumnInfo("description") val description: String,
    @ColumnInfo("publishedAt") val publishedAt: String,
    @Embedded("source.")  val source: SourceEntity,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("url") val url: String,
    @ColumnInfo("urlToImage") val urlToImage: String
){
    companion object {
        const val TABLE_NAME = "ARTICLES"
    }
}



