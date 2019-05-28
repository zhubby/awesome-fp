package com.github.ultramans.remix.account.actors

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import com.google.common.base.CaseFormat
import com.github.ultramans.remix.account.ApplicationSystem._
import slick.jdbc.PostgresProfile.api._
import com.github.ultramans.remix.account.models.codegen.Tables._

class AccountActor extends Actor with ActorLogging {

  import AccountActor._

  override def receive: Receive = {
    case GetByIdAsk(id) => {
      sender() ! db.run(Account.filter(_.userId === id).result.headOption)
    }
    case GetByPhoneAsk(phone) => {
      sender() ! db.run(Account.filter(_.phone === phone).result.headOption)
    }
    case row: AccountRow => {
      sender() ! db.run(Account returning Account.map(_.userId) += row)
    }
  }
}


object AccountActor {

  case class GetByIdAsk(id: Long)

  case class GetByPhoneAsk(phone: String)

  case class FindByQuery()

  lazy val ref: ActorRef = system.actorOf(Props[AccountActor], CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, classOf[AccountActor].getSimpleName))

  val db = Database.forConfig("postgresql.system_account")
}