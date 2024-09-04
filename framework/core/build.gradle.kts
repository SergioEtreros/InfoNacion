plugins {
   id("infonacion.android.library")
   id("infonacion.android.room")
   id("infonacion.jvm.retrofit")
   id("infonacion.di.library")
}

android {
   namespace = "com.minato.core"

   defaultConfig {
      ksp {
         arg("room.schemaLocation", "$projectDir/schemas")
      }
   }

   buildFeatures {
      buildConfig = true
   }

}

dependencies {
   implementation(project(":framework:countries"))
}