lazy val codegen = taskKey[Unit]("generate database code")
lazy val codegenClass = "slick.codegen.SourceCodeGenerator"
val system_lib = (project in file(projects.systemLib))
  .enablePlugins(ParadoxPlugin)
  .enablePlugins(ProtobufPlugin)
  .settings(Seq(
    organization := projects.org,
    version := versions.project,
    scalaVersion := versions.scala
  ),
    name := projects.systemLib,
    libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.5.0",
    libraryDependencies += "com.typesafe" % "config" % "1.3.2",
    libraryDependencies += "com.typesafe.akka" %% "akka-stream-kafka" % "0.22",
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
    libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
    libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.3",
    libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.2",
    libraryDependencies += "org.postgresql" % "postgresql" % "42.2.5",
    libraryDependencies ++= Seq(
      "com.typesafe.slick" %% "slick" % versions.slick,
      "com.typesafe.slick" %% "slick-hikaricp" % versions.slick,
      "com.typesafe.slick" %% "slick-testkit" % versions.slick % "test",
      "com.typesafe.slick" %% "slick-codegen" % versions.slick
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
      "org.apache.hive" % "hive-exec" % "3.1.0",
      "org.apache.zookeeper" % "zookeeper" % "3.4.6" pomOnly()
    ).map(_.excludeAll(ExclusionRule(organization = "org.slf4j"))).map(_.excludeAll(ExclusionRule(organization = "org.apache.logging.log4j"))),
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % versions.akkaHttp,
      "com.typesafe.akka" %% "akka-http-spray-json" % versions.akkaHttp,
      "com.typesafe.akka" %% "akka-http-xml" % versions.akkaHttp,
      "com.typesafe.akka" %% "akka-http-testkit" % versions.akkaHttp % Test,
    ),
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-stream" % versions.akka,
      "com.typesafe.akka" %% "akka-persistence" % versions.akka,
      "com.typesafe.akka" %% "akka-testkit" % versions.akka % Test,
      "com.typesafe.akka" %% "akka-stream-testkit" % versions.akka % Test
    ),
    libraryDependencies += "com.alipay.sdk" % "alipay-sdk-java" % "3.4.49.ALL",
    libraryDependencies += "com.github.finagle" %% "finch-json4s" % "0.23.0",
    libraryDependencies += "com.twitter" %% "util-collection" % "18.11.0",
    libraryDependencies += "io.lettuce" % "lettuce-core" % "5.1.6.RELEASE",
    libraryDependencies += "org.typelevel" %% "cats-core" % "1.4.0",
    libraryDependencies += "com.rabbitmq" % "amqp-client" % "5.5.2",
    libraryDependencies += "org.scalaz.stream" %% "scalaz-stream" % "0.8.6",
    libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % versions.scalaz,
      "org.scalaz" %% "scalaz-effect" % versions.scalaz,
      "org.scalaz" %% "scalaz-concurrent" % versions.scalaz,
      "org.scalaz" %% "scalaz-scalacheck-binding" % "7.2.26-scalacheck-1.14" % Test
    ),
    libraryDependencies += "org.quartz-scheduler" % "quartz" % "2.3.0",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % Test,
    libraryDependencies += "io.etcd" % "jetcd-core" % "0.3.0",
    
  )
