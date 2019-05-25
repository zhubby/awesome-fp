package com.github.ultramans.remix

import java.nio.file.Paths

import akka.Done
import akka.actor.CoordinatedShutdown
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.scaladsl._
import akka.util.ByteString
import com.typesafe.scalalogging.Logger
import com.google.inject._
import com.github.ultramans.influx.modules.api.APIRoute
import com.github.ultramans.influx.modules.analytics.routes._
import com.github.ultramans.influx.commons.jobs.AppScheduler
import com.typesafe.config.ConfigFactory

object RemixApplication {
  private val banner = FileIO.fromPath(Paths.get("src/main/resources/banner.txt")).runWith(Sink.reduce[ByteString](_
    concat _)).map(_.utf8String)
  private val config = ConfigFactory.load()
  private val logger = Logger(this.getClass)
  private val root: Route = pathSingleSlash {
    complete(banner)
  }
  def main(args: Array[String]): Unit = {
    AppScheduler.startJob
    val bind = Http().bindAndHandle(route, config.getString("app.host"), config.getInt("app.port"))
    bind.onComplete {
      _ =>
      {
        banner.map(s => logger.info(s"\r$s"))
        logger.info(s"Akka Http Server at http://${config.getString("app.host")}:${config.getInt("app.port").toString}/")
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
