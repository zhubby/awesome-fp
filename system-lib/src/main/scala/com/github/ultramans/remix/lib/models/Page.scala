package com.github.ultramans.remix.lib.models

import spray.json._

/**
  * USER Administrator
  * DATE 2018/11/2 0002 下午 4:42
  * E-MAIL yanvalue@gmail.com
  */
trait Page {
  var pageSize = 10
  var pageNow = 1

  def size: Int = pageSize

  def from: Int = (pageNow - 1) * pageSize

  implicit val pageJsonFormat = new RootJsonFormat[Page] {
    override def write(obj: Page): JsValue = JsObject(
      "page_size" -> JsNumber(obj.pageSize),
      "page_now" -> JsNumber(obj.pageNow)
    )

    override def read(json: JsValue): Page = json.asJsObject.getFields("page_size", "page_now") match {
      case Seq(JsNumber(pageSize), JsNumber(pageNow)) => new Page {
        this.pageSize = pageSize
        this.pageNow = pageNow
      }
      case _ => throw DeserializationException(s"${this.getClass.getSimpleName} expected")
    }
  }
}
