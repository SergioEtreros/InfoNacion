package com.minato.test.feature.countries.main

import app.cash.turbine.test
import com.minato.common.Result
import com.minato.country.entities.Country
import com.minato.country.usecases.GetCountriesListUseCase
import com.minato.feature.countries.main.MainViewmodel
import com.minato.region.usecases.GetLastRegionUseCase
import com.minato.unit.domain.country.sampleCountries
import com.minato.unit.testrules.CoroutineTestRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class MainViewmodelTest {

   @get:Rule
   val coroutineTestRule = CoroutineTestRule()

   @Mock
   lateinit var getCountriesListUseCase: GetCountriesListUseCase

   @Mock
   lateinit var getLastRegionUseCase: GetLastRegionUseCase

   private lateinit var mainViewmodel: MainViewmodel

   @Test
   fun `Countries are requested at startup`(): Unit = runTest {

      val countries = sampleCountries("aaa", "bbb", "ccc")

      whenever(getCountriesListUseCase()).thenReturn(flowOf(countries))
      mainViewmodel = MainViewmodel(getCountriesListUseCase, getLastRegionUseCase)


      mainViewmodel.state.test {
         assertEquals(Result.Loading, awaitItem())
         assertEquals(Result.Success(countries), awaitItem())
      }
   }

   @OptIn(ExperimentalCoroutinesApi::class)
   @Test
   fun `Last region is requested when needed`(): Unit = runTest {
      val lastRegion = "aaa"
      val countries = sampleCountries("aaa", "bbb", "ccc")
      var obtainedCountry: Country? = null

      whenever(getCountriesListUseCase()).thenReturn(flowOf(countries))
      whenever(getLastRegionUseCase()).thenReturn(lastRegion)

      mainViewmodel = MainViewmodel(getCountriesListUseCase, getLastRegionUseCase)


      mainViewmodel.state.test {
         assertEquals(Result.Loading, awaitItem())
         assertEquals(Result.Success(countries), awaitItem())
         mainViewmodel.getActualCountry { obtainedCountry = it }

         advanceUntilIdle()

         assertEquals(countries.first(), obtainedCountry)
      }
   }

   @Test
   fun `Error is propagated when failed`(): Unit = runTest {
      val error = RuntimeException("Something went wrong")
      whenever(getCountriesListUseCase.invoke()).thenReturn(flow { throw error })

      mainViewmodel = MainViewmodel(getCountriesListUseCase, getLastRegionUseCase)

      //TODO porqué funciona de las dos maneras

      mainViewmodel.state.test {
         assertEquals(Result.Loading, awaitItem())
//         assertEquals(Result.Error(error), awaitItem())
         val exceptionMessage = (awaitItem() as Result.Error).throwable.message
         assertEquals("Something went wrong", exceptionMessage)
      }

   }
}