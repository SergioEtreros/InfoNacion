package com.minato.test.feature.countries.main

import app.cash.turbine.test
import com.minato.common.Result
import com.minato.country.entities.Country
import com.minato.country.usecases.GetCountriesListUseCase
import com.minato.feature.countries.main.MainViewmodel
import com.minato.region.data.DEFAULT_REGION
import com.minato.region.data.RegionRepository
import com.minato.region.usecases.GetLastRegionUseCase
import com.minato.unit.data.FakeRegionDataSource
import com.minato.unit.data.buildCountriesRepositoryWith
import com.minato.unit.domain.country.sampleCountries
import com.minato.unit.testrules.CoroutineTestRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class MainIntegrationTest {

   @get:Rule
   val coroutineTestRule = CoroutineTestRule()

   @Test
   fun `Data is loaded from server when local is empty`(): Unit = runTest {
      val remoteData = sampleCountries("aaa", "bbb", "ccc")
      val mainViewmodel = buildViewmodelWith(remoteData = remoteData)

      mainViewmodel.state.test {
         assertEquals(Result.Loading, awaitItem())
         assertEquals(Result.Success(emptyList<Country>()), awaitItem())
         assertEquals(Result.Success(remoteData), awaitItem())
      }
   }

   @Test
   fun `Data is loaded from local when available`(): Unit = runTest {
      val localData = sampleCountries("aaa", "bbb", "ccc", "ddd")
      val mainViewmodel = buildViewmodelWith(localData = localData)

      mainViewmodel.state.test {
         assertEquals(Result.Loading, awaitItem())
         assertEquals(Result.Success(localData), awaitItem())
      }
   }

   @OptIn(ExperimentalCoroutinesApi::class)
   @Test
   fun `Country from last region is obtained`(): Unit = runTest {
      val localData = sampleCountries("aaa", "bbb", "ccc", "ddd")
      val mainViewmodel = buildViewmodelWith(localData = localData, lastRegion = "aaa")
      var obtainedCountry: Country? = null

      mainViewmodel.state.test {
         assertEquals(Result.Loading, awaitItem())
         assertEquals(Result.Success(localData), awaitItem())
         mainViewmodel.getActualCountry { obtainedCountry = it }
      }

      advanceUntilIdle()
      assertEquals(localData.first(), obtainedCountry)
   }

   private fun buildViewmodelWith(
      localData: List<Country> = emptyList(),
      remoteData: List<Country> = sampleCountries("aaa", "bbb", "ccc"),
      lastRegion: String = DEFAULT_REGION
   ) = MainViewmodel(
      GetCountriesListUseCase(
         buildCountriesRepositoryWith(localData = localData, remoteData = remoteData)
      ),
      GetLastRegionUseCase(
         RegionRepository(FakeRegionDataSource(lastRegion))
      )
   )
}