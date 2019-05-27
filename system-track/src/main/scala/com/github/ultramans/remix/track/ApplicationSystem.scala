package com.github.ultramans.remix.track

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContextExecutor

trait ApplicationSystem {
  implicit val system: ActorSystem = ActorSystem("akka-system-track")
  implicit val executor: ExecutionContextExecutor = system.dispatcher
  implicit val materialize: ActorMaterializer = ActorMaterializer()
}


object ApplicationSystem extends ApplicationSystem