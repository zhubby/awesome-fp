package com.github.ultramans.remix.account.actors;

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
