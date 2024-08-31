plugins {
   id("infonacion.jvm.library")
}

dependencies {
   implementation(project(":domain:country"))
   implementation(libs.junit)
   implementation(libs.kotlinx.coroutines.test)
}

