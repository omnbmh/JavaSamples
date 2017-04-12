package org.github.omnbmh.samples.zookeeper.configcenter;

import io.grpc.internal.ServerImpl;
import io.grpc.netty.NettyServerBuilder;
import java.io.IOException;
import org.github.omnbmh.samples.zookeeper.PingPongService;
import org.github.omnbmh.samples.zookeeper.registercenter.RegisterService;

/**
 * Created With IntelliJ IDEA CE
 * Desc: 注册PingPong服务
 */
public class RegisterServiceTest {

  public static void main(String[] args) throws IOException, InterruptedException {
    String appName = "TestPingPongApp";
    int port = 50012;

    ServerImpl server = NettyServerBuilder.forPort(port).addService(new PingPongService())
        .build();
    server.start();
    // 注册服务
    RegisterService.registerServer("TestPingPongApp", "127.0.0.1", port + "");

    System.out.println("server start ...");
    server.awaitTermination();// 阻塞直到退出
  }
}
