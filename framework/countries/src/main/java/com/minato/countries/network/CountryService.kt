package com.minato.countries.network

import com.minato.countries.network.model.RemoteResult
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryService {

   @GET("all")
   suspend fun getCountries(): RemoteResult

   @GET("name/{name}")
   suspend fun getCountryByName(@Path("name") name: String): RemoteResult
}