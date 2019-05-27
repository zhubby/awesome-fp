package com.github.ultramans.remix.estate

import java.nio.file.Paths

import akka.Done
import akka.actor.CoordinatedShutdown
import akka.http.scaladsl.Http
import akka.stream.scaladsl.{FileIO, Sink}
import akka.util.ByteString
import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.Logger

object RemixEstateApplication {
  import ApplicationSystem._
  private val banner = FileIO.fromPath(Paths.get("system-account/src/main/resources/banner.txt")).runWith(Sink.reduce[ByteString](_
    concat _)).map(_.utf8String)
  private val configLoader = ConfigFactory.load()
  private val logger = Logger(this.getClass)

  lazy val host = configLoader.getString("http.host")
  lazy val port = configLoader.getInt("http.port")

  def main(args: Array[String]) = {
    val bind = Http().bindAndHandle(routes.aggregateRoutes, host, port)
    bind.onComplete {
      _ => {
        banner.map(s => logger.info(s"\r$s"))
        logger.info(s"Akka Http Server at $host:$port")
      }
    }
    CoordinatedShutdown(system).addTask(
      CoordinatedShutdown.PhaseServiceUnbind, "http_shutdown"
    ) { () =>
      bind.flatMap(_.unbind).flatMap { _ =>
        Http().shutdownAllConnectionPools
      } map { _ =>
        Done
      }
    }
  }
}
