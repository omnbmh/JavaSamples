package org.github.omnbmh.samples.grpc.protobuf;

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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.0.0)",
    comments = "Source: mysqljdbc.proto")
public class GetJdbcGrpc {

  private GetJdbcGrpc() {}

  public static final String SERVICE_NAME = "GetJdbc";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<JdbcRequest,
      JdbcResponse> METHOD_GET_JDBC =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "GetJdbc", "getJdbc"),
          io.grpc.protobuf.ProtoUtils.marshaller(JdbcRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(JdbcResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GetJdbcStub newStub(io.grpc.Channel channel) {
    return new GetJdbcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GetJdbcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GetJdbcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static GetJdbcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GetJdbcFutureStub(channel);
  }

  /**
   */
  public static abstract class GetJdbcImplBase implements io.grpc.BindableService {

    /**
     */
    public void getJdbc(JdbcRequest request,
        io.grpc.stub.StreamObserver<JdbcResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_JDBC, responseObserver);
    }

    @Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_JDBC,
            asyncUnaryCall(
              new MethodHandlers<
                JdbcRequest,
                JdbcResponse>(
                  this, METHODID_GET_JDBC)))
          .build();
    }
  }

  /**
   */
  public static final class GetJdbcStub extends io.grpc.stub.AbstractStub<GetJdbcStub> {
    private GetJdbcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GetJdbcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected GetJdbcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GetJdbcStub(channel, callOptions);
    }

    /**
     */
    public void getJdbc(JdbcRequest request,
        io.grpc.stub.StreamObserver<JdbcResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_JDBC, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GetJdbcBlockingStub extends io.grpc.stub.AbstractStub<GetJdbcBlockingStub> {
    private GetJdbcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GetJdbcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected GetJdbcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GetJdbcBlockingStub(channel, callOptions);
    }

    /**
     */
    public JdbcResponse getJdbc(JdbcRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_JDBC, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GetJdbcFutureStub extends io.grpc.stub.AbstractStub<GetJdbcFutureStub> {
    private GetJdbcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GetJdbcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected GetJdbcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GetJdbcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<JdbcResponse> getJdbc(
        JdbcRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_JDBC, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_JDBC = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GetJdbcImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(GetJdbcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_JDBC:
          serviceImpl.getJdbc((JdbcRequest) request,
              (io.grpc.stub.StreamObserver<JdbcResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_GET_JDBC);
  }

}
