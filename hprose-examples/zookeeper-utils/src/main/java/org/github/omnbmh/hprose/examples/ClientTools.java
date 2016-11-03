package org.github.omnbmh.hprose.examples;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

/**
 * Created by b1rd on 2016/11/3.
 */
public class ClientTools {
    private static List<String> serverInfoList;

    public static List<String> getServerInfoList() {
        if (serverInfoList == null) {
            init();
        }
        return serverInfoList;
    }

    public  static  void  check(){
        ZooKeeper zk = ZKTools.getZooKeeperClient();
        try {
            zk.exists("/Apps/OrgamsApi", true);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void init() {
        try {
            ZooKeeper zk = ZKTools.getZooKeeperClient();
            if (zk.exists("/Apps/OrgamsApi", true) == null) {
                return;
            }
            serverInfoList = zk.getChildren("/Apps/OrgamsApi", new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println("--- client ---");
                    System.out.println(event.getPath());
                    System.out.println(event.getType());
                    if (event.getType().compareTo(Event.EventType.NodeChildrenChanged) == 0) {
                        System.out.println("Children Node Changed!");
                        init();
                    }
                }
            });
            for (int i = 0; i < serverInfoList.size(); i++) {
                // System.out.println(servers.get(i));
                System.out.println(serverInfoList.get(i) + " - " + new String(zk.getData("/Apps/OrgamsApi/" + serverInfoList.get(i), true, null)));
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
