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
include(":domain:region")
include(":domain:map")

include(":feature:common")
include(":feature:countries")

include(":framework:core")
include(":framework:countries")
include(":framework:region")
include(":framework:map")

include(":test:unit")
