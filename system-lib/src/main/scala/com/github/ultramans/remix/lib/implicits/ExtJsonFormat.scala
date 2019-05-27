package com.github.ultramans.remix.lib.implicits

import java.sql.Date

import spray.json._
import com.github.ultramans.remix.lib.implicits.PrimitiveType.DateImplicit
import com.github.ultramans.remix.lib.implicits.PrimitiveType.StringImplicit
trait ExtJsonFormat {
  implicit val extDateJsonFormat = new JsonFormat[Date] {
    override def write(x: Date) = JsString(x.format)
    override def read(value: JsValue) = value match {
      case JsString(x) => java.sql.Date.valueOf(x)
      case x => deserializationError("Expected Date as JsString, but got " + x)
    }
  }
}
