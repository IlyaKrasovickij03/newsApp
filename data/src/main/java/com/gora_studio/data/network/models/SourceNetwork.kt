package com.gora_studio.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourceNetwork(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String
)