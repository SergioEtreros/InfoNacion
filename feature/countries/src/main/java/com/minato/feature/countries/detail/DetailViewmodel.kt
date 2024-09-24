package com.minato.feature.countries.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minato.common.stateAsResultIn
import com.minato.country.usecases.GetCountryDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class DetailViewmodel @Inject constructor(
   @Named("countryCode") private val countryCode: String,
   getCountryDetailsUseCase: GetCountryDetailsUseCase
) : ViewModel() {

   val state = getCountryDetailsUseCase(countryCode).stateAsResultIn(viewModelScope)
}