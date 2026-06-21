package com.minato.countries.network

import com.minato.countries.network.model.CountryItem
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryService {

   @GET("?fields=flags,name,continent,cca2,cca3")
   suspend fun getCountries(): List<CountryItem>

   @GET("alpha/{countryCode}")
   suspend fun getCountryByCountryCode(@Path("countryCode") countryCode: String): List<CountryItem>
}