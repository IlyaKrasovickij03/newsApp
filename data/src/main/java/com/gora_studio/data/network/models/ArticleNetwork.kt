package com.gora_studio.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleNetwork(
    @SerialName("author") val author: String,
    @SerialName("content") val content: String,
    @SerialName("description") val description: String,
    @SerialName("publishedAt") val publishedAt: String,
    @SerialName("source") val source: SourceNetwork,
    @SerialName("title") val title: String,
    @SerialName("url") val url: String,
    @SerialName("urlToImage") val urlToImage: String
)