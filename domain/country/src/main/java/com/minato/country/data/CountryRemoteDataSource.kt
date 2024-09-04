package com.minato.country.data

import com.minato.country.entities.Country

interface CountryRemoteDataSource {
   fun getCountries(): List<Country>
   fun getCountryById(id: Int): Country
}