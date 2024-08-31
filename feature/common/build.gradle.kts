plugins {
   id("infonacion.android.library.compose")
   alias(libs.plugins.kotlin.serialization)
}

android {
   namespace = "com.minato.common"
}

dependencies {
   implementation(libs.androidx.activity.compose)
}