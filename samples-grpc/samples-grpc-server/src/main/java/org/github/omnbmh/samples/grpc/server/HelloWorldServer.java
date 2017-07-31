package org.github.omnbmh.samples.grpc.server;

import io.grpc.internal.ServerImpl;
import io.grpc.netty.NettyServerBuilder;
import java.io.IOException;
import org.github.omnbmh.samples.grpc.impl.HelloWorldImpl;

/**
 * Created With IntelliJ IDEA CE
 * Desc: Write Something!
 *
 * 2017/7/31 下午2:00
 */
public class HelloWorldServer {

  public static void main(String[] args) throws IOException, InterruptedException {
    ServerImpl server = NettyServerBuilder.forPort(50010).addService(new HelloWorldImpl()).build();
    server.start();
    server.awaitTermination();// 阻塞直到退出
  }
}