val system_estate = (project in file(projects.systemEstate)).settings(
  Seq(
  organization := projects.org,
  version := versions.project,
  scalaVersion := versions.scala
),
  name := projects.systemEstate,
  libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.5.0",
  libraryDependencies += "com.typesafe" % "config" % "1.3.2",
  libraryDependencies += "com.typesafe.akka" %% "akka-stream-kafka" % "0.22",
  libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
  libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
  libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.3",
  libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.2",
  libraryDependencies += "org.postgresql" % "postgresql" % "42.2.5",
  libraryDependencies ++= Seq(
    "com.typesafe.slick" %% "slick" % versions.slick,
    "com.typesafe.slick" %% "slick-hikaricp" % versions.slick,
    "com.typesafe.slick" %% "slick-testkit" % versions.slick % "test",
    "com.typesafe.slick" %% "slick-codegen" % versions.slick
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
    "org.apache.hive" % "hive-exec" % "3.1.0",
    "org.apache.zookeeper" % "zookeeper" % "3.4.6" pomOnly()
  ).map(_.excludeAll(ExclusionRule(organization = "org.slf4j"))).map(_.excludeAll(ExclusionRule(organization = "org.apache.logging.log4j"))),
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-http" % versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-spray-json" % versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-xml" % versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-testkit" % versions.akkaHttp % Test,
  ),
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-stream" % versions.akka,
    "com.typesafe.akka" %% "akka-persistence" % versions.akka,
    "com.typesafe.akka" %% "akka-testkit" % versions.akka % Test,
    "com.typesafe.akka" %% "akka-stream-testkit" % versions.akka % Test
  ),
  libraryDependencies += "com.alipay.sdk" % "alipay-sdk-java" % "3.4.49.ALL",
  libraryDependencies += "com.github.finagle" %% "finch-json4s" % "0.23.0",
  libraryDependencies += "com.twitter" %% "util-collection" % "18.11.0",
  libraryDependencies += "io.lettuce" % "lettuce-core" % "5.1.6.RELEASE",
  libraryDependencies += "org.typelevel" %% "cats-core" % "1.4.0",
  libraryDependencies += "com.rabbitmq" % "amqp-client" % "5.5.2",
  libraryDependencies += "org.scalaz.stream" %% "scalaz-stream" % "0.8.6",
  libraryDependencies ++= Seq(
    "org.scalaz" %% "scalaz-core" % versions.scalaz,
    "org.scalaz" %% "scalaz-effect" % versions.scalaz,
    "org.scalaz" %% "scalaz-concurrent" % versions.scalaz,
    "org.scalaz" %% "scalaz-scalacheck-binding" % "7.2.26-scalacheck-1.14" % Test
  ),
  libraryDependencies += "org.quartz-scheduler" % "quartz" % "2.3.0",
).dependsOn(system_lib)

val system_agency = (project in file(projects.systemAgency))
  .enablePlugins(ParadoxPlugin)
  .enablePlugins(ProtobufPlugin)
  .enablePlugins(JavaAppPackaging, DockerPlugin)
  .settings(
    Seq(
      organization := projects.org,
      version := versions.project,
      scalaVersion := versions.scala
    ),
    name := projects.systemAgency,
    libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.5.0",
    libraryDependencies += "com.typesafe" % "config" % "1.3.2",
    libraryDependencies += "com.typesafe.akka" %% "akka-stream-kafka" % "0.22",
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
    libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
    libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.3",
    libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.2",
    libraryDependencies += "org.postgresql" % "postgresql" % "42.2.5",
    libraryDependencies ++= Seq(
      "com.typesafe.slick" %% "slick" % versions.slick,
      "com.typesafe.slick" %% "slick-hikaricp" % versions.slick,
      "com.typesafe.slick" %% "slick-testkit" % versions.slick % "test",
      "com.typesafe.slick" %% "slick-codegen" % versions.slick
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
      "com.typesafe.akka" %% "akka-http" % versions.akkaHttp,
      "com.typesafe.akka" %% "akka-http-spray-json" % versions.akkaHttp,
      "com.typesafe.akka" %% "akka-http-xml" % versions.akkaHttp,
      "com.typesafe.akka" %% "akka-http-testkit" % versions.akkaHttp % Test,
    ),
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-stream" % versions.akka,
      "com.typesafe.akka" %% "akka-persistence" % versions.akka,
      "com.typesafe.akka" %% "akka-testkit" % versions.akka % Test,
      "com.typesafe.akka" %% "akka-stream-testkit" % versions.akka % Test
    ),
    libraryDependencies += "com.alipay.sdk" % "alipay-sdk-java" % "3.4.49.ALL",
    libraryDependencies += "com.github.finagle" %% "finch-json4s" % "0.23.0",
    libraryDependencies += "com.twitter" %% "util-collection" % "18.11.0",
    libraryDependencies += "io.lettuce" % "lettuce-core" % "5.1.6.RELEASE",
    libraryDependencies += "org.typelevel" %% "cats-core" % "1.4.0",
    libraryDependencies += "com.rabbitmq" % "amqp-client" % "5.5.2",
    libraryDependencies += "org.scalaz.stream" %% "scalaz-stream" % "0.8.6",
    libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % versions.scalaz,
      "org.scalaz" %% "scalaz-effect" % versions.scalaz,
      "org.scalaz" %% "scalaz-concurrent" % versions.scalaz,
      "org.scalaz" %% "scalaz-scalacheck-binding" % "7.2.26-scalacheck-1.14" % Test
    ),
    libraryDependencies += "org.quartz-scheduler" % "quartz" % "2.3.0",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % Test
  )

val system_analysis = (project in file(projects.systemAnalysis)).settings(Seq(
  organization := projects.org,
  version := versions.project,
  scalaVersion := versions.scala
),
  name := projects.systemAnalysis,
  libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.5.0",
  libraryDependencies += "com.typesafe" % "config" % "1.3.2",
  libraryDependencies += "com.typesafe.akka" %% "akka-stream-kafka" % "0.22",
  libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
  libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
  libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.3",
  libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.2",
  libraryDependencies += "org.postgresql" % "postgresql" % "42.2.5",
  libraryDependencies ++= Seq(
    "com.typesafe.slick" %% "slick" % versions.slick,
    "com.typesafe.slick" %% "slick-hikaricp" % versions.slick,
    "com.typesafe.slick" %% "slick-testkit" % versions.slick % "test",
    "com.typesafe.slick" %% "slick-codegen" % versions.slick
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
    "org.apache.hive" % "hive-exec" % "3.1.0",
    "org.apache.zookeeper" % "zookeeper" % "3.4.6" pomOnly()
  ).map(_.excludeAll(ExclusionRule(organization = "org.slf4j"))).map(_.excludeAll(ExclusionRule(organization = "org.apache.logging.log4j"))),
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-http" % versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-spray-json" % versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-xml" % versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-testkit" % versions.akkaHttp % Test,
  ),
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-stream" % versions.akka,
    "com.typesafe.akka" %% "akka-persistence" % versions.akka,
    "com.typesafe.akka" %% "akka-testkit" % versions.akka % Test,
    "com.typesafe.akka" %% "akka-stream-testkit" % versions.akka % Test
  ),
  libraryDependencies += "com.github.finagle" %% "finch-json4s" % "0.23.0",
  libraryDependencies += "com.twitter" %% "util-collection" % "18.11.0",
  libraryDependencies += "io.lettuce" % "lettuce-core" % "5.1.6.RELEASE",
  libraryDependencies += "org.typelevel" %% "cats-core" % "1.4.0",
  libraryDependencies += "com.rabbitmq" % "amqp-client" % "5.5.2",
  libraryDependencies += "org.scalaz.stream" %% "scalaz-stream" % "0.8.6",
  libraryDependencies ++= Seq(
    "org.scalaz" %% "scalaz-core" % versions.scalaz,
    "org.scalaz" %% "scalaz-effect" % versions.scalaz,
    "org.scalaz" %% "scalaz-concurrent" % versions.scalaz,
    "org.scalaz" %% "scalaz-scalacheck-binding" % "7.2.26-scalacheck-1.14" % Test
  ),
  libraryDependencies += "org.quartz-scheduler" % "quartz" % "2.3.0",
)
val system_liquid = (project in file(projects.systemLiquid)).settings(Seq(
  organization := projects.org,
  version := versions.project,
  scalaVersion := versions.scala
),
  name := projects.systemLiquid,
  libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.5.0",
  libraryDependencies += "com.typesafe" % "config" % "1.3.2",
  libraryDependencies += "com.typesafe.akka" %% "akka-stream-kafka" % "0.22",
  libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
  libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
  libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.3",
  libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.2",
  libraryDependencies += "org.postgresql" % "postgresql" % "42.2.5",
  libraryDependencies ++= Seq(
    "com.typesafe.slick" %% "slick" % versions.slick,
    "com.typesafe.slick" %% "slick-hikaricp" % versions.slick,
    "com.typesafe.slick" %% "slick-testkit" % versions.slick % "test",
    "com.typesafe.slick" %% "slick-codegen" % versions.slick
  ),
  libraryDependencies += "javax.mail" % "mail" % "1.4.7",
  libraryDependencies += "com.google.guava" % "guava" % "23.0",
  libraryDependencies += "joda-time" % "joda-time" % "2.9.9",
  libraryDependencies += "org.joda" % "joda-convert" % "2.1.1",
  libraryDependencies += "com.google.inject" % "guice" % "3.0",
  libraryDependencies += "com.auth0" % "java-jwt" % "3.4.0",
  libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.25",
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-http" % versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-spray-json" % versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-xml" % versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-testkit" % versions.akkaHttp % Test,
  ),
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-stream" % versions.akka,
    "com.typesafe.akka" %% "akka-persistence" % versions.akka,
    "com.typesafe.akka" %% "akka-testkit" % versions.akka % Test,
    "com.typesafe.akka" %% "akka-stream-testkit" % versions.akka % Test
  ),
  libraryDependencies += "com.alipay.sdk" % "alipay-sdk-java" % "3.4.49.ALL",
  libraryDependencies += "com.github.finagle" %% "finch-json4s" % "0.23.0",
  libraryDependencies += "com.twitter" %% "util-collection" % "18.11.0",
  libraryDependencies += "io.lettuce" % "lettuce-core" % "5.1.6.RELEASE",
  libraryDependencies += "org.typelevel" %% "cats-core" % "1.4.0",
  libraryDependencies += "com.rabbitmq" % "amqp-client" % "5.5.2",
  libraryDependencies += "org.scalaz.stream" %% "scalaz-stream" % "0.8.6",
  libraryDependencies ++= Seq(
    "org.scalaz" %% "scalaz-core" % versions.scalaz,
    "org.scalaz" %% "scalaz-effect" % versions.scalaz,
    "org.scalaz" %% "scalaz-concurrent" % versions.scalaz,
    "org.scalaz" %% "scalaz-scalacheck-binding" % "7.2.26-scalacheck-1.14" % Test
  ),
  libraryDependencies += "org.quartz-scheduler" % "quartz" % "2.3.0",
)
val system_order = (project in file(projects.systemOrder)).settings(Seq(
  organization := projects.org,
  version := versions.project,
  scalaVersion := versions.scala
),
  name := projects.systemOrder,
  libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.5.0",
  libraryDependencies += "com.typesafe" % "config" % "1.3.2",
  libraryDependencies += "com.typesafe.akka" %% "akka-stream-kafka" % "0.22",
  libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
  libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
  libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.3",
  libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.2",
  libraryDependencies += "org.postgresql" % "postgresql" % "42.2.5",
  libraryDependencies ++= Seq(
    "com.typesafe.slick" %% "slick" % versions.slick,
    "com.typesafe.slick" %% "slick-hikaricp" % versions.slick,
    "com.typesafe.slick" %% "slick-testkit" % versions.slick % "test",
    "com.typesafe.slick" %% "slick-codegen" % versions.slick
  ),
  libraryDependencies += "javax.mail" % "mail" % "1.4.7",
  libraryDependencies += "com.google.guava" % "guava" % "23.0",
  libraryDependencies += "joda-time" % "joda-time" % "2.9.9",
  libraryDependencies += "org.joda" % "joda-convert" % "2.1.1",
  libraryDependencies += "com.google.inject" % "guice" % "3.0",
  libraryDependencies += "com.auth0" % "java-jwt" % "3.4.0",
  libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.25",
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-http" % versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-spray-json" % versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-xml" % versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-testkit" % versions.akkaHttp % Test,
  ),
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-stream" % versions.akka,
    "com.typesafe.akka" %% "akka-persistence" % versions.akka,
    "com.typesafe.akka" %% "akka-testkit" % versions.akka % Test,
    "com.typesafe.akka" %% "akka-stream-testkit" % versions.akka % Test
  ),
  libraryDependencies += "com.github.finagle" %% "finch-json4s" % "0.23.0",
  libraryDependencies += "com.twitter" %% "util-collection" % "18.11.0",
  libraryDependencies += "io.lettuce" % "lettuce-core" % "5.1.6.RELEASE",
  libraryDependencies += "org.typelevel" %% "cats-core" % "1.4.0",
  libraryDependencies += "com.rabbitmq" % "amqp-client" % "5.5.2",
  libraryDependencies += "org.scalaz.stream" %% "scalaz-stream" % "0.8.6",
  libraryDependencies ++= Seq(
    "org.scalaz" %% "scalaz-core" % versions.scalaz,
    "org.scalaz" %% "scalaz-effect" % versions.scalaz,
    "org.scalaz" %% "scalaz-concurrent" % versions.scalaz,
    "org.scalaz" %% "scalaz-scalacheck-binding" % "7.2.26-scalacheck-1.14" % Test
  ),
  libraryDependencies += "org.quartz-scheduler" % "quartz" % "2.3.0",
)
val system_push = (project in file(projects.systemPush)).settings(Seq(
  organization := projects.org,
  version := versions.project,
  scalaVersion := versions.scala
),
  name := projects.systemPush,
  libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.5.0",
  libraryDependencies += "com.typesafe" % "config" % "1.3.2",
  libraryDependencies += "com.typesafe.akka" %% "akka-stream-kafka" % "0.22",
  libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
  libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
  libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.3",
  libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.2",
  libraryDependencies += "org.postgresql" % "postgresql" % "42.2.5",
  libraryDependencies ++= Seq(
    "com.typesafe.slick" %% "slick" % versions.slick,
    "com.typesafe.slick" %% "slick-hikaricp" % versions.slick,
    "com.typesafe.slick" %% "slick-testkit" % versions.slick % "test",
    "com.typesafe.slick" %% "slick-codegen" % versions.slick
  ),
  libraryDependencies += "javax.mail" % "mail" % "1.4.7",
  libraryDependencies += "com.google.guava" % "guava" % "23.0",
  libraryDependencies += "joda-time" % "joda-time" % "2.9.9",
  libraryDependencies += "org.joda" % "joda-convert" % "2.1.1",
  libraryDependencies += "com.google.inject" % "guice" % "3.0",
  libraryDependencies += "com.auth0" % "java-jwt" % "3.4.0",
  libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.25",
  libraryDependencies ++= Seq(
    "org.apache.hbase" % "hbase-client" % "1.4.7",
    "org.apache.hive" % "hive-exec" % "3.1.0",
    "org.apache.zookeeper" % "zookeeper" % "3.4.6" pomOnly()
  ).map(_.excludeAll(ExclusionRule(organization = "org.slf4j"))).map(_.excludeAll(ExclusionRule(organization = "org.apache.logging.log4j"))),
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-http" % versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-spray-json" % versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-xml" % versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-testkit" % versions.akkaHttp % Test,
  ),
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-stream" % versions.akka,
    "com.typesafe.akka" %% "akka-persistence" % versions.akka,
    "com.typesafe.akka" %% "akka-testkit" % versions.akka % Test,
    "com.typesafe.akka" %% "akka-stream-testkit" % versions.akka % Test
  ),
  libraryDependencies += "com.aliyun" % "aliyun-java-sdk-push" % "3.9.0",
  libraryDependencies += "com.github.finagle" %% "finch-json4s" % "0.23.0",
  libraryDependencies += "com.twitter" %% "util-collection" % "18.11.0",
  libraryDependencies += "io.lettuce" % "lettuce-core" % "5.1.6.RELEASE",
  libraryDependencies += "org.typelevel" %% "cats-core" % "1.4.0",
  libraryDependencies += "com.rabbitmq" % "amqp-client" % "5.5.2",
  libraryDependencies += "org.scalaz.stream" %% "scalaz-stream" % "0.8.6",
  libraryDependencies ++= Seq(
    "org.scalaz" %% "scalaz-core" % versions.scalaz,
    "org.scalaz" %% "scalaz-effect" % versions.scalaz,
    "org.scalaz" %% "scalaz-concurrent" % versions.scalaz,
    "org.scalaz" %% "scalaz-scalacheck-binding" % "7.2.26-scalacheck-1.14" % Test
  ),
  libraryDependencies += "org.quartz-scheduler" % "quartz" % "2.3.0",
)

lazy val system_account = (project in file(projects.systemAccount))
  .enablePlugins(ParadoxPlugin)
  .enablePlugins(ProtobufPlugin)
  .enablePlugins(JavaAppPackaging, DockerPlugin)
  .settings(
    Seq(
      organization := projects.org,
      version := versions.project,
      scalaVersion := versions.scala
    ),
    name := projects.systemAccount,
    libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.5.0",
    libraryDependencies += "com.typesafe" % "config" % "1.3.2",
    libraryDependencies += "com.typesafe.akka" %% "akka-stream-kafka" % "0.22",
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
    libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
    libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.3",
    libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.2",
    libraryDependencies += "org.postgresql" % "postgresql" % "42.2.5",
    libraryDependencies ++= Seq(
      "com.typesafe.slick" %% "slick" % versions.slick,
      "com.typesafe.slick" %% "slick-hikaricp" % versions.slick,
      "com.typesafe.slick" %% "slick-testkit" % versions.slick % "test",
      "com.typesafe.slick" %% "slick-codegen" % versions.slick
    ),
    libraryDependencies += "javax.mail" % "mail" % "1.4.7",
    libraryDependencies += "com.google.guava" % "guava" % "23.0",
    libraryDependencies += "joda-time" % "joda-time" % "2.9.9",
    libraryDependencies += "org.joda" % "joda-convert" % "2.1.1",
    libraryDependencies += "com.google.inject" % "guice" % "3.0",
    libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.25",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % versions.akkaHttp,
      "com.typesafe.akka" %% "akka-http-spray-json" % versions.akkaHttp,
      "com.typesafe.akka" %% "akka-http-xml" % versions.akkaHttp,
      "com.typesafe.akka" %% "akka-http-testkit" % versions.akkaHttp % Test,
    ),
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-stream" % versions.akka,
      "com.typesafe.akka" %% "akka-persistence" % versions.akka,
      "com.typesafe.akka" %% "akka-testkit" % versions.akka % Test,
      "com.typesafe.akka" %% "akka-stream-testkit" % versions.akka % Test
    ),
    libraryDependencies += "com.github.finagle" %% "finch-json4s" % "0.23.0",
    libraryDependencies += "com.twitter" %% "util-collection" % "18.11.0",
    libraryDependencies += "io.lettuce" % "lettuce-core" % "5.1.6.RELEASE",
    libraryDependencies += "org.typelevel" %% "cats-core" % "1.4.0",
    libraryDependencies += "com.rabbitmq" % "amqp-client" % "5.5.2",
    libraryDependencies += "org.scalaz.stream" %% "scalaz-stream" % "0.8.6",
    libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % versions.scalaz,
      "org.scalaz" %% "scalaz-effect" % versions.scalaz,
      "org.scalaz" %% "scalaz-concurrent" % versions.scalaz,
      "org.scalaz" %% "scalaz-scalacheck-binding" % "7.2.26-scalacheck-1.14" % Test
    ),
    libraryDependencies += "org.quartz-scheduler" % "quartz" % "2.3.0",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % Test,
    codegen := Def.task {
      val (dir, cp, r, s) = (sourceManaged.value, (dependencyClasspath in Compile).value, (runner in Compile).value, streams.value)
      r.run(codegenClass, cp.files, Array("slick.jdbc.PostgresProfile", "org.postgresql.Driver", "jdbc:postgresql://120.26.57.78:5432/system_account", s"${projects.systemAccount}/src/main/scala", s"${projects.org}.account.models.codegen", "postgres", "zhuyan", "true", codegenClass, "true"), s.log)
    }.value
  ).dependsOn(system_lib)


