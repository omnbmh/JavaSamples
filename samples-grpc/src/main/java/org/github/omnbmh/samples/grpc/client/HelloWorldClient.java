package org.github.omnbmh.samples.grpc.client;

import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import org.github.omnbmh.samples.grpc.protobuf.GreeterGrpc;
import org.github.omnbmh.samples.grpc.protobuf.HelloReply;
import org.github.omnbmh.samples.grpc.protobuf.HelloRequest;

public class HelloWorldClient {
	private final GreeterGrpc.GreeterBlockingStub client;

	public HelloWorldClient(String host, int port) {
		ManagedChannel channel = NettyChannelBuilder.forAddress(host, port).usePlaintext(true).build();
		client = GreeterGrpc.newBlockingStub(channel).withDeadlineAfter(60000, TimeUnit.MILLISECONDS);
	}

	public String sayHello(String name) {
		System.out.println("client receive " + name);
		HelloRequest request = HelloRequest.newBuilder().setName(name).build();
		HelloReply response = client.sayHello(request);
		return response.getMessage();
	}

	public static void main(String[] args) throws InterruptedException {
		HelloWorldClient c = new HelloWorldClient("127.0.0.1", 50010);
		for (int i = 0; i < 10; i++) {
			String result =   c.sayHello("dezhichen");
			System.out.println("from server receive " + result);
			Thread.sleep(1000);
		}
	}
}
