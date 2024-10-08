@file:Suppress("DEPRECATION")

package com.minato.infonacion

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureKotlinAndroid(
   commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
   commonExtension.apply {
      compileSdk = 35

      defaultConfig {
         minSdk = 26
      }

      compileOptions {
         sourceCompatibility = JavaVersion.VERSION_21
         targetCompatibility = JavaVersion.VERSION_21
      }

      // Use withType to workaround https://youtrack.jetbrains.com/issue/KT-55947
      tasks.withType<KotlinCompile>().configureEach {
         kotlinOptions {
            jvmTarget = JavaVersion.VERSION_21.toString()
         }
      }

      dependencies {
         add("implementation", libs.findLibrary("androidx.core.ktx").get())
         add("implementation", libs.findLibrary("androidx.lifecycle.runtime.ktx").get())
      }

      addUnitTestDependencies()
   }
}

internal fun Project.configureKotlinJvm() {
   extensions.configure<JavaPluginExtension> {
      sourceCompatibility = JavaVersion.VERSION_21
      targetCompatibility = JavaVersion.VERSION_21
   }

   dependencies {
      add("implementation", libs.findLibrary("kotlinx.coroutines.core").get())
   }

   addUnitTestDependencies()
}