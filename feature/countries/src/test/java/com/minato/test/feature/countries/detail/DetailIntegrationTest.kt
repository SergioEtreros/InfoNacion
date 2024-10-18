package com.minato.test.feature.countries.detail

import app.cash.turbine.test
import com.minato.common.Result
import com.minato.country.usecases.GetCountryDetailsUseCase
import com.minato.feature.countries.detail.DetailViewmodel
import com.minato.map.usecases.OpenMapUseCase
import com.minato.unit.data.buildCountriesRepositoryWith
import com.minato.unit.data.buildMapRepository
import com.minato.unit.domain.country.sampleCountries
import com.minato.unit.domain.country.sampleCountry
import com.minato.unit.testrules.CoroutineTestRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailIntegrationTest {

   @get:Rule
   val coroutineTestRule = CoroutineTestRule()

   private lateinit var detailViewmodel: DetailViewmodel

   private val sampleCountry = sampleCountry("aaa")

   @Before
   fun setUp() {
      val countryCode = "aaa"
      val countries = sampleCountries("aaa", "bbb", "ccc")
      detailViewmodel = DetailViewmodel(
         countryCode,
         getCountryDetailsUseCase =
         GetCountryDetailsUseCase(
            buildCountriesRepositoryWith(
               localData = countries,
               remoteData = countries
            )
         ),
         openMapUseCase = OpenMapUseCase(buildMapRepository())
      )
   }

   @Test
   fun `Ui loads data on start`(): Unit = runTest {
      detailViewmodel.state.test {
         assertEquals(Result.Loading, awaitItem())
         assertEquals(Result.Success(sampleCountry), awaitItem())
      }
   }
}