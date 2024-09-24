package com.minato.feature.countries.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minato.common.ifSuccess
import com.minato.common.stateAsResultIn
import com.minato.country.entities.Country
import com.minato.country.usecases.GetCountriesListUseCase
import com.minato.region.usecases.GetLastRegionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewmodel @Inject constructor(
   getCountriesListUseCase: GetCountriesListUseCase,
   private val getLastRegionUseCase: GetLastRegionUseCase
) : ViewModel() {

   val state = getCountriesListUseCase().stateAsResultIn(viewModelScope)

   fun getActualCountry(countryFounded: (country: Country) -> Unit) {
      viewModelScope.launch {
         state.value.ifSuccess { countries ->
            val region = getLastRegionUseCase()
            countries.firstOrNull { it.countryCode == region }?.let {
               countryFounded(it)
            }
         }
      }
   }
}