package com.gora_studio.data.network.storage.entities

import androidx.room.ColumnInfo

data class SourceEntity(
    @ColumnInfo("id") val id: String,
    @ColumnInfo("name") val name: String
)
