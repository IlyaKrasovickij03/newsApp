package com.gora_studio.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response<R>(
    @SerialName("articles") val articles: List<R>,
    @SerialName("status") val status: String,
    @SerialName("totalResults") val totalResults: Int
)