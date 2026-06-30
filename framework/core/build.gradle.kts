import java.util.Properties

plugins {
   id("infonacion.android.library")
   id("infonacion.android.room")
   id("infonacion.jvm.retrofit")
   id("infonacion.di.library")
}

android {
   namespace = "com.minato.core"

   defaultConfig {
      val properties = Properties()
      properties.load(project.rootProject.file("local.properties").readText().byteInputStream())
      buildConfigField("String", "RESTCOUNTRIES_API", "\"${properties["RESTCOUNTRIES_API"]}\"")

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