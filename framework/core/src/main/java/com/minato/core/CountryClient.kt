package com.minato.core

import com.minato.countries.network.CountryService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create

internal class CountryClient(baseUrl: String) {


   private val intercepter = HttpLoggingInterceptor().apply {
      level = HttpLoggingInterceptor.Level.HEADERS
   }

   private val okHttpClient = OkHttpClient.Builder()
      .addInterceptor(intercepter)
//      .connectTimeout(200, TimeUnit.SECONDS)
//      .writeTimeout(200, TimeUnit.SECONDS)
//      .readTimeout(300, TimeUnit.SECONDS)
      .build()

   private val json = Json {
      ignoreUnknownKeys = true
   }

   val instance = Retrofit.Builder()
      .baseUrl(baseUrl)
      .client(okHttpClient)
      .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
      .build()
      .create<CountryService>()
}