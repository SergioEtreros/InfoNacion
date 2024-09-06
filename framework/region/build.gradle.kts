plugins {
   id("infonacion.android.library")
   id("infonacion.di.library")
}

android {
   namespace = "com.minato.region"
}

dependencies {
   implementation(project(":domain:region"))
   implementation(libs.play.services.location)
}