plugins {
   id("infonacion.jvm.library")
   id("infonacion.di.library")
}

java {
   sourceCompatibility = JavaVersion.VERSION_17
   targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
   testImplementation((project(":test:unit")))
}