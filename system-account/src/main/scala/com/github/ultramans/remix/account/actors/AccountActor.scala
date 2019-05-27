package com.github.ultramans.remix.account.actors

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import com.google.common.base.CaseFormat
import com.github.ultramans.remix.account.ApplicationSystem._
import slick.jdbc.MySQLProfile.api._

class AccountActor extends Actor with ActorLogging {

  import AccountActor._
  import com.github.ultramans.remix.account.models.codegen.Tables

  override def receive: Receive = {
    case GetSingleAccountAsk(id) => println(id)
    case row: Tables.AccountRow => {
      sender() ! db.run(Tables.Account returning Tables.Account.map(_.userId) += row)
    }
  }
}


object AccountActor {


  case class GetSingleAccountAsk(id: Int)

  lazy val ref: ActorRef = system.actorOf(Props[AccountActor], CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, classOf[AccountActor].getSimpleName))

  val db = Database.forConfig("postgresql.system_account")
}