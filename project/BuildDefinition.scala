import sbt._

object BuildDefinition extends Build {

  lazy val
  (infrastructureProject,
    infrastructureCross,
    infrastructureSjs,
    infrastructureJvm) =

  Support.defineCrossProjectFromRoot("notplayin", "infrastructure", file("infrastructure"))


  lazy val
  (clientAppProject,
  clientAppCrossProject,
  clientJsApplication,
  clientJvmServerAccess) =

    Support.defineCrossProjectFromRoot(
      "notplayin",
      "clientapplication",
      file("clientapplication"),
      JsProject = Support.Endow_ClientSide,
      JvmProject = Support.Endow_ServerSide
    )

}