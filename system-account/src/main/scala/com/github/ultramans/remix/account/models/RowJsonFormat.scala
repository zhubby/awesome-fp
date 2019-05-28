package com.github.ultramans.remix.account.models

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.github.ultramans.remix.account.models.codegen.Tables._
import com.github.ultramans.remix.lib.implicits.ExtJsonFormat
import spray.json._


object RowJsonFormat extends DefaultJsonProtocol with ExtJsonFormat with SprayJsonSupport {

  object AccountRowJsonFormat extends RootJsonFormat[AccountRow] {
    override def write(row: AccountRow): JsValue = jsonFormat20(AccountRow).write(row)

    override def read(value: JsValue): AccountRow = {
      value.asJsObject.getFields("phone", "password") match {
        case Seq(JsString(phone), JsString(password)) => AccountRow(userId = 0, phone = phone, password = password, lastLoginIp = "127.0.0.1", registerIp = "127.0.0.1")
        case _ => throw DeserializationException(s"${AccountRow.getClass.getSimpleName} expected")
      }
    }
  }

}
