package com.minato.test.country.data

import com.minato.country.data.CountryLocalDataSource
import com.minato.country.data.CountryRemoteDataSource
import com.minato.country.data.CountryRepository
import com.minato.country.entities.Country
import com.minato.unit.domain.country.sampleCountries
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class CountryRepositoryTest {

   @Mock
   lateinit var localDataSource: CountryLocalDataSource

   @Mock
   lateinit var remoteDataSource: CountryRemoteDataSource

   private lateinit var repository: CountryRepository

   @Before
   fun setup() {
      repository = CountryRepository(localDataSource, remoteDataSource)
   }

   @Test
   fun `Countries are taken from local if available`(): Unit = runBlocking {
      val localCountries = sampleCountries("aaa", "bbb", "ccc")
      whenever(localDataSource.countries).thenReturn(flowOf(localCountries))

      val result = repository.countries

      assertEquals(localCountries, result.first())
   }

   @Test
   fun `Countries are taken from remote if local is empty`(): Unit = runBlocking {
      val localCountries = emptyList<Country>()
      val remoteCountries = sampleCountries("aaa", "bbb", "ccc")
      whenever(localDataSource.countries).thenReturn(flowOf(localCountries))
      whenever(remoteDataSource.getCountries()).thenReturn(remoteCountries)

      repository.countries.first()

      verify(remoteDataSource).getCountries()
   }

   @Test
   fun `Countries are saved to local when empty`() = runBlocking {
      val localCountries = emptyList<Country>()
      val remoteCountries = sampleCountries("aaa", "bbb", "ccc")
      whenever(localDataSource.countries).thenReturn(flowOf(localCountries))
      whenever(remoteDataSource.getCountries()).thenReturn(remoteCountries)

      repository.countries.first()

      verify(localDataSource).saveAllCountries(remoteCountries)
   }
}