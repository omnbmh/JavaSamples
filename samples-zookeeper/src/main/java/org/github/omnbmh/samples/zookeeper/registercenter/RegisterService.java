package org.github.omnbmh.samples.zookeeper.registercenter;

import java.io.IOException;

import java.util.List;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.github.omnbmh.samples.zookeeper.ZKUtil;

public class RegisterService {


  public static void registerServer(ZooKeeper zk, String ip, String port)
      throws IOException {

    // 初始化 root 结点
    if (zk != null) {
      try {
        String znode = "/Apps";
        if (zk.exists(znode, false) == null) {
          zk.create(znode, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        znode = znode + "/TestApp1";
        if (zk.exists(znode, false) == null) {
          zk.create(znode, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        String data = "http://" + ip + ":" + port;
        String path = zk.create(znode + "/", data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
            CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("register " + data + " to " + path);
      } catch (KeeperException e) {
        System.out.println(e);
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    }
  }

  public static void printServerList() throws IOException, KeeperException, InterruptedException {
    ZooKeeper zk = ZKUtil.getZooKeeperClient();

    List<String> servers = zk.getChildren("/Apps/TestApp1", new Watcher() {

      @Override
      public void process(WatchedEvent event) {
        if (event.getType() == EventType.NodeChildrenChanged) {
          System.out.println("Node Changed!");
        }
      }
    });
    for (int i = 0; i < servers.size(); i++) {
      // System.out.println(servers.get(i));
      System.out.println(servers.get(i) + " - " + new String(
          zk.getData("/Apps/TestApp1/" + servers.get(i), true, null)));
    }
  }

  public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
    ZooKeeper zk = ZKUtil.getZooKeeperClient();
    // 注册服务
    for (int i = 10; i < 20; i++) {
      registerServer(zk, "127.0.0.1", "9" + i + "1");
    }
    // 获取服务列表
    printServerList();
  }

}
