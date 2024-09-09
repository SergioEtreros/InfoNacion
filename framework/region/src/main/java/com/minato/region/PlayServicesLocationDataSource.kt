package com.minato.region

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.minato.region.data.LocationDataSource
import com.minato.region.entities.Location
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import android.location.Location as AndroidLocation


internal class PlayServicesLocationDataSource @Inject constructor(
   private val fusedLocationClient: FusedLocationProviderClient
) : LocationDataSource {
   override suspend fun getLastLocation(): Location? = fusedLocationClient.lastLocation()
}

@SuppressLint("MissingPermission")
private suspend fun FusedLocationProviderClient.lastLocation(): Location? =
   suspendCancellableCoroutine { continuation ->

      val permission = arrayOf(PackageManager.PERMISSION_GRANTED)

      lastLocation.addOnSuccessListener { location ->
         continuation.resume(location?.toDomainLocation())
      }.addOnFailureListener {
         continuation.resume(null)
      }
   }

private fun AndroidLocation.toDomainLocation() = Location(latitude, longitude)