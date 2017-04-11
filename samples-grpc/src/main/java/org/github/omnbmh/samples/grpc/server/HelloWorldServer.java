package org.github.omnbmh.samples.grpc.server;

import java.io.IOException;

import org.github.omnbmh.samples.grpc.service.HelloWorldServiceImpl;

import io.grpc.internal.ServerImpl;
import io.grpc.netty.NettyServerBuilder;

public class HelloWorldServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerImpl server = NettyServerBuilder.forPort(50010).addService(new HelloWorldServiceImpl()).build();
		server.start();
		server.awaitTermination();// 阻塞直到退出
	}
}
