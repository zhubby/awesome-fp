package com.github.ultramans.remix.estate

import akka.http.scaladsl.server.Directives.concat

package object routes {
  def aggregateRoutes = concat(EstateRoute.route)
}
