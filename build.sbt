lazy val appSettings = Seq(
  organization := "org.x4444",
  name := "cs-scala",
  version := "1.1.0"
)

// Those settings should be the same as in alchemy!
lazy val scalaVersion_ = "2.12.1" // should be the same as spark
lazy val javaVersion = "1.8" // should be the same as spark

lazy val scalaTestVersion = "3.0.1"

scalaVersion in Global := scalaVersion_

scalacOptions in Global ++= Seq(
  "-deprecation",
  "-feature",
  "-target:jvm-" + javaVersion,
  "-Xfatal-warnings",
  "-Xlint"
)

javacOptions in Global ++= Seq(
  "-encoding", "UTF-8",
  "-source", javaVersion,
  "-target", javaVersion
)

lazy val auxLib = Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.14"
)

lazy val testLib = Seq(
  "org.scalatest" %% "scalatest" % scalaTestVersion % Test withSources() withJavadoc()
)

lazy val root = (project in file("."))
  .settings(appSettings: _*)
  .settings(
    libraryDependencies ++= auxLib,
    libraryDependencies ++= testLib
  )

