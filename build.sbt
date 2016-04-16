import ScalaJsDependencies._
import ScalaJvmDependencies._
import Settings._
import StylesAndScriptsDependencies._
import sbt._
import sbt.Keys._
import sbt.Project.projectToRef


/*

      IT'S USUALLY NICE TO KEEP THE ROOT AS AN AGGREGATE PROJECT.

 */





/*

      DECLARE A CROSS PROJECT

 */

lazy val infrastructure =
  (crossProject in file("infrastructure"))
    .configureBaseline()                                                        // implicit
    .withModuleNameAndName("infrastructure-cross", "infrastructure")
    .settings(libraryDependencies ++= )