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

  trait AwkwardlyWrapsScalaJsDependenciesSoYouCanAggregateThem {
    def toDef(): Def.SettingsDefinition
  }
  
  case class Sjs(org: String, sjsartifact: String, v: String) extends AwkwardlyWrapsScalaJsDependenciesSoYouCanAggregateThem {
    override def toDef(): Def.SettingsDefinition = Def.SettingsDefinition.wrapSettingsDefinition(
      libraryDependencies += org %%% sjsartifact % v
    )
    
    def +(sjs: Sjs) = Sjses(this, sjs)
  }
  
  case class Sjses(sjs: Sjs*) extends AwkwardlyWrapsScalaJsDependenciesSoYouCanAggregateThem {
    override def toDef(): Def.SettingsDefinition = Def.SettingsDefinition.wrapSettingsDefinition(
      libraryDependencies ++= sjs.map { s ⇒
          s.org %%% s.sjsartifact % s.v
      }
    )
    
    def ++(eses: Sjs*) = Sjses((this.sjs.toSeq ++ eses.toSeq):_*)
  }
  
  object JsDependencies {

    val                   jsprickle   = Sjs(  "com.github.benhutchison"                              ,   "prickle"                                , version.prickle                    )
    val                  jboopickle   = Sjs(   "me.chrons"                                           ,    "boopickle"                             , version.booPickle                  )
    val                    autowire   = Sjs(   "com.lihaoyi"                                         ,    "autowire"                              , version.autowire                   )
    val                    upickler   = Sjs(   "com.lihaoyi"                                         ,    "upickle"                               , version.upickle                    )
    val                      zzzzzz   = Sjs(   "org.scalaz"                                          ,    "scalaz-core"                           , version.scalaz                     )
    val                    monocle1   = Sjs(   "com.github.japgolly.fork.monocle"                    ,    "monocle-core"                          , version.monocle                    )
    val                    monocle2   = Sjs(   "com.github.japgolly.fork.monocle"                    ,    "monocle-macro"                         , version.monocle                    )
    val                       monix   = Sjs(   "io.monix"                                            ,    "monix-reactive"                        , version.monix                      )
    val                   shapeless   = Sjs(   "com.chuusai"                                         ,    "shapeless"                             , version.shapeless                  )
    val                  parboiled2   = Sjs(   "com.github.karasiq"                                  ,    "parboiled"                             , version.parboiled                  )
    val                         dom   = Sjs(   "org.scala-js"                                        ,    "scalajs-dom"                           , version.scalajsDom                 )
    val                   scalatags   = Sjs(   "com.lihaoyi"                                         ,    "scalatags"                             , version.scalatags                  )
    val                    slogging   = Sjs(   "biz.enef"                                            ,    "slogging"                              , version.slogging                   )
    val                       diode   = Sjs(   "me.chrons"                                           ,    "diode"                                 , version.diode                      )
    val                  diodereact   = Sjs(   "me.chrons"                                           ,    "diode-react"                           , version.diode                      )
    val               scalajsJquery   = Sjs(   "be.doeraene"                                         ,    "scalajs-jquery"                        , version.scalajsJquery              )
    val                          d3   = Sjs(   "org.singlespaced"                                    ,    "scalajs-d3"                            , version.scalajsD3                  )
    val                  scalaReact   = Sjs(   "com.github.japgolly.scalajs-react"                   ,    "core"                                  , version.scalaJsReact               )
    val             scalaReactExtra   = Sjs(   "com.github.japgolly.scalajs-react"                   ,    "extra"                                 , version.scalaJsReact               )
    val                scalaReact72   = Sjs(   "com.github.japgolly.scalajs-react"                   ,    "ext-scalaz72"                          , version.scalaJsReact               )
    val              scalaReactExtm   = Sjs(   "com.github.japgolly.scalajs-react"                   ,    "ext-monocle"                           , version.scalaJsReact               )
    val                scalaCssCore   = Sjs(   "com.github.japgolly.scalacss"                        ,    "core"                                  , version.scalaCss                   )
    val                scalaCssExtR   = Sjs(   "com.github.japgolly.scalacss"                        ,    "ext-react"                             , version.scalaCss                   )
    val                     videojs   = Sjs(   "com.github.karasiq"                                  ,    "scalajs-videojs"                       , version.scalaJsVideo               )
    val                    markeSjs   = Sjs(   "com.github.karasiq"                                  ,    "scalajs-marked"                        , version.scalajsMarked              )
    val                    momentjs   = Sjs(   "io.github.widok"                                     ,    "scala-js-momentjs"                     , version.scalajsMoment              )
    val                   bindingJs   = Sjs(   "org.denigma"                                         ,    "binding"                               , version.scalaJsBinding             )
    val                 scaladgetjs   = Sjs(   "fr.iscpif"                                           ,    "scaladget"                             , version.scaladget                  )
    val                 reactocomps   = Sjs(   "com.github.chandu0101.scalajs-react-components"      ,    "core"                                  , version.reactComps                 )
    
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