package org.github.omnbmh.distributed;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;
import junit.framework.TestCase;

/**
 * Created With IntelliJ IDEA CE
 * *
 *
 * @author *_*
 * @version 2017/4/25 下午3:18
 * @since 1.7
 */
public class NetMessageServerTest extends TestCase {

  public void testTCPIPBIO() {
    try {
      // 创建本地端口监听
      ServerSocket server = new ServerSocket(8888);
      // 接受客户端 请求 之后 和 客户端操作一样
      Socket client = server.accept();
    } catch (IOException e) {
      System.out.println(e.getMessage());
      System.out.println(e);
    }
  }

  public void testTCPIPNIO() {
    try {
      ServerSocketChannel server = ServerSocketChannel.open();
      ServerSocket serverSocket = server.socket();
      // 绑定端口
      serverSocket.bind(new InetSocketAddress(8888));
      // 非阻塞
      server.configureBlocking(false);

      Selector selector = Selector.open();

      // 注册感兴趣的连接事件
      server.register(selector, SelectionKey.OP_ACCEPT);
      int nKeys = selector.select(1000);// 1000ms 超时
      if (nKeys > 0) {
        Set<SelectionKey> keys = selector.selectedKeys();
        for (SelectionKey key : keys) {
          if (key.isAcceptable()) {
            ServerSocketChannel channel = (ServerSocketChannel) key.channel();
            SocketChannel sc = channel.accept();
            if (sc == null) {
              continue;
            }
            sc.configureBlocking(false);
            sc.register(selector, SelectionKey.OP_READ);
          }
        }
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
      System.out.println(e);
    }
  }

  /**
   * Created With IntelliJ IDEA CE
   * Server 和 Client 一样
   * <p>More Info!</p>
   *
   * @author dezhichen@creditease.cn
   * @version 2017/4/25 下午6:04
   * @since 1.7
   */
  public void testUDPIPBIO() {
    try {
      DatagramSocket server = new DatagramSocket(8888);
      byte[] buffer = new byte[65507];
      DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
      DatagramSocket socket = new DatagramSocket();

      byte[] sendBuffer = "Hello World.".getBytes();
      DatagramPacket packet = new DatagramPacket(sendBuffer, sendBuffer.length,
          InetAddress.getByName("127.0.0.1"), 8888);
      socket.send(packet);
      socket.setSoTimeout(1000);// 设置读取超时时间
      server.receive(receivePacket);
    } catch (IOException e) {
      System.out.println(e.getMessage());
      System.out.println(e);
    }
  }

  public void testUDPIPNIO() {
    try {
      DatagramChannel server = DatagramChannel.open();
      server.configureBlocking(false);

      DatagramSocket socket = server.socket();
      socket.bind(new InetSocketAddress(8888));
      Selector selector = Selector.open();
      server.register(selector, SelectionKey.OP_READ);
      // 之后采取 TCPIPNIO 遍历的方式 读取流

      DatagramChannel sendChannel = DatagramChannel.open();
      sendChannel.configureBlocking(false);
      SocketAddress target = new InetSocketAddress("127.0.0.1", 8888);
      sendChannel.connect(target);

      ByteBuffer buffer = ByteBuffer.allocate(1024);
      sendChannel.write(buffer);

    } catch (IOException e) {
      System.out.println(e.getMessage());
      System.out.println(e);
    }
  }

  /**
   * Created With IntelliJ IDEA CE
   * 组播
   * <p>More Info!</p>
   *
   * @version 2017/4/26 上午10:44
   * @since 1.7
   */
  public void testMulticast() {
    try {
      InetAddress groupAddress = InetAddress.getByName("127.0.0.1");
      MulticastSocket server = new MulticastSocket(8888);
      // 加入组播
      server.joinGroup(groupAddress);
      // 离开组播
//      server.leaveGroup(groupAddress);
      MulticastSocket client = new MulticastSocket(8888);
      client.joinGroup(groupAddress);
      // 之后 和  UDPIPBIO 一样 接受和发送消息
    } catch (IOException e) {
      System.out.println(e.getMessage());
      System.out.println(e);
    }
  }
}
