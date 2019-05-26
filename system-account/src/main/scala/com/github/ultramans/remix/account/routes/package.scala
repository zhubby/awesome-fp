package com.github.ultramans.remix.account

import akka.http.scaladsl.server.Directives._

package object routes {
  def aggregateRoutes = concat(AccountRoute.route)
}
