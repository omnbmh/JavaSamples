package org.github.omnbmh.grpc.examples.service;

import org.github.omnbmh.grpc.proto.helloworld.GreeterGrpc;
import org.github.omnbmh.grpc.proto.helloworld.HelloReply;
import org.github.omnbmh.grpc.proto.helloworld.HelloRequest;

import io.grpc.stub.StreamObserver;

public class HelloWorldServiceImpl extends GreeterGrpc.GreeterImplBase {

	@Override
	public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
		String name = request.getName();
		System.out.println("server revice " + name);
		HelloReply response = HelloReply.newBuilder().setMessage(name).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
