package com.minato.test.country.usecases

import com.minato.country.usecases.GetCountriesListUseCase
import com.minato.unit.domain.country.sampleCountries
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock


class GetCountriesListUseCaseTest {

   @Test
   fun `invoke calls repository`() {

      val countryFlow = flowOf(sampleCountries("aaa", "bbb", "ccc"))

      val useCase = GetCountriesListUseCase(mock {
         on { countries } doReturn (countryFlow)
      })

      val result = useCase()

      assertEquals(countryFlow, result)
   }
}