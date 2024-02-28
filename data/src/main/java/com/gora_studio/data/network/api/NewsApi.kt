package com.gora_studio.data.network.api

import com.gora_studio.data.network.models.Article
import com.gora_studio.data.network.models.Response
import com.gora_studio.data.network.utils.NewsApiKeyInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * [API Documentation](https://newsapi.org/docs)
 */
interface NewsApi {
    /**
     * Api details [here](https://newsapi.org/docs/endpoints/top-headlines)
     */
    @GET("/top-headlines")
    suspend fun getNewsByHeadlines(
        @Query("q") query: String? = null,
        @Query("country") country: String = "ru"
    ): Result<Response<Article>>
}

fun NewsApi(
    apiKey: String,
    baseUrl: String,
    okHttpClient: OkHttpClient?,
): NewsApi{

    val newOkHttpClient: OkHttpClient = (okHttpClient?.newBuilder() ?: OkHttpClient.Builder())
        .addInterceptor(NewsApiKeyInterceptor(apiKey))
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .client(newOkHttpClient)
        .build()

    return retrofit.create()
}