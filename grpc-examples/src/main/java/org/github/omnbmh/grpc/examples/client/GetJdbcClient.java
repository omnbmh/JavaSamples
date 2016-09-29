package org.github.omnbmh.grpc.examples.client;

import java.util.concurrent.TimeUnit;

import org.github.omnbmh.grpc.proto.jdbc.GetJdbcGrpc;
import org.github.omnbmh.grpc.proto.jdbc.JdbcRequest;
import org.github.omnbmh.grpc.proto.jdbc.JdbcResponse;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;

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
