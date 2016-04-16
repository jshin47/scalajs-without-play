import org.scalajs.sbtplugin.JSModuleID
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import org.scalajs.sbtplugin.cross.CrossProject
import sbt._
import sbt.Keys._

object ScalaJsDependencies {


  //
  //  THESE ARE TRICKY - THEY ARE NOT FOR USE IN JVM PROJECTS BUT ARE ONLY FOR SCALA JS, BUT THEY ARE NOT JAVASCRIPT.
  //
  //


  //
  //      ACHTUNG! ACHTUNG! YOU HAVE TO WRAP EM IN THAT SORT OF FORMAT SO THEY DONT START DOWNLOADING. CAN NVER TRUST MACROZ
  //


  private def djs(group: String, art: String, v: String) = Def.SettingsDefinition.wrapSettingsDefinition(libraryDependencies += group %%% art % v)
  private def djsp(group: String, art: String, v: String, p: String = "default") = Def.SettingsDefinition.wrapSettingsDefinition(libraryDependencies += group %%% art % v % p )
  //private def smg(modules: ModuleID*)(setting: Def.Initialize[Def.Setting[Seq[sbt.ModuleID]]]*) = Def.settings(libraryDependencies ++= modules:_*, setting)

  object JsDependencies {

    val                   jsprickle   = djs(  "com.github.benhutchison"                              ,   "prickle"                                , version.prickle                    )
    val                  jboopickle   = djs(   "me.chrons"                                           ,    "boopickle"                             , version.booPickle                  )
    val                    autowire   = djs(   "com.lihaoyi"                                         ,    "autowire"                              , version.autowire                   )
    val                    upickler   = djs(   "com.lihaoyi"                                         ,    "upickle"                               , version.upickle                    )
    val                      zzzzzz   = djs(   "org.scalaz"                                          ,    "scalaz-core"                           , version.scalaz                     )
    //val                      moment   = djs(   "io.github.widok"                                     ,    "scala-js-moment"                       , version.scalajsMoment              )
    val                    monocle1   = djs(   "com.github.japgolly.fork.monocle"                    ,    "monocle-core"                          , version.monocle                    )
    val                    monocle2   = djs(   "com.github.japgolly.fork.monocle"                    ,    "monocle-macro"                         , version.monocle                    )
    val                       monix   = djs(   "io.monix"                                            ,    "monix-reactive"                        , version.monix                      )
    val                   shapeless   = djs(   "com.chuusai"                                         ,    "shapeless"                             , version.shapeless                  )
    val                  parboiled2   = djs(   "com.github.karasiq"                                  ,    "parboiled"                             , version.parboiled                  )
    val                         dom   = djs(   "org.scala-js"                                        ,    "scalajs-dom"                           , version.scalajsDom                 )
    val                   scalatags   = djs(   "com.lihaoyi"                                         ,    "scalatags"                             , version.scalatags                  )
    val                    slogging   = djs(   "biz.enef"                                            ,    "slogging"                              , version.slogging                   )
    val                       diode   = djs(   "me.chrons"                                           ,    "diode"                                 , version.diode                      )
    val                  diodereact   = djs(   "me.chrons"                                           ,    "diode-react"                           , version.diode                      )
    val               scalajsJquery   = djs(   "be.doeraene"                                         ,    "scalajs-jquery"                        , version.scalajsJquery              )
    val                          d3   = djs(   "org.singlespaced"                                    ,    "scalajs-d3"                            , version.scalajsD3                  )
    val                  scalaReact   = djs(   "com.github.japgolly.scalajs-react"                   ,    "core"                                  , version.scalaJsReact               )
    val             scalaReactExtra   = djs(   "com.github.japgolly.scalajs-react"                   ,    "extra"                                 , version.scalaJsReact               )
    val                scalaReact72   = djs(   "com.github.japgolly.scalajs-react"                   ,    "ext-scalaz72"                          , version.scalaJsReact               )
    val              scalaReactExtm   = djs(   "com.github.japgolly.scalajs-react"                   ,    "ext-monocle"                           , version.scalaJsReact               )
    val                scalaCssCore   = djs(   "com.github.japgolly.scalacss"                        ,    "core"                                  , version.scalaCss                   )
    val                scalaCssExtR   = djs(   "com.github.japgolly.scalacss"                        ,    "ext-react"                             , version.scalaCss                   )
    val                     videojs   = djs(   "com.github.karasiq"                                  ,    "scalajs-videojs"                       , version.scalaJsVideo               )
    val                    markedjs   = djs(   "com.github.karasiq"                                  ,    "scalajs-marked"                        , version.scalajsMarked              )
    val                    momentjs   = djs(   "io.github.widok"                                     ,    "scala-js-momentjs"                     , version.scalajsMoment              )
    val                   bindingJs   = djs(   "org.denigma"                                         ,    "binding"                               , version.scalaJsBinding             )
    val                 scaladgetjs   = djs(   "fr.iscpif"                                           ,    "scaladget"                             , version.scaladget                  )
    val                 reactocomps   = djs(   "com.github.chandu0101.scalajs-react-components"      ,    "core"                                  , version.reactComps                 )
    val                fontAwesomeP   = djsp(   "org.webjars"                                         ,    "font-awesome"                          , version.fa, "Provided"                   )
    val                   bootsrapP   = djsp(   "org.webjars"                                         ,    "bootstrap"                             , version.bootstrap, "Provided"            )

  }

