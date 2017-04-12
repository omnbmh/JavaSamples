package org.github.omnbmh.samples.zookeeper.configcenter;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.zookeeper.KeeperException;
import org.github.omnbmh.samples.zookeeper.protobuf.Ping;
import org.github.omnbmh.samples.zookeeper.protobuf.PingPongGrpc;
import org.github.omnbmh.samples.zookeeper.protobuf.Pong;
import org.github.omnbmh.samples.zookeeper.registercenter.RegisterService;

/**
 * Created With IntelliJ IDEA CE
 * Desc: 选择服务!
 */
public class ChooseServiceTest {

  public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
    String appName = "TestPingPongApp";
    // 列出当前启动的服务
    RegisterService.printServerList(appName);
    // 随机取出一个
    String sStr = RegisterService.random(appName);

    JsonElement serverInfo = new JsonParser().parse(sStr);
    int port = serverInfo.getAsJsonObject().get("port").getAsInt();

    ManagedChannel channel = NettyChannelBuilder.forAddress("127.0.0.1", port).usePlaintext(true)
        .build();
    PingPongGrpc.PingPongBlockingStub client = PingPongGrpc.newBlockingStub(channel)
        .withDeadlineAfter(60000, TimeUnit.MILLISECONDS);
    System.out.println("client send " + "Tom");
    Ping request = Ping.newBuilder().setName("Tom").build();
    Pong response = client.ping(request);

    System.out.println("client receive " + response.getMessage());
  }
}
