package com.minato.countries.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minato.common.stateAsResultIn
import com.minato.country.usecases.GetCountriesListUseCase
import javax.inject.Inject

class MainViewmodel @Inject constructor(
   getCountriesListUseCase: GetCountriesListUseCase
) : ViewModel() {

   val state = getCountriesListUseCase().stateAsResultIn(viewModelScope)
}