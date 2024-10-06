package com.minato.map

import android.app.Application
import com.minato.map.data.OpenStreetMapDataSource

internal class OpenStreetDataSource(
   private val app: Application
) : OpenStreetMapDataSource {
   override suspend fun openMap(url: String) {
      launchIntent(app, url, "net.osmand")
   }
}