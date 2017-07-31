package org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * The greeting impl definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: pingpong.proto")
public final class PingPongGrpc {

  private PingPongGrpc() {}

  public static final String SERVICE_NAME = "PingPong";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Ping,
      org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Pong> METHOD_PING =
      io.grpc.MethodDescriptor.<org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Ping, org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Pong>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "PingPong", "ping"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Ping.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Pong.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PingPongStub newStub(io.grpc.Channel channel) {
    return new PingPongStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PingPongBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PingPongBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PingPongFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PingPongFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting impl definition.
   * </pre>
   */
  public static abstract class PingPongImplBase implements io.grpc.BindableService {

    /**
     */
    public void ping(org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Ping request,
        io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Pong> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PING, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_PING,
            asyncUnaryCall(
              new MethodHandlers<
                org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Ping,
                org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Pong>(
                  this, METHODID_PING)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting impl definition.
   * </pre>
   */
  public static final class PingPongStub extends io.grpc.stub.AbstractStub<PingPongStub> {
    private PingPongStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PingPongStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PingPongStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PingPongStub(channel, callOptions);
    }

    /**
     */
    public void ping(org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Ping request,
        io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Pong> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PING, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting impl definition.
   * </pre>
   */
  public static final class PingPongBlockingStub extends io.grpc.stub.AbstractStub<PingPongBlockingStub> {
    private PingPongBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PingPongBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PingPongBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PingPongBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Pong ping(org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Ping request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PING, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting impl definition.
   * </pre>
   */
  public static final class PingPongFutureStub extends io.grpc.stub.AbstractStub<PingPongFutureStub> {
    private PingPongFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PingPongFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PingPongFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PingPongFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Pong> ping(
        org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Ping request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PING, getCallOptions()), request);
    }
  }

  private static final int METHODID_PING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PingPongImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PingPongImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PING:
          serviceImpl.ping((org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Ping) request,
              (io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Pong>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class PingPongDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.Pingpong.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PingPongGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PingPongDescriptorSupplier())
              .addMethod(METHOD_PING)
              .build();
        }
      }
    }
    return result;
  }
}
