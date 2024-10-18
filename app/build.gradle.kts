import org.gradle.kotlin.dsl.android

plugins {
   alias(libs.plugins.kotlin.serialization)
   alias(libs.plugins.google.devtools.ksp)
   id("infonacion.android.application")
   id("infonacion.android.application.compose")
   id("infonacion.di.library.compose")
}

android {
   namespace = "com.minato.infonacion"

   defaultConfig {
      applicationId = "com.minato.infonacion"
      versionCode = 1
      versionName = "1.0"

      testInstrumentationRunner = "com.minato.infonacion.di.HiltTestRunner"
      vectorDrawables {
         useSupportLibrary = true
      }
   }

   buildTypes {
      release {
         isMinifyEnabled = false
         proguardFiles(
            getDefaultProguardFile("proguard-android-optimize.txt"),
            "proguard-rules.pro"
         )
      }

   }

   packaging {
      resources {
         excludes += "/META-INF/{AL2.0,LGPL2.1}"
      }
   }

   composeCompiler {
      enableStrongSkippingMode = true
   }
}

dependencies {

   implementation(project(":domain:country"))
   implementation(project(":domain:region"))
   implementation(project(":domain:map"))
   implementation(project(":framework:countries"))
   implementation(project(":framework:region"))
   implementation(project(":framework:map"))
   implementation(project(":framework:core"))
   implementation(project(":feature:countries"))
   implementation(project(":feature:common"))

   implementation(libs.androidx.activity.compose)

   androidTestImplementation(platform(libs.androidx.compose.bom))
   androidTestImplementation(libs.androidx.junit)
   androidTestImplementation(libs.androidx.test.core)
   androidTestImplementation(libs.androidx.test.rules)
   androidTestImplementation(libs.androidx.espresso.core)
   androidTestImplementation(libs.androidx.ui.test.junit4)
   androidTestImplementation(libs.hilt.android.testing)
   kspAndroidTest(libs.hilt.compiler)
   androidTestImplementation(libs.room.ktx)
   kspAndroidTest(libs.room.compiler)
   androidTestImplementation(libs.okhttp.mockwebserver)
}