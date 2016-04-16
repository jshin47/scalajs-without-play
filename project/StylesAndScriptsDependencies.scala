

object StylesAndScriptsDependencies {


  // THESE ARE HONEST TO GOODNESS REAL JAVASCRIPTS AND CSS AND THE REST. THEY HAVE NOTHING TO DO ITH SCALAJS. REPEAT IT WITH ME
  //
  // THEY HAVE NOTHING TO DO ITH SJS.

  object WebJarDependencies {

    val                 webjarReact   =        "org.webjars.bower"                                   %    "react"                                 % version.react      / "react-with-addons.js"              minified "react-with-addons.min.js"                                     commonJSName "React"
    val                webjarReact2   =        "org.webjars.bower"                                   %    "react"                                 % version.react      / "react-dom.js"                      minified "react-dom.min.js"         dependsOn    "react-with-addons.js" commonJSName "ReactDOM"
    val                    webjarjq   =        "org.webjars"                                         %    "jquery"                                % version.jQuery     / "jquery.js"                         minified "jquery.min.js"
    val                    webjarbs   =        "org.webjars"                                         %    "bootstrap"                             % version.bootstrap  / "bootstrap.js"                      minified "bootstrap.min.js"         dependsOn    "jquery.js"
    val                 webjarchart   =        "org.webjars"                                         %    "chartjs"                               % version.chartjs    / "Chart.js"                          minified "Chart.min.js"
    val                  webjarl4js   =        "org.webjars"                                         %    "log4javascript"                        % version.log4js     / "js/log4javascript_uncompressed.js" minified "js/log4javascript.js"
    val                  webjard3js   =        "org.webjars"                                         %    "d3js"                                  % version.d3         / "d3.js"
    val                  webjarclnm   =        "org.webjars.bower"                                   %    "classnames"                            % version.classnames / s"${version.classnames}/index.js"
    val                  webjarelem   =        "org.webjars.bower"                                   %    "elemental-dist"                        % version.element    / "elemental.js"                     dependsOn "2.2.0/index.js"
    val                         rjs   =        "org.webjars"                                         %    "requirejs"                             % version.rjs        / "require.js"
    //val                  webjarradi   =        "org.webjars.npm"                                     %    "radium"                                % version.radium     / "radium.js"

    def apply() = Seq(webjarl4js, webjarReact2, webjarReact, webjarjq, webjard3js, webjarchart, webjarbs, webjarelem, webjarclnm, rjs)
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