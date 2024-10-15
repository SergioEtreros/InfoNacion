package com.minato.test.map.data

import com.minato.map.data.GoogleMapsDataSource
import com.minato.map.data.MapRepository
import com.minato.map.data.OpenStreetMapDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class MapRepositoryTest {

   @Mock
   lateinit var googleMapsDataSource: GoogleMapsDataSource

   @Mock
   lateinit var openStreetMapsDataSource: OpenStreetMapDataSource

   private lateinit var mapRepository: MapRepository

   @Before
   fun setup() {
      mapRepository = MapRepository(googleMapsDataSource, openStreetMapsDataSource)
   }

   @Test
   fun `openMap calls google maps`(): Unit = runBlocking {
      val url = "https://www.google.com"
      mapRepository.openMap(url)
      verify(googleMapsDataSource).openMap(url)
   }

   @Test
   fun `openMap calls open street maps`(): Unit = runBlocking {
      val url = "https://www.openstreetmap.org"
      mapRepository.openMap(url)
      verify(openStreetMapsDataSource).openMap(url)
   }
}