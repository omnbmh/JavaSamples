package org.github.omnbmh.distributed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;
import junit.framework.TestCase;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @author *_*
 * @version 2017/4/25 下午3:19
 * @since 1.7
 */
public class NetMessageClientTest extends TestCase {

  public void testTCPIPBIO() {
    try {
      //创建连接
//      Socket client = new Socket();
//      client.connect(new SocketAddress() {
//        @Override
//        public int hashCode() {
//          return super.hashCode();
//        }
//      },1000);// 设置超时时间
      Socket client = new Socket("127.0.0.1", 8888);
      // 创建读取服务器返回流 的 Reader
      BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

      // 创建向服务器写入流的 Writter
      PrintWriter out = new PrintWriter(client.getOutputStream(), true);
      // 想服务器发送字符串 即使写失败也不会异常 知道网络IO异常
      out.println("hello");
      // 阻塞读取服务器返回消息
      in.readLine();
    } catch (IOException e) {
      System.out.println(e.getMessage());
      System.out.println(e);
    }
  }

  public void testTCPIPNIO() {
    try {
      SocketChannel channel = SocketChannel.open();
      // 设置为非阻塞模式
      channel.configureBlocking(false);
      // SocketAddress
      // 对于非阻塞模式 立即返回false 表示连接正在进行中
      channel.connect(new InetSocketAddress("127.0.0.1", 8888));
      Selector selector = Selector.open();
      // 向channel selector 及 感兴趣的事件
      channel.register(selector, SelectionKey.OP_CONNECT);

      int nKeys = selector.select(1000);// 1000ms 超时
      // 如果>0 说明有感兴趣的IO事件发生
      if (nKeys > 0) {
        Set<SelectionKey> keys = selector.selectedKeys();
        for (SelectionKey key : keys) {
          // 对于发生连接的事件
          if (key.isConnectable()) {
            SocketChannel sc = (SocketChannel) key.channel();
            sc.configureBlocking(false);
            // 注册感兴趣的事件
//            sKey = sc.register(selector,SelectionKey.OP_READ);
            // 完成连接的建立
            sc.finishConnect();
          }
          // 有流可读取
          else if (key.isReadable()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            SocketChannel sc = (SocketChannel) key.channel();
            int readBytes = 0;
            try {
              int ret = 0;
              try {
                while ((ret = sc.read(buffer)) > 0) {
                  readBytes += ret;
                }
              } finally {
                buffer.flip();
              }
            } finally {
              if (buffer != null) {
                buffer.clear();
              }
            }
          } else if (key.isWritable()) {
            // 取消 OP_WRITE 事件的注册
            key.interestOps(key.interestOps() & (~SelectionKey.OP_WRITE));
            SocketChannel sc = (SocketChannel) key.channel();

            // 此步为阻塞操作
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int writtenSize = sc.write(buffer);
            if (writtenSize == 0) {
              key.interestOps(key.interestOps() | SelectionKey.OP_WRITE);
            }
          }
        }
        selector.selectedKeys().clear();
      }
      //对于要写入的流 可以直接调用  channel.write 来完成
//      ByteBuffer buffer = ByteBuffer.allocate(1024);
//      int wSize = channel.write(buffer);
//      if (wSize == 0){
//
//      }
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

  public  void  testUDPIPNIO(){
    try {
      DatagramChannel server = DatagramChannel.open();
      server.configureBlocking(false);

      DatagramSocket socket = server.socket();
      socket.bind(new InetSocketAddress(8888));
      Selector selector = Selector.open();
      server.register(selector,SelectionKey.OP_READ);
      // 之后采取 TCPIPNIO 遍历的方式 读取流


      DatagramChannel sendChannel = DatagramChannel.open();
      sendChannel.configureBlocking(false);
      SocketAddress target = new InetSocketAddress("127.0.0.1",8888);
      sendChannel.connect(target);

      ByteBuffer buffer = ByteBuffer.allocate(1024);
      sendChannel.write(buffer);

    }
    catch (IOException e){
      System.out.println(e.getMessage());
      System.out.println(e);
    }
  }
}
