package com.github.ultramans.remix.account.actors

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import com.github.ultramans.remix.account.ApplicationSystem.system
import com.google.common.base.CaseFormat
import com.github.ultramans.remix.account.ApplicationSystem._

class AccountActor extends Actor with ActorLogging {

  import AccountActor._


  override def receive: Receive = {
    case GetSingleAccountAsk(id) => log.info(id.toString)
  }
}


object AccountActor {
  case class GetSingleAccountAsk(id: Int)
  lazy val ref: ActorRef = system.actorOf(Props[AccountActor], CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, classOf[AccountActor].getSimpleName))
}