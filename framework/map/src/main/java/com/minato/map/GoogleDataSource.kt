package com.minato.map

import android.app.Application
import com.minato.map.data.GoogleMapsDataSource

internal class GoogleDataSource(
   private val app: Application
) : GoogleMapsDataSource {
   override suspend fun openMap(url: String) {
      launchIntent(app, url, "com.google.android.apps.maps")
   }
}