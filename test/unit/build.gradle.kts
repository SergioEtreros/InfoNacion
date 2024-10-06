plugins {
   id("infonacion.jvm.library")
}

dependencies {
   implementation(project(":domain:country"))
   implementation(project(":domain:region"))
   implementation(project(":domain:map"))
   implementation(libs.junit)
   implementation(libs.kotlinx.coroutines.test)
}

