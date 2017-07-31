package org.github.omnbmh.samples.grpc.impl;

import io.grpc.stub.StreamObserver;
import org.github.omnbmh.samples.grpc.protobuf.GreeterGrpc;
import org.github.omnbmh.samples.grpc.protobuf.HelloReply;
import org.github.omnbmh.samples.grpc.protobuf.HelloRequest;

/**
 * Created With IntelliJ IDEA CE
 * Desc: Write Something!
 *
 * 2017/7/31 下午1:57
 */
public class HelloWorldImpl extends GreeterGrpc.GreeterImplBase {
  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    String name = request.getName();
    System.out.println("server revice " + name);
    HelloReply response = HelloReply.newBuilder().setMessage(name).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
