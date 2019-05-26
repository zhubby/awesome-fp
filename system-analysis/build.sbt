val akkaHttpVersion = "10.1.8"
val akkaVersion = "2.5.19"
val slickVersion = "3.3.0"
val scalazVersion = "7.2.26"

lazy val system_analysis = (project in file("."))
  .enablePlugins(ParadoxPlugin)
  .enablePlugins(ProtobufPlugin)
  .enablePlugins(JavaAppPackaging, DockerPlugin)
  .settings(
    Seq(
      organization := "com.github.ultramans.remix.analysis",
      version := "1.0.0",
      scalaVersion := "2.12.8"
    ),
    name := "system-analysis",
    libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.5.0",
    libraryDependencies += "com.typesafe" % "config" % "1.3.2",
    libraryDependencies += "com.typesafe.akka" %% "akka-stream-kafka" % "0.22",
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
    libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
    libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.3",
    libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.2",
    libraryDependencies += "org.postgresql" % "postgresql" % "42.2.5",
    libraryDependencies ++= Seq(
      "com.typesafe.slick" %% "slick" % slickVersion,
      "com.typesafe.slick" %% "slick-hikaricp" % slickVersion,
      "com.typesafe.slick" %% "slick-testkit" % slickVersion % "test",
      "com.typesafe.slick" %% "slick-codegen" % slickVersion
    ),
    libraryDependencies += "org.elasticsearch.client" % "elasticsearch-rest-high-level-client" % "5.6.8",
    libraryDependencies += "javax.mail" % "mail" % "1.4.7",
    libraryDependencies += "com.google.guava" % "guava" % "23.0",
    libraryDependencies += "joda-time" % "joda-time" % "2.9.9",
    libraryDependencies += "org.joda" % "joda-convert" % "2.1.1",
    libraryDependencies += "com.google.inject" % "guice" % "3.0",
    libraryDependencies += "com.auth0" % "java-jwt" % "3.4.0",
    libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.25",
    libraryDependencies ++= Seq(
      "org.apache.hbase" % "hbase-client" % "1.4.7",
      //    "org.apache.hadoop" % "hadoop-common" % "3.1.1",
      "org.apache.hive" % "hive-exec" % "3.1.0"
    ).map(_.excludeAll(ExclusionRule(organization = "org.slf4j"))).map(_.excludeAll(ExclusionRule(organization = "org.apache.logging.log4j"))),
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-xml" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream" % akkaVersion,
      "com.typesafe.akka" %% "akka-persistence" % akkaVersion,
      "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
      "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test
    ),
    libraryDependencies += "com.alipay.sdk" % "alipay-sdk-java" % "3.4.49.ALL",
    libraryDependencies += "com.github.finagle" %% "finch-json4s" % "0.23.0",
    libraryDependencies += "com.twitter" %% "util-collection" % "18.11.0",
    libraryDependencies += "io.lettuce" % "lettuce-core" % "5.1.6.RELEASE",
    libraryDependencies += "org.typelevel" %% "cats-core" % "1.4.0",
    libraryDependencies += "com.rabbitmq" % "amqp-client" % "5.5.2",
    libraryDependencies += "org.scalaz.stream" %% "scalaz-stream" % "0.8.6",
    libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % scalazVersion,
      "org.scalaz" %% "scalaz-effect" % scalazVersion,
      "org.scalaz" %% "scalaz-concurrent" % scalazVersion,
      "org.scalaz" %% "scalaz-scalacheck-binding" % "7.2.26-scalacheck-1.14" % Test
    ),
    libraryDependencies += "org.quartz-scheduler" % "quartz" % "2.3.0",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % Test
  )


test in assembly := {}
assemblyJarName in assembly := "system-analysis-assembly-1.0.0.jar"
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", s@_*) => MergeStrategy.discard
  case _ => MergeStrategy.last
}