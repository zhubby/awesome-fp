package com.github.ultramans.remix.lib.models

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._

class Paginate[T](d: T, p: Page, t: Int) {

  val data: T = d

  val page: Page = p

  val total: Int = t

  def pageNow: Int = page.pageNow

  def pageSize: Int = page.pageSize

  def pageCount: Int = if ((total % pageSize) == 0) total / pageSize else total / pageSize + 1

}

object Paginate extends SprayJsonSupport with DefaultJsonProtocol {
  implicit def paginateJsonFormat[A: JsonFormat]: RootJsonFormat[Paginate[A]] = new RootJsonFormat[Paginate[A]] {
    override def write(obj: Paginate[A]): JsValue = JsObject(
      "data" -> obj.data.toJson,
      "total" -> JsNumber(obj.total),
      "page_now" -> JsNumber(obj.pageNow),
      "page_size" -> JsNumber(obj.pageSize),
      "page_count" -> JsNumber(obj.pageCount)
    )

    override def read(json: JsValue): Paginate[A] = ???
  }

  def apply[T](d: T, p: Page, t: Int): Paginate[T] = new Paginate(d, p, t)
}
