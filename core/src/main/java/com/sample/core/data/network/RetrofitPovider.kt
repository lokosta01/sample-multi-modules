package com.sample.core.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

const val URL = "https://example/.."

@Singleton
class RetrofitPovider @Inject constructor() {

    private lateinit var retrofit: Retrofit

    private val gsonConverterFactory = GsonConverterFactory.create()

    init {
        retrofit = createRetrofit(URL)
    }

    private fun createRetrofit(url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    fun <T> createApi(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}