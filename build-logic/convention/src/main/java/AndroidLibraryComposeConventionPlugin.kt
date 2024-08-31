import com.android.build.api.dsl.LibraryExtension
import com.minato.infonacion.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
   override fun apply(target: Project) {
      with(target) {
         with(pluginManager) {
            apply("infonacion.android.library")
         }

         val extension = extensions.getByType<LibraryExtension>()
         configureAndroidCompose(extension)
      }
   }
}