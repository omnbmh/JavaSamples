package org.github.omnbmh.hprose.examples;

/**
 * Created by b1rd on 2016/11/3.
 * 本类针对zookeeper的NodeEvent进行了测试
 * 3.1状态：KeeperState.Disconnected(0)
 此时客户端处于断开连接状态，和ZK集群都没有建立连接。
 3.1.1事件：EventType.None(-1)
 触发条件：一般是在与服务器断开连接的时候，客户端会收到这个事件。

 3.2状态：KeeperState. SyncConnected(3)
 3.2.1事件：EventType.None(-1)
 触发条件：客户端与服务器成功建立会话之后，会收到这个通知。
 3.2.2事件：EventType. NodeCreated (1)
 触发条件：所关注的节点被创建。
 3.2.3事件：EventType. NodeDeleted (2)
 触发条件：所关注的节点被删除。
 3.2.4事件：EventType. NodeDataChanged (3)
 触发条件：所关注的节点的内容有更新。注意，这个地方说的内容是指数据的版本号dataVersion。因此，即使使用相同的数据内容来更新，还是会收到这个事件通知的。无论如何，调用了更新接口，就一定会更新dataVersion的。
 3.2.5事件：EventType. NodeChildrenChanged (4)
 触发条件：所关注的节点的子节点有变化。这里说的变化是指子节点的个数和组成，具体到子节点内容的变化是不会通知的。

 3.3状态 KeeperState. AuthFailed(4)
 3.3.1事件：EventType.None(-1)

 3.4状态 KeeperState. Expired(-112)
 3.4.1事件：EventType.None(-1)
 */
public class ZookeeperNodeEventTest {

}
