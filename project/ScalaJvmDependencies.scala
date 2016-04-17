import org.scalajs.sbtplugin.JSModuleID
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import org.scalajs.sbtplugin.cross.CrossProject
import sbt._
import sbt.Keys._

//
// THESE ARE ALL REGULAR OLD JVM DEPENDENCIES OF THE KIND YOU KNOW AND LOVE.
//

object ScalaJvmDependencies {

  object JvmDependencies {

    val                     prickle   =        "com.github.benhutchison"                             %%   "prickle"                               %   version.prickle
    val               webjarlocator   =        "org.webjars"                                         %    "webjars-locator"                       %   version.webjarloc
    val                   akkaActor   =        "com.typesafe.akka"                                   %%   "akka-actor"                            %   version.akka
    val                   akkaSlf4j   =        "com.typesafe.akka"                                   %%   "akka-slf4j"                            %   version.akka
    val            akkaClusterTools   =        "com.typesafe.akka"                                   %%   "akka-cluster-tools"                    %   version.akka
    val          akkaClusterMetrics   =        "com.typesafe.akka"                                   %%   "akka-cluster-metrics"                  %   version.akka
    val                akkaSharding   =        "com.typesafe.akka"                                   %%   "akka-cluster-sharding"                 %   version.akka
    val                    akkaHttp   =        "com.typesafe.akka"                                   %%   "akka-http-experimental"                %   version.akka
    val         akkaDistributedData   =        "com.typesafe.akka"                                   %%   "akka-distributed-data-experimental"    %   version.akka
    val             akkaCorePersist   =        "com.typesafe.akka"                                   %%   "akka-persistence"                      %   version.akka
    val                   akkaQuery   =        "com.typesafe.akka"                                   %%   "akka-persistence-query-experimental"   %   version.akka
    val                    scalaXml   =        "org.scala-lang.modules"                              %%   "scala-xml"                             %   version.scalaxml
    val                      l4japi   =        "org.apache.logging.log4j"                            %    "log4j-api"                             %   version.log4j
    val                     l4jcore   =        "org.apache.logging.log4j"                            %    "log4j-core"                            %   version.log4j
    val                l4jslf4jImpl   =        "org.apache.logging.log4j"                            %    "log4j-slf4j-impl"                      %   version.log4j        %  Runtime
    val                       slf4s   =        "org.slf4s"                                           %%   "slf4s-api"                             %   version.slf4s
    val                       scopt   =        "com.github.scopt"                                    %%   "scopt"                                 %   version.scopt
    val                   scalaTest   =        "org.scalatest"                                       %%   "scalatest"                             %   version.scalaTest    %  Test
    val                   scalaMock   =        "org.scalamock"                                       %%   "scalamock-scalatest-support"           %   version.scalaMock    %  Test
    val                     mockito   =        "org.mockito"                                         %    "mockito-core"                          %   version.mockito      %  Test
    val                      scalaz   =        "org.scalaz"                                          %%   "scalaz-core"                           %   version.scalaz
    val                 monacleCore   =        "com.github.japgolly.fork.monocle"                    %%   "monocle-core"                          %   version.monocle
    val                     monaKro   =        "com.github.japgolly.fork.monocle"                    %%   "monocle-macro"                         %   version.monocle
    val                   boopickle   =        "me.chrons"                                           %%   "boopickle"                             %   version.booPickle

  }

  private object version {

    val                       slf4s   =        "1.7.12"
    val                       log4j   =        "2.3"
    val                   scalaTest   =        "3.0.0-M15"
    val                   scalaMock   =        "3.2.2"
    val                     mockito   =        "1.10.19"
    val                        akka   =        "2.4.4"
    val                       scopt   =        "3.3.0"
    val                     monocle   =        "1.2.0"
    val                      scalaz   =        "7.2.1"
    val                       scala   =        "2.11.8"
    val                   booPickle   =        "1.1.2"
    val                   cassandra   =        "0.11"
    val                    inmemory   =        "1.2.11"
    val                    scalaxml   =        "1.0.5"
    val                   parboiled   =        "2.1.1-SNAPSHOT"
    val                   shapeless   =        "2.2.5"
    val                   webjarloc   =        "0.23"
    val                     prickle   =        "1.1.5"
  }


}