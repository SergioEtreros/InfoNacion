plugins {
   id("infonacion.android.library")
   id("infonacion.android.room")
   id("infonacion.jvm.retrofit")
   id("infonacion.di.library")
}

android {
   namespace = "com.minato.countries"
}

dependencies {
   implementation(project(":domain:country"))
   implementation(project(":domain:region"))
}