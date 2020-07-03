package org.github.omnbmh.hprose.examples;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.ArrayList;
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

    public static void reconnected() {
        ZooKeeper zk = ZKTools.getZooKeeperClient();
        try {
            zk.exists("/Apps/Api", true);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void init() {
        serverInfoList = new ArrayList<>();
        try {
            ZooKeeper zk = ZKTools.getZooKeeperClient();
            if (zk.exists("/Apps/Api", true) == null) {
                return;
            }
            List<String> serverNodes = zk.getChildren("/Apps/Api", new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println("--- client ---");
                    System.out.println("path: " + event.getPath());
                    System.out.println("type: " + event.getType().name());
                    System.out.println("state: " + event.getState());
                    if (event.getType().getIntValue() < 0) {
                        reconnected();
                    }
                    if (event.getType().compareTo(Event.EventType.NodeChildrenChanged) == 0) {
                        System.out.println("Children Node Changed!");
                        init();
                    }
                }
            });
            for (int i = 0; i < serverNodes.size(); i++) {
                String serverInfo = new String(zk.getData("/Apps/Api/" + serverNodes.get(i), true, null));
                System.out.println(serverNodes.get(i) + " - " + serverInfo);
                serverInfoList.add(serverInfo);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
