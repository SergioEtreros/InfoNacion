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

      testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

   implementation(libs.androidx.core.ktx)
   implementation(libs.androidx.lifecycle.runtime.ktx)
   implementation(libs.androidx.activity.compose)
   implementation(platform(libs.androidx.compose.bom))
   implementation(libs.androidx.ui)
   implementation(libs.androidx.ui.graphics)
   implementation(libs.androidx.ui.tooling.preview)
   implementation(libs.androidx.material3)
   testImplementation(libs.junit)
   androidTestImplementation(libs.androidx.junit)
   androidTestImplementation(libs.androidx.espresso.core)
   androidTestImplementation(platform(libs.androidx.compose.bom))
   androidTestImplementation(libs.androidx.ui.test.junit4)
   debugImplementation(libs.androidx.ui.tooling)
   debugImplementation(libs.androidx.ui.test.manifest)
}