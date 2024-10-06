package com.minato.map.data

import javax.inject.Inject

class MapRepository @Inject constructor(
   private val googleMapsDataSource: GoogleMapsDataSource,
   private val openStreetMapsDataSource: OpenStreetMapDataSource
) {
   suspend fun openMap(url: String) {
      if (url.lowercase().contains("openstreetmap")) {
         openStreetMapsDataSource.openMap(url)
      } else {
         googleMapsDataSource.openMap(url)
      }
   }
}