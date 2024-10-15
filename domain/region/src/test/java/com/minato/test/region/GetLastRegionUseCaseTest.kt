package com.minato.test.region

import com.minato.region.usecases.GetLastRegionUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class GetLastRegionUseCaseTest {

   @Test
   fun `invoke calls repository`(): Unit = runBlocking {

      val lastRegion = "US"
      val useCase = GetLastRegionUseCase(mock {
         onBlocking { getLastRegion() } doReturn ("US")
      })

      val result = useCase()

      assertEquals(lastRegion, result)
   }
}