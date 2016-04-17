import ScalaJsDependencies.{AwkwardlyWrapsScalaJsDependenciesSoYouCanAggregateThem, JsDependencies, Sjses}
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

  lazy val commonSettings = Seq(

    scalaVersion := "2.11.8",

    organization := "justin",

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
    ), 

    resolvers ++= Seq(
      Resolver.bintrayRepo("mfglabs", "maven"),
      Resolver.bintrayRepo("scalaz", "releases"),
      Resolver.sonatypeRepo("public"),
      Resolver.sonatypeRepo("snapshots"),
      Resolver.sonatypeRepo("releases")
    )
  )

  // no publish, irrelevant

  val noPublishSettings = Seq {
    publish := ()
    publishLocal := ()
    publishArtifact := false
  }

  // A BIG SET OF TRADITIONAL JVM DEPS YOU'LL WANT TO HAVE IN ALL YOUR PROJECTS, MAYBE. DEFINITELY THE PICKLERS.

  import ScalaJvmDependencies.JvmDependencies._

  val commonJvmLibraries = Seq(
    prickle,
    webjarlocator,
    boopickle,
    scopt,
    scalaz,
    scalaTest,
    scalaMock,
    slf4s,
    mockito,
    scalaXml
  )

  // AKKA STUFF FOR JVM, TYPICALLY USED ON SERVER SIDE

  val akkaJvmLibs = Seq(
    akkaActor,
    akkaClusterMetrics,
    akkaClusterTools,
    akkaCorePersist,
    akkaQuery,
    akkaDistributedData,
    akkaHttp,
    akkaSharding,
    akkaSlf4j
  )

  // NOW WE GROUP SOME COMMONLY USED SCALAJS STUFF. again this is NOT JAVASCRIPT, NOT CSS, ETC. ITS SCALA CODE.

  // NOTE THAT YOU WILL SEE SOME FAMILIAR NAMES/VERSIONS HERE. THIS IS BECAUSE SOME LIBS EXIST FOR BOTH JVM AND SJS.

  // WHEN YOU USE THE %%%  AS WE DO FOR THIS TYPE OF DEP, YOU MUST USE IT WITH A TASK. THIS IS BECAUSE IT RELIES ON A MACRO THAT ASSUMES A TASK EXISTS.
  // SO ITS A BIT AWKWARD.

  import ScalaJsDependencies.{JsDependencies ⇒ SJS}
  val commonSjsLibraries = Sjses(
    SJS.jsprickle,
    SJS.jboopickle,
    SJS.autowire,
    SJS.upickler,
    SJS.zzzzzz,
    SJS.monix,
    SJS.scalatags
  )


  val clientImplementationSjsLibs = Sjses(
    SJS.dom,
    SJS.slogging,
    SJS.scalatags,
    SJS.diode,
    SJS.diodereact,
    SJS.scalajsJquery,
    SJS.d3,
    SJS.scalaReact,
    SJS.scalaReactExtra,
    SJS.scalaReact72,
    SJS.scalaReactExtm,
    SJS.scalaCssCore,
    SJS.scalaCssExtR,
    SJS.videojs,
    SJS.markeSjs,
    SJS.momentjs,
    SJS.bindingJs,
    SJS.scaladgetjs,
    SJS.reactocomps
  )

  // Finally here are some REAL JS AND STYLES DEPENDENCIES USUALLY FROM WEBJARS.

  // These have zero effect on the compilation of your project; they only affect what comes after

  import StylesAndScriptsDependencies.WebJarDependencies

  // on second thought we already did this by defining apply

  val allClientSideDependenciesWeveGot = WebJarDependencies()



}