package com.minato.country.usecases

import com.minato.country.data.CountryRepository
import javax.inject.Inject

class GetCountriesListUseCase @Inject constructor(
   private val repository: CountryRepository
) {
   operator fun invoke() = repository.countries
}