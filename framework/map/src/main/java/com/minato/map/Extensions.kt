package com.minato.map

import android.app.Application
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri

fun launchIntent(app: Application, url: String, packageName: String = "") {
   val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
   intent.flags = FLAG_ACTIVITY_NEW_TASK
   intent.setPackage(packageName)

   try {
      app.startActivity(intent)
   } catch (_: ActivityNotFoundException) {
      intent.setPackage(null)
      app.startActivity(intent)
   }
}