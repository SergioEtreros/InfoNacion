package com.minato.countries.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minato.common.stateAsResultIn
import com.minato.country.usecases.GetCountryDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class DetailViewmodel @Inject constructor(
   @Named("countryName") private val countryName: String,
   getCountryDetailsUseCase: GetCountryDetailsUseCase
) : ViewModel() {

   val state = getCountryDetailsUseCase(countryName).stateAsResultIn(viewModelScope)
}