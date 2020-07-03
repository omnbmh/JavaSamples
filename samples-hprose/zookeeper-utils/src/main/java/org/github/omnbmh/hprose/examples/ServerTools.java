package org.github.omnbmh.hprose.examples;

import com.google.gson.JsonObject;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class ServerTools {

    static String ROOT_PATH = "/Apps/Api/";

    static {
        try {
            init();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void init() throws KeeperException, InterruptedException {
        ZooKeeper zk = ZKTools.getZooKeeperClient();
        if (zk != null) {
            String znode = "/Apps";
            if (zk.exists(znode, false) == null) {
                zk.create(znode, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            znode = znode + "/Api";
            if (zk.exists(znode, false) == null) {
                zk.create(znode, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        }
    }

    public static boolean register(String protrol, String host, int port) {
        ZooKeeper zk = ZKTools.getZooKeeperClient();
        if (zk == null) {
            return false;
        }
        try {
            JsonObject json = new JsonObject();
            json.addProperty("protrol", protrol);
            json.addProperty("host", host);
            json.addProperty("port", port);
            String data = json.toString();
            String path = zk.create(ROOT_PATH, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println("register " + data + " to " + path);
        } catch (KeeperException e) {
            System.err.println(e);
            return false;
        } catch (InterruptedException e) {
            System.err.println(e);
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        register("http", "10.100.142.94", 8080);
    }
}