  private object version {

    val                       slf4s   =        "1.7.12"
    val                       log4j   =        "2.3"
    val                   scalaTest   =        "3.0.0-M15"
    val                   scalaMock   =        "3.2.2"
    val                     mockito   =        "1.10.19"
    val                        akka   =        "2.4.3"
    val                        kryo   =        "0.4.1"
    val                scalaJsReact   =        "0.11.0"
    val                    scalaCss   =        "0.4.1"
    val                       diode   =        "0.5.1"
    val                     upickle   =        "0.3.9"
    val                   scalatags   =        "0.4.6"
    val                     reactJs   =        "15.0.1"
    val                       scopt   =        "3.3.0"
    val                     monocle   =        "1.2.0"
    val                      scalaz   =        "7.2.1"
    val                      monifu   =        "1.1"
    val                       monix   =        "2.0-M2"
    val                          d3   =        "3.5.5-1"
    val                          fa   =        "4.3.0-1"
    val                sjsbootstrap   =        "1.0.1"
    val                       scala   =        "2.11.8"
    val                    scalaDom   =        "0.9.0"
    val                scalajsReact   =        "0.10.4"
    val                    scalaCSS   =        "0.3.1"
    val                      log4js   =        "1.4.10"
    val                    autowire   =        "0.2.5"
    val                   booPickle   =        "1.1.2"
    val                       uTest   =        "0.3.1"
    val                       react   =        "0.14.7"
    val                  reactComps   =        "0.4.1"
    val                      jQuery   =        "1.11.1"
    val                   bootstrap   =        "3.3.2"
    val                     chartjs   =        "1.0.1"
    val                 playScripts   =        "0.4.0"
    val              scalaJsBinding   =        "0.8.2"
    val                   scaladget   =        "0.7.0"
    val                    paradise   =        "2.1.0"
    val                   cassandra   =        "0.11"
    val                    inmemory   =        "1.2.11"
    val                    momentjs   =        "0.1.4"
    val                  scalajsDom   =        "0.9.0"
    val                    slogging   =        "0.3"
    val               scalajsJquery   =        "0.9.0"
    val                   scalajsD3   =        "0.3.1"
    val                scalaJsVideo   =        "1.0.2"
    val               scalajsMarked   =        "1.0.1"
    val               scalajsMoment   =        "0.1.4"
    val                    scalaxml   =        "1.0.5"
    val                   parboiled   =        "2.1.1-SNAPSHOT"
    val                   shapeless   =        "2.2.5"
    val                   webjarloc   =        "0.23"
    val                     prickle   =        "1.1.5"
    val                     element   =        "0.5.3"
    val                     materui   =        "0.14.4"
    val                      radium   =        "0.16.6"
    val                  classnames   =        "2.2.0"
    val                         rjs   =        "2.1.19"
  }


}