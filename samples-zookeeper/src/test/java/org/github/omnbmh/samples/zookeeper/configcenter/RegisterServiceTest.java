package org.github.omnbmh.samples.zookeeper.configcenter;

import io.grpc.internal.ServerImpl;
import io.grpc.netty.NettyServerBuilder;
import java.io.IOException;
import org.github.omnbmh.samples.zookeeper.PingPongService;

/**
 * Created With IntelliJ IDEA CE
 * Desc: 注册PingPong服务
 */
public class RegisterServiceTest {

  public static void main(String[] args) throws IOException, InterruptedException {
    ServerImpl server = NettyServerBuilder.forPort(50010).addService(new PingPongService())
        .build();
    server.start();
    // 注册服务

    System.out.println("server start ...");
    server.awaitTermination();// 阻塞直到退出
  }
}
