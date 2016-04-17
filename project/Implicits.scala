import ScalaJsDependencies.AwkwardlyWrapsScalaJsDependenciesSoYouCanAggregateThem
import org.scalajs.sbtplugin.JSModuleID
import org.scalajs.sbtplugin.ScalaJSPlugin.AutoImport._
import org.scalajs.sbtplugin.cross.CrossProject
import sbt.Keys._
import sbt.{ModuleID, Project}

object Implicits {

  import Settings._

  //
  //
  //  Here are some helpers for defining projects.
  //
  //
  //

  // Oooh... a crossproject!

  implicit class CrossProjectExt(crossProject: CrossProject) {

    def withCommonSettings() = crossProject.settings(commonSettings: _*)
    def withCommonJvmDeps( ) = crossProject.jvmConfigure(_.withCommonSettings().withCommonJvmDeps())
    def withCommonSjsDeps(  ) = crossProject.jsConfigure(_.withCommonSettings().withCommonSjsDeps())

    def configureBaseline() = crossProject
      .withCommonSettings().withCommonJvmDeps().withCommonSjsDeps()

    def doNotPublish() = crossProject
      .settings(noPublishSettings: _*)

    def withName(n: String) = crossProject.settings(name := n)

    def withModuleName(modName: String) =
      crossProject.settings(
        moduleName := modName
      )

  }

  // A regular scala project Whether JVM or JS.

  implicit class ProjectExtensions(project: Project) {

    def withName(n: String) = project.settings(name := n)

    def withCommonSettings  () = project.settings(commonSettings: _*)
    def withCommonJvmDeps   () = project.settings(libraryDependencies ++= commonJvmLibraries)
    def withCommonSjsDeps   () = project.settings(commonSjsLibraries.toDef())

    def configureBaseline() = project
      .withCommonSettings()
      .withCommonJvmDeps()
      .withCommonSjsDeps()

    def doNotPublish() = project
      .settings(noPublishSettings: _*)

    def withModuleName(name: String) =
      project.settings(
        moduleName := name
      )

    def withJvmDependencies(deps: ModuleID*) = project.settings({
      libraryDependencies ++= Seq(deps:_*)
    })

    def withSjsDependencies(deps: AwkwardlyWrapsScalaJsDependenciesSoYouCanAggregateThem) = project.settings(
      deps.toDef()
    )

    // BASICALLY EXCLUSIVELY FOR WEBJARS
    def withJavascriptDepenencies(deps: JSModuleID*) = project.settings(
      jsDependencies ++= deps                                                   // <-- this is how you will import REAL JAVASCRIPT AND STYLES
    )
  }

}