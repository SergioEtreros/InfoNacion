package com.minato.test.country.usecases

import com.minato.country.usecases.GetCountryDetailsUseCase
import com.minato.unit.domain.country.sampleCountry
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class GetCountryDetailsUseCaseTest {

   @Test
   fun `invoke calls repository`() {

      val countryFlow = flowOf(sampleCountry("aaa"))
      val useCase = GetCountryDetailsUseCase(mock {
         on { getCountryByCountryCode("aaa") } doReturn (countryFlow)
      })

      val result = useCase("aaa")

      assertEquals(countryFlow, result)
   }
}