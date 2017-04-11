package org.github.omnbmh.samples.grpc.client;

import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import org.github.omnbmh.samples.grpc.protobuf.GetJdbcGrpc;
import org.github.omnbmh.samples.grpc.protobuf.JdbcRequest;
import org.github.omnbmh.samples.grpc.protobuf.JdbcResponse;

public class GetJdbcClient {
	private final GetJdbcGrpc.GetJdbcBlockingStub client;

	public GetJdbcClient(String host, int port) {
		ManagedChannel channel = NettyChannelBuilder.forAddress(host, port).usePlaintext(true).build();
		client = GetJdbcGrpc.newBlockingStub(channel).withDeadlineAfter(60000, TimeUnit.MILLISECONDS);
	}

	public JdbcResponse getJdbc(String name) {
		System.out.println("client get " + name +" jdbc.");
		JdbcRequest request = JdbcRequest.newBuilder().setName(name).build();
		JdbcResponse response = client.getJdbc(request);
		return response;
	}

	public static void main(String[] args) throws InterruptedException {
		GetJdbcClient c = new GetJdbcClient("127.0.0.1", 50010);
		for (int i = 0; i < 10; i++) {
			JdbcResponse result =   c.getJdbc("dezhichen");
			System.out.println("from server receive " + result.getDriverclassname());
			Thread.sleep(1000);
		}
	}
}
