package com.github.ultramans.remix.lib.configs;

import io.etcd.jetcd.ByteSequence;
import io.etcd.jetcd.Client;
import io.etcd.jetcd.KV;
import io.etcd.jetcd.kv.GetResponse;
import java.util.concurrent.CompletableFuture;

public class ConfigCenter {

  public CompletableFuture<GetResponse> getValue(String name) {
    Client client = Client.builder().endpoints("http://localhost:2379").build();
    KV kvClient = client.getKVClient();
    return kvClient.get(ByteSequence.from(name.getBytes()));
  }

}
