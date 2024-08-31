import com.android.build.api.dsl.ApplicationExtension
import com.minato.infonacion.addAndroidTestDependencies
import com.minato.infonacion.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
   override fun apply(target: Project) {
      with(target) {
         with(pluginManager) {
            apply("com.android.application")
            val extensions = extensions.getByType<ApplicationExtension>()
            configureAndroidCompose(extensions)

            addAndroidTestDependencies()
         }
      }
   }
}