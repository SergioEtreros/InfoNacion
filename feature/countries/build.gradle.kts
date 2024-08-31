plugins {
   id("infonacion.android.feature")
   id("infonacion.di.library.compose")
}

android {
   namespace = "com.minato.countries"
}

dependencies {
   implementation(project(":domain:country"))
}