package com.github.ultramans.remix.lib.configs

import io.etcd.jetcd.{ByteSequence, Client}
import scala.compat.java8.FutureConverters;
class SingleNodeConfig(endpoint: String) {

  val client = Client.builder().endpoints(endpoint).build()

  val kvClient = client.getKVClient

  def getValue(name: String) = FutureConverters.toScala(kvClient.get(ByteSequence.from(name.getBytes)))
}
