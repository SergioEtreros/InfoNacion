package com.minato.region

import android.location.Geocoder
import com.minato.region.data.DEFAULT_REGION
import com.minato.region.data.LocationDataSource
import com.minato.region.data.RegionDataSource
import com.minato.region.entities.Location
import javax.inject.Inject

internal class GeocoderRegionDataSource @Inject constructor(
   private val geocoder: Geocoder,
   private val locationDataSource: LocationDataSource
) : RegionDataSource {
   override suspend fun getLastRegion(): String =
      locationDataSource.getLastLocation()?.toRegion() ?: DEFAULT_REGION

   private suspend fun Location.toRegion(): String {
      val addresses = geocoder.getFromLocationCompat(latitude, longitude, 1)
      val region = addresses.firstOrNull()?.countryCode
      return region ?: DEFAULT_REGION
   }
}