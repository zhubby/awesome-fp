package com.github.ultramans.remix.lib

import spray.json._

package object models {

  import spray.json.DefaultJsonProtocol._

  case class MappingResult[T: JsonFormat](fieldName: String, cnValue: String, fieldValue: T)

  object MappingResult {
    implicit def mappingResultJsonFormat[T: JsonFormat]: RootJsonFormat[MappingResult[T]] = jsonFormat3(MappingResult.apply[T])
  }

  case class ValueEntry[S: JsonFormat](realValue: S, cnValue: String)

  object ValueEntry {
    implicit def mappingResultJsonFormat[T: JsonFormat]: RootJsonFormat[ValueEntry[T]] = jsonFormat2(ValueEntry.apply[T])
  }

}
