package com.minato.test.feature.countries.detail

import app.cash.turbine.test
import com.minato.common.Result
import com.minato.country.usecases.GetCountryDetailsUseCase
import com.minato.feature.countries.detail.DetailViewmodel
import com.minato.map.usecases.OpenMapUseCase
import com.minato.unit.domain.country.sampleCountry
import com.minato.unit.testrules.CoroutineTestRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class DetailViewmodelTest {

   @get:Rule
   val coroutineTestRule = CoroutineTestRule()

   @Mock
   lateinit var getCountryDetailsUseCase: GetCountryDetailsUseCase


   @Mock
   lateinit var openMapUseCase: OpenMapUseCase

   private lateinit var detailViewmodel: DetailViewmodel

   private val countryCode = "aaa"

   private val sampleCountry = sampleCountry("aaa")

   @Before
   fun setUp() {
      whenever(getCountryDetailsUseCase(countryCode)).thenReturn(flowOf(sampleCountry))
      detailViewmodel = DetailViewmodel(countryCode, getCountryDetailsUseCase, openMapUseCase)
   }

   @Test
   fun `Country details are requested at startup`(): Unit = runTest {
      detailViewmodel.state.test {
         assertEquals(Result.Loading, awaitItem())
         assertEquals(Result.Success(sampleCountry), awaitItem())
      }
   }

   @OptIn(ExperimentalCoroutinesApi::class)
   @Test
   fun `OpenMap calls OpenMapUseCase when called`(): Unit = runTest {
      detailViewmodel.state.test {
         assertEquals(Result.Loading, awaitItem())
         assertEquals(Result.Success(sampleCountry), awaitItem())

         detailViewmodel.openMap(sampleCountry.googleMaps)
         runCurrent()

         verify(openMapUseCase).invoke(any())
      }
   }
}