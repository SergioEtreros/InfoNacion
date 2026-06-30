package com.minato.core

import com.minato.countries.network.CountryService
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create

internal class CountryClient(baseUrl: String, apiKey: String) {


   private val intercepter = HttpLoggingInterceptor().apply {
      level = HttpLoggingInterceptor.Level.HEADERS

   }

   private val inter = Interceptor { chain ->
      val request: Request = chain.request()
         .newBuilder()
         .header("accept", "application/json")
         .header("Authorization", "Bearer $apiKey")
         .build()
      chain.proceed(request)
   }

   private val okHttpClient = OkHttpClient.Builder()
      .addInterceptor(intercepter)
      .addInterceptor(inter)
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