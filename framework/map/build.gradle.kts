plugins {
   id("infonacion.android.library")
   id("infonacion.di.library")
}

android {
   namespace = "com.minato.map"
}

dependencies {
   implementation(project(":domain:map"))
//   implementation(libs.play.services.location)
}