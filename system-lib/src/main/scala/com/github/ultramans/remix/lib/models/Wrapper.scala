package com.github.ultramans.remix.lib.models

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.StatusCodes
import spray.json.{DefaultJsonProtocol, JsonFormat, RootJsonFormat}


final case class Wrapper[+T](message: String, code: Int, data: T)

object Wrapper extends SprayJsonSupport with DefaultJsonProtocol {
  implicit def wrapperFormat[A: JsonFormat]: RootJsonFormat[Wrapper[A]] = jsonFormat3(Wrapper.apply[A])

  def ok[A](s: A): Wrapper[A] = this (StatusCodes.OK.defaultMessage, StatusCodes.OK.intValue, s)

  def err[A](msg: String, code: Int, s: A = Option.empty): Wrapper[A] = this (msg, code, s)
}

