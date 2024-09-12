package com.minato.countries.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minato.common.stateAsResultIn
import com.minato.country.usecases.GetCountriesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewmodel @Inject constructor(
   getCountriesListUseCase: GetCountriesListUseCase,
//   private val getLastRegionUseCase: GetLastRegionUseCase
) : ViewModel() {

   val state = getCountriesListUseCase().stateAsResultIn(viewModelScope)
}