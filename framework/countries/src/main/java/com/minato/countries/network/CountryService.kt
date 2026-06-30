package com.minato.countries.network

import com.minato.countries.network.model.CountriesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CountryService {

   @GET("v5")
   suspend fun getCountries(
      @Query("response_fields") responseFields: String = "flag,names,continents,codes",
      @Query("limit") limit: Int = 100,
      @Query("offset") offset: Int = 0
   ): CountriesResponse

   @GET("v5/codes.alpha_3/{countryCode}")
   suspend fun getCountryByCountryCode(@Path("countryCode") countryCode: String): CountriesResponse

   @GET("v5/names.common/{countryName}")
   suspend fun getCountryByCountryName(@Path("countryName") countryName: String): CountriesResponse
}