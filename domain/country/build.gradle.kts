plugins {
   id("infonacion.jvm.library")
   id("infonacion.di.library")
}

dependencies {
//   implementation(project(":domain:region"))
   testImplementation((project(":test:unit")))
}