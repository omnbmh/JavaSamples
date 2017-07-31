package org.github.omnbmh.samples.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import java.util.concurrent.TimeUnit;
import org.github.omnbmh.samples.grpc.protobuf.work.assist.TextCodecGrpc;
import org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest;
import org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse;

/**
 * Created With IntelliJ IDEA CE
 * Desc: Write Something!
 *
 * 2017/7/31 下午1:47
 */
public class WorkAssistClient {

  private final TextCodecGrpc.TextCodecBlockingStub client;

  public WorkAssistClient(String host, int port) {
    ManagedChannel channel = NettyChannelBuilder.forAddress(host, port).usePlaintext(true).build();
    client = TextCodecGrpc.newBlockingStub(channel).withDeadlineAfter(60000, TimeUnit.MILLISECONDS);
  }

  public TextResponse encryptText() {
    TextRequest request = TextRequest.newBuilder().setKey("48205C6C2F91790103308EADECCAEEF5").setText("1101231999090901024").build();
    TextResponse response = client.encryptText(request);
    return response;
  }

  public static void main(String[] args) {
    WorkAssistClient c = new WorkAssistClient("127.0.0.1", 50010);
    TextResponse result = c.encryptText();
    System.out.println("from server receive " + result.getEncryptText());

  }
}
