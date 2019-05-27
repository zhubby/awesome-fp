package com.github.ultramans.remix.lib
import org.apache.zookeeper.{WatchedEvent, Watcher, ZooKeeper}
import org.scalatest.FunSuite
class ZkApiTest extends FunSuite{
  val zk = new ZooKeeper("120.26.57.78:2181", 5000,new Watcher {
    override def process(event: WatchedEvent): Unit = println(event.toString)
  })

  import org.apache.zookeeper.CreateMode
  import org.apache.zookeeper.ZooDefs.Ids

  zk.create("/zoo2", "myData2".getBytes, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT)
  System.out.println(new String(zk.getData("/zoo2", false, null)))
}
