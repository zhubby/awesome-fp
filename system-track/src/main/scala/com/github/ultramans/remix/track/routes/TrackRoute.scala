package com.github.ultramans.remix.track.routes

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.github.ultramans.remix.lib.models.track.HttpRequestTrack
import com.github.ultramans.remix.track.actors.KeepTrackingActor

class TrackRoute {

  import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
  import spray.json.DefaultJsonProtocol._

  def route: Route = {
    pathPrefix("api") {
      pathPrefix("v1") {
        pathPrefix("h5") {
          KeepTrackingActor.ref ! HttpRequestTrack
          complete(List("1", "2", "3", "4"))
        }
      }
    }
  }
}
