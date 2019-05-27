package com.github.ultramans.remix.estate.routes

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.github.ultramans.remix.lib.implicits.PrimitiveType.SeqImplicit

object EstateRoute {

  import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
  import spray.json.DefaultJsonProtocol._

  def route: Route = {
    pathPrefix("api") {
      concat(
        pathPrefix("v1") {
          concat(
            pathPrefix("sell") {
              concat(
                pathEndOrSingleSlash {
                  concat(
                    get {
                      complete("")
                    }
                  )
                },
                path(IntNumber) {
                  userId =>
                    concat(
                      get {
                        complete(List("1", "2", "3", "4").joinWithComma)
                      }
                    )
                }
              )
            }
          )
        }
      )
    }
  }
}
