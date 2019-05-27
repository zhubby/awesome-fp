package com.github.ultramans.remix.account.routes

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
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._
import com.github.ultramans.remix.account.ApplicationSystem._
import com.github.ultramans.remix.account.models.RowJsonFormat._

object AccountRoute {
  implicit val timeout = Timeout(5.seconds)

  def route: Route = {
    pathPrefix("api") {
      concat(
        pathPrefix("v1") {
          concat(
            pathPrefix("new") {
              concat(
                post {
                  entity(as[AccountRow]) {
                    entity => {
                      complete {
                        AccountActor.ref ? entity map {
                          case r: Future[Long] => Wrapper.ok()
                        }
                      }
                    }
                  }

                }
              )
            }
          )

        }
      )


    }
  }
}
