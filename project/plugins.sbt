logLevel := Level.Warn
resolvers += Resolver.bintrayIvyRepo("typesafe", "org.scala-sbt")
resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(Resolver.ivyStylePatterns)
addSbtPlugin("io.spray" % "sbt-revolver" % "0.8.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-multi-jvm" % "0.3.11")
addSbtPlugin("org.madoushi.sbt" % "sbt-sass" % "0.9.3")
addSbtPlugin("com.typesafe.sbt" % "sbt-js-engine" % "1.1.3")
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.8")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.1.0-RC2")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.11.2")
addSbtPlugin("com.github.karasiq" % "sbt-scalajs-bundler" % "1.0.7")
addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.7")
libraryDependencies ++= Seq(
  "com.lihaoyi" %% "scalatags" % "0.5.4",
  "org.webjars.bower" % "marked" % "0.3.5",
  "org.webjars" % "highlightjs" % "9.2.0",
  "com.typesafe" %% "jse" % "1.1.2",
  "com.typesafe" %% "npm" % "1.1.1"

)
