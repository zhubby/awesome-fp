package com.github.ultramans.remix.track.actors

import akka.actor._
import com.github.ultramans.remix.lib.models.track.HttpRequestTrack
import com.google.common.base.CaseFormat
import com.github.ultramans.remix.track.ApplicationSystem._

class KeepTrackingActor extends Actor with ActorLogging {
  override def receive: Receive = {
    case t@HttpRequestTrack => println(t)
  }
}


object KeepTrackingActor {
  lazy val ref: ActorRef = system.actorOf(Props[KeepTrackingActor], CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, classOf[KeepTrackingActor].getSimpleName))
}