package com.github.ultramans.remix.lib.models

import java.util.Date

package object track {

  case class HttpRequestTrack(
                               requestId: Long,
                               requestTime: Date,
                               handleDuration: Long,
                               userId: Option[Long],
                               hostname: String,
                               remoteAddress: String,
                               requestPath: String,
                               httpMethod: String,
                               httpProtocol: String,
                               httpHeaders: Map[String, Array[String]],
                               contentType: String,
                               userAgent: String,
                               cookies: Map[String, String],
                               requestBody: Map[String, Array[String]],
                               serverHost: String
                             )


}
