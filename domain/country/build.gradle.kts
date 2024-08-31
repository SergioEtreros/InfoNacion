plugins {
   id("infonacion.jvm.library")
   id("infonacion.di.library")
}

java {
   sourceCompatibility = JavaVersion.VERSION_22
   targetCompatibility = JavaVersion.VERSION_22
}

dependencies {
   testImplementation((project(":test:unit")))
}