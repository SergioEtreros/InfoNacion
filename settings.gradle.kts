@file:Suppress("UnstableApiUsage")

pluginManagement {
   includeBuild("build-logic")
   repositories {
      google {
         content {
            includeGroupByRegex("com\\.android.*")
            includeGroupByRegex("com\\.google.*")
            includeGroupByRegex("androidx.*")
         }
      }
      mavenCentral()
      gradlePluginPortal()
   }
}
dependencyResolutionManagement {
   repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
   repositories {
      google()
      mavenCentral()
   }
}

rootProject.name = "InfoNacion"
include(":app")

include(":domain:country")

include(":feature:countries")
include(":feature:common")

include(":framework:core")
include(":framework:countries")

include(":test:unit")