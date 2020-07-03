package org.github.omnbmh.samples.zookeeper;

import org.github.omnbmh.samples.zookeeper.protobuf.PingPongGrpc;
import org.github.omnbmh.samples.zookeeper.protobuf.Pong;

/**
 * Created With IntelliJ IDEA CE
 * Created on 2017/4/11.
 * Desc: PingPong服务!
 */
public class PingPongService extends PingPongGrpc.PingPongImplBase {

  @Override
  public void ping(org.github.omnbmh.samples.zookeeper.protobuf.Ping request,
      io.grpc.stub.StreamObserver<Pong> responseObserver) {
    String name = request.getName();
    System.out.println("server receive " + name);
    Pong response = Pong.newBuilder().setMessage("hello "+name).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
