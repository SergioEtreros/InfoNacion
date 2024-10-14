plugins {
   id("infonacion.jvm.library")
   id("infonacion.di.library")
}

dependencies {
   testImplementation((project(":test:unit")))
}