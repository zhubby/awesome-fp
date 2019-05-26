package com.github.ultramans.remix.account.routes

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.github.ultramans.remix.account.actors.AccountActor
import com.github.ultramans.remix.lib.implicits.PrimitiveType.SeqImplicit
object AccountRoute {

  import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
  import spray.json.DefaultJsonProtocol._

  def route: Route = {
    pathPrefix("api") {
      pathPrefix("v3") {
        path(IntNumber) {
          AccountActor.ref ! AccountActor.GetSingleAccountAsk(1)
          userId => complete(List("1","2","3").joinWithComma)
        }
      }
    }
  }
}
