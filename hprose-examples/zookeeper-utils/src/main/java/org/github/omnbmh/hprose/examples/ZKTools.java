package org.github.omnbmh.hprose.examples;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by b1rd on 2016/11/3.
 */
public class ZKTools {
    private static ZooKeeper zooKeeper;

    public static ZooKeeper getZooKeeperClient() {
        if (zooKeeper == null) {
            try {
                zooKeeper = new ZooKeeper("10.100.142.94:2181", 2000, new Watcher() {
                    // 监控所有被触发的事件
                    public void process(WatchedEvent event) {
                        //System.out.println("已经触发了" + event.getType() + "事件！");
                    }
                });
            } catch (IOException e) {
                System.out.println(e);
                //zooKeeper = null;
            }
        }
        return zooKeeper;
    }
}
