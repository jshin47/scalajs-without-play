import ScalaJsDependencies.{AwkwardlyWrapsScalaJsDependenciesSoYouCanAggregateThem, JsDependencies, Sjses}
import com.typesafe.sbt.jse.{SbtJsEngine, SbtJsTask}
import com.typesafe.sbt.rjs.SbtRjs
import com.typesafe.sbt.web.SbtWeb
import org.madoushi.sbt.sass.SbtSass
import org.scalajs.sbtplugin.{JSModuleID, ScalaJSPlugin}
import org.scalajs.sbtplugin.ScalaJSPlugin.AutoImport._
import org.scalajs.sbtplugin.cross.CrossProject
import sbt.Keys._
import sbt.{Build, Def, File, ModuleID, Project, Resolver}

object Support extends Build {

  import Implicits._

  implicit class NamingConventionsForRootName(root: String) {

    lazy val                                  aggregateName   =   s"$root-agg"

    def        crossProjectAggregateName(crossName: String)   =   s"$crossName-agg"
    def            crossProjectCrossName(crossName: String)   =   s"lib-$crossName-cross"
    def            jsProjectInCrossPName(crossName: String)   =   s"lib-$crossName-js"
    def           jvmProjectInCrossPName(crossName: String)   =   s"lib-$crossName-jvm"

    def             sjsOnlyProjectName(projectName: String)   =   s"lib-$root-$projectName-sjs-alone"
    def             jvmOnlyProjectName(projectName: String)   =   s"lib-$root-$projectName-jvm-alone"

  }

  case class CrossProjectFactory()

  def defineCrossProjectFromRoot(
                                  root: String,
                                  overallName: String,
                                  f: File,
                                  Agg: (Project) ⇒ Project = identity,
                                  Cross: (CrossProject) ⇒ CrossProject = identity,
                                  JsProject: (Project)  ⇒ Project = identity,
                                  JvmProject: (Project) ⇒ Project = identity
                                )
  : (Project, CrossProject, Project, Project) = {

    lazy val prj_Cross =

      CrossProject(root.crossProjectCrossName(overallName), f, CrossType.Full)
        .withCommonSettings()
        .withName(root.crossProjectCrossName(overallName))
        .configureBaseline()

    lazy val prj_sjs = prj_Cross.js.withCommonSettings().withName(root.jsProjectInCrossPName(overallName))
    lazy val prj_jvm = prj_Cross.jvm.withCommonSettings().withName(root.jvmProjectInCrossPName(overallName))

    lazy val prj =

      Project(root.crossProjectAggregateName(overallName), f)
        .doNotPublish()
        .configureBaseline()
        .withName(root.crossProjectAggregateName(overallName))
        .aggregate(prj_sjs, prj_jvm)

    (
      Agg(prj) ,
      Cross(prj_Cross) ,
      JsProject(prj_sjs) ,
      JvmProject(prj_jvm)
    )
  }

  def Endow_ClientSide(client: Project) =
  
    client.enablePlugins(SbtJsEngine, SbtJsTask, ScalaJSPlugin, SbtWeb, SbtRjs, SbtSass)
          .withSjsDependencies(Settings.clientImplementationSjsLibs)
          .withJavascriptDepenencies(Settings.allClientSideDependenciesWeveGot: _*)

  def Endow_ServerSide(server: Project) =

    server.enablePlugins(SbtJsEngine, SbtJsTask, ScalaJSPlugin, SbtWeb, SbtRjs, SbtSass)
                .withJvmDependencies(Settings.akkaJvmLibs: _*)

}