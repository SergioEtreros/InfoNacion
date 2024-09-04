package com.minato.countries.network

import retrofit2.http.GET
import retrofit2.http.Path

interface CountryService {

   @GET("")
   suspend fun getCountries(): RemoteResult

   @GET("/{id}")
   suspend fun getCountryById(@Path("id") id: Int): RemoteResult
}