package com.minato.country.usecases

import com.minato.country.data.CountryRepository
import javax.inject.Inject

class GetCountryDetailsUseCase @Inject constructor(
   private val repository: CountryRepository
) {
   operator fun invoke(id: Int) = repository.getCountryById(id)
}