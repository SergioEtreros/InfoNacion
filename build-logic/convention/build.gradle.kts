plugins {
   `kotlin-dsl`
}

dependencies {
   compileOnly(libs.android.gradlePlugin)
   compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
   plugins {
      register("androidApplication") {
         id = "infonacion.android.application"
         implementationClass = "AndroidApplicationConventionPlugin"
      }
      register("androidApplicationCompose") {
         id = "infonacion.android.application.compose"
         implementationClass = "AndroidApplicationComposeConventionPlugin"
      }
      register("androidFeature") {
         id = "infonacion.android.feature"
         implementationClass = "AndroidFeatureConventionPlugin"
      }
      register("androidLibraryCompose") {
         id = "infonacion.android.library.compose"
         implementationClass = "AndroidLibraryComposeConventionPlugin"
      }
      register("androidLibrary") {
         id = "infonacion.android.library"
         implementationClass = "AndroidLibraryConventionPlugin"
      }
      register("androidRoom") {
         id = "infonacion.android.room"
         implementationClass = "AndroidRoomConventionPlugin"
      }
      register("jvmLibrary") {
         id = "infonacion.jvm.library"
         implementationClass = "JvmLibraryConventionPlugin"
      }
      register("jvmRetrofit") {
         id = "infonacion.jvm.retrofit"
         implementationClass = "JvmRetrofitConventionPlugin"
      }
      register("diLibrary") {
         id = "infonacion.di.library"
         implementationClass = "DiLibraryConventionPlugin"
      }
      register("diLibraryCompose") {
         id = "infonacion.di.library.compose"
         implementationClass = "DiLibraryComposeConventionPlugin"
      }
   }
}