import scala.collection.Seq

ThisBuild / version := "0.1.0-SNAPSHOT"

version := "1.0"

ThisBuild / scalaVersion := "2.13.15"

lazy val root = (project in file("."))
  .settings(
    name := "auth"
  )

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.2.6",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.2.6",
  "com.typesafe.akka" %% "akka-actor-typed" % "2.8.6"
)
