package com.minato.test.map.usecases

import com.minato.map.data.MapRepository
import com.minato.map.usecases.OpenMapUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class OpenMapUseCaseTest {

   @Test
   fun `invoke calls repository`(): Unit = runBlocking {
      val url = "https://www.google.com"
      val repository = mock<MapRepository>()
      val useCase = OpenMapUseCase(repository)

      useCase(url)

      verify(repository).openMap(url)
   }
}