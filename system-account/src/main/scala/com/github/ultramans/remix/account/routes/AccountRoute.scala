package com.github.ultramans.remix.account.routes

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.github.ultramans.remix.account.actors.AccountActor
import com.github.ultramans.remix.lib.implicits.PrimitiveType.SeqImplicit
import com.github.ultramans.remix.account.models.codegen.Tables._
import com.github.ultramans.remix.lib.models.Wrapper
import akka.pattern._
import akka.util.Timeout

import scala.concurrent.Future
import scala.concurrent.duration._
import spray.json.DefaultJsonProtocol._
import com.github.ultramans.remix.account.ApplicationSystem._
import com.github.ultramans.remix.account.models.RowJsonFormat.AccountRowJsonFormat

object AccountRoute extends SprayJsonSupport {
  implicit val timeout = Timeout(5.seconds)
  implicit val accountRowJsonFormat = AccountRowJsonFormat

  def route: Route = {
    pathPrefix("api") {
      concat(
        pathPrefix("v1") {
          concat(
            path("new") {
              concat(
                post {
                  entity(as[AccountRow]) {
                    entity => {
                      complete {
                        AccountActor.ref ? entity map {
                          case r: Future[Long] => r map Wrapper.ok
                        }
                      }
                    }
                  }
                }
              )
            },
            path(LongNumber) {
              userId => {
                complete {
                  AccountActor.ref ? AccountActor.GetByIdAsk(userId) map {
                    case r: Future[Option[AccountRow]] => r map Wrapper.ok
                  }
                }
              }
            }
          )

        }
      )
    }
  }
}
