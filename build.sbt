name := "s3mock"

version := "0.4.0"

organization := "com.hiya"

scalaVersion := "2.13.2"

crossScalaVersions := Seq("2.12.8","2.13.2")

val akkaVersion = "2.6.5"

homepage := Some(url("https://github.com/hiyainc-oss/s3mock"))

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % "10.1.12",
  "org.scala-lang.modules" %% "scala-collection-compat" % "2.1.6",
  "org.scala-lang.modules" %% "scala-xml" % "1.3.0",
  "com.github.pathikrit" %% "better-files" % "3.9.1",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
  "com.amazonaws" % "aws-java-sdk-s3" % "1.11.788",
  "org.scalatest" %% "scalatest" % "3.1.2" % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "test",
  "org.iq80.leveldb" % "leveldb" % "0.12",
  "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % "test",
  "com.typesafe.akka" %% "akka-http-xml" % "10.1.12" % "test",
  "com.lightbend.akka" %% "akka-stream-alpakka-s3" % "2.0.0" % "test"
)

parallelExecution in Test := false


licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "maven"
bintrayOrganization := Some("hiyainc-oss")
bintrayReleaseOnPublish in ThisBuild := false
resolvers += Resolver.bintrayRepo("hiyainc-oss", "maven")
bintrayPackageLabels := Seq("scala", "test", "mock")


enablePlugins(JavaAppPackaging, DockerPlugin)

packageName in Docker := "s3mock"
dockerExposedPorts := Seq(8001)
dockerUsername in Docker := Some("hiya")

