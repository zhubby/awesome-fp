package com.github.ultramans.remix.account
import java.nio.file.Paths
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.util.Timeout
import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.duration.Duration
import scala.concurrent.duration._
import akka.Done
import akka.actor.CoordinatedShutdown
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.scaladsl._
import akka.util.ByteString
import com.typesafe.scalalogging.Logger
import com.typesafe.config.ConfigFactory
class RemixAccountTest {

}
