package com.minato.country.data

import com.minato.country.entities.Country

interface CountryRemoteDataSource {
   suspend fun getCountries(): List<Country>
   suspend fun getCountryByCountryCode(countryCode: String): Country
}