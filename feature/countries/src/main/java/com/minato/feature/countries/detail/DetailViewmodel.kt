package com.minato.feature.countries.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minato.common.stateAsResultIn
import com.minato.country.usecases.GetCountryDetailsUseCase
import com.minato.map.usecases.OpenMapUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class DetailViewmodel @Inject constructor(
   @param:Named("countryName") private val countryName: String,
   getCountryDetailsUseCase: GetCountryDetailsUseCase,
   private val openMapUseCase: OpenMapUseCase
) : ViewModel() {

   val state = getCountryDetailsUseCase(countryName).stateAsResultIn(viewModelScope)

   fun openMap(url: String) {
      viewModelScope.launch {
         openMapUseCase(url)
      }
   }
}