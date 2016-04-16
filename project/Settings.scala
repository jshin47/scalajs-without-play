import org.scalajs.sbtplugin.JSModuleID
import org.scalajs.sbtplugin.ScalaJSPlugin.AutoImport._
import org.scalajs.sbtplugin.cross.CrossProject
import sbt.Keys._
import sbt.{Def, ModuleID, Project, Resolver}

object Settings {

  //
  // It's okay to define your scala version/setting even if you don't plan on using Jvm Scala in a particular project. In fact you must or it will be guessed.
  //
  // Same goes for the other Jvm specific and metadataish settings.
  //

  lazy val commonSettings = Seq {

    scalaVersion := "2.11.8"

    organization := "justin"

    scalacOptions ++= Seq(
      "-encoding", "UTF-8",
      "-Xexperimental",
      "-language:postfixOps",
      "-language:higherKinds",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-Xlint",
      "-Ywarn-dead-code"
    )

    resolvers ++= Seq(
      Resolver.bintrayRepo("scalaz", "releases"),
      Resolver.sonatypeRepo("public"),
      Resolver.sonatypeRepo("snapshots"),
      Resolver.sonatypeRepo("releases")
    )
  }

  // no publish, irrelevant

  val noPublishSettings = Seq {
    publish := ()
    publishLocal := ()
    publishArtifact := false
  }

  //
  //
  //  Here are some helpers for defining projects.
  //
  //
  //

  // Oooh... a crossproject!

  implicit class CrossProjectExt(crossProject: CrossProject) {

    def configureBaseline() = crossProject
      .settings(commonSettings: _*)

    def doNotPublish() = crossProject
      .settings(noPublishSettings: _*)

    def withModuleNameAndName(modName: String, myName: String) =
      crossProject.settings(
        moduleName := modName,
        name := myName
      )

  }

  // A regular scala project Whether JVM or JS.

  implicit class ProjectExtensions(project: Project) {

    def configureBaseline() = project
      .settings(commonSettings: _*)

    def doNotPublish() = project
      .settings(noPublishSettings: _*)

    def withModuleName(name: String) =
      project.settings(
        moduleName := name
      )

    def withJvmDependencies(deps: ModuleID*) = project.settings({
      libraryDependencies ++= Seq(deps:_*)
    })

    // FOR USE WITH SCALAJS ONLY
    def withFrontendDependencies(deps: Def.Setting[_]*) = project.settings(deps)



    // FOR USE WHEN YOU NEED JAVASCRIPT
    def withJavascriptDepenencies(deps: JSModuleID*) = project.settings(
      jsDependencies ++= deps                                                   // <-- this is how you will import REAL JAVASCRIPT AND STYLES
    )
  }


  val infrastructureDependenciesForJVM = Seq(

  )


}