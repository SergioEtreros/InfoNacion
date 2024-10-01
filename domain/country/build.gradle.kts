plugins {
   id("infonacion.jvm.library")
   id("infonacion.di.library")
}

java {
   sourceCompatibility = JavaVersion.VERSION_21
   targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
   implementation(project(":domain:region"))
   testImplementation((project(":test:unit")))
}