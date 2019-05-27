package com.github.ultramans.remix.lib

import com.github.ultramans.remix.lib.configs.{ConfigCenter, SingleNodeConfig}
import org.scalatest.FunSuite

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class SingleNodeConfigTest extends FunSuite{
//  val config = new SingleNodeConfig("http://localhost:2379")
//  val result = Await.result(config.getValue("/database"),Duration.Inf)
//  println(result)

  val c = new ConfigCenter
  println(c.getValue("/database").get())
}