val system_track = (project in file(projects.systemTrack))
  .settings(Seq(
    organization := projects.org,
    version := versions.project,
    scalaVersion := versions.scala
  ),
    name := projects.systemTrack,
    libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.5.0",
    libraryDependencies += "com.typesafe" % "config" % "1.3.2",
    libraryDependencies += "com.typesafe.akka" %% "akka-stream-kafka" % "0.22",
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
    libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
    libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.3",
    libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.2",
    libraryDependencies += "org.postgresql" % "postgresql" % "42.2.5",
    libraryDependencies += "com.google.guava" % "guava" % "23.0",
    libraryDependencies += "joda-time" % "joda-time" % "2.9.9",
    libraryDependencies += "org.joda" % "joda-convert" % "2.1.1",
    libraryDependencies += "com.google.inject" % "guice" % "3.0",
    libraryDependencies ++= Seq(
      "org.apache.hbase" % "hbase-client" % "1.4.7",
      //    "org.apache.hadoop" % "hadoop-common" % "3.1.1",
      "org.apache.hive" % "hive-exec" % "3.1.0"
    ).map(_.excludeAll(ExclusionRule(organization = "org.slf4j"))).map(_.excludeAll(ExclusionRule(organization = "org.apache.logging.log4j"))),
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % versions.akkaHttp,
      "com.typesafe.akka" %% "akka-http-spray-json" % versions.akkaHttp,
      "com.typesafe.akka" %% "akka-http-xml" % versions.akkaHttp,
      "com.typesafe.akka" %% "akka-http-testkit" % versions.akkaHttp % Test,
    ),
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-stream" % versions.akka,
      "com.typesafe.akka" %% "akka-persistence" % versions.akka,
      "com.typesafe.akka" %% "akka-testkit" % versions.akka % Test,
      "com.typesafe.akka" %% "akka-stream-testkit" % versions.akka % Test
    ),
    libraryDependencies += "com.github.finagle" %% "finch-json4s" % "0.23.0",
    libraryDependencies += "com.twitter" %% "util-collection" % "18.11.0",
    libraryDependencies += "io.lettuce" % "lettuce-core" % "5.1.6.RELEASE",
    libraryDependencies += "org.typelevel" %% "cats-core" % "1.4.0",
    libraryDependencies += "com.rabbitmq" % "amqp-client" % "5.5.2",
    libraryDependencies += "org.scalaz.stream" %% "scalaz-stream" % "0.8.6",
    libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % versions.scalaz,
      "org.scalaz" %% "scalaz-effect" % versions.scalaz,
      "org.scalaz" %% "scalaz-concurrent" % versions.scalaz,
      "org.scalaz" %% "scalaz-scalacheck-binding" % "7.2.26-scalacheck-1.14" % Test
    ),
    libraryDependencies += "org.quartz-scheduler" % "quartz" % "2.3.0",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % Test,
  ).dependsOn(system_lib)


val system_task = (project in file(projects.systemTask)).settings(Seq(
  organization := projects.org,
  version := versions.project,
  scalaVersion := versions.scala
),
  name := projects.systemTask
)

lazy val remix = (project in file(".")).settings(
  name := "remix",
  codegen := Def.task {}.value
)