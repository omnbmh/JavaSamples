package org.github.omnbmh.samples.zookeeper.configcenter;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import java.util.concurrent.TimeUnit;
import org.github.omnbmh.samples.zookeeper.protobuf.Ping;
import org.github.omnbmh.samples.zookeeper.protobuf.PingPongGrpc;
import org.github.omnbmh.samples.zookeeper.protobuf.Pong;

/**
 * Created With IntelliJ IDEA CE
 * Desc: 选择服务!
 */
public class ChooseServiceTest {

  public static void main(String[] args) {
    // 列出当前启动的服务

    // 随机取出一个
    ManagedChannel channel = NettyChannelBuilder.forAddress("127.0.0.1", 50010).usePlaintext(true)
        .build();
    PingPongGrpc.PingPongBlockingStub client = PingPongGrpc.newBlockingStub(channel)
        .withDeadlineAfter(60000, TimeUnit.MILLISECONDS);
    System.out.println("client send " + "Tom");
    Ping request = Ping.newBuilder().setName("Tom").build();
    Pong response = client.ping(request);

    System.out.println("client receive " + response.getMessage());
  }
}
