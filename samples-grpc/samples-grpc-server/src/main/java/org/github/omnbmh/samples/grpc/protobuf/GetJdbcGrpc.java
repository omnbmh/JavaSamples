package org.github.omnbmh.samples.grpc.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: mysqljdbc.proto")
public final class GetJdbcGrpc {

  private GetJdbcGrpc() {}

  public static final String SERVICE_NAME = "GetJdbc";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<JdbcRequest1,
      JdbcResponse1> METHOD_GET_JDBC =
      io.grpc.MethodDescriptor.<JdbcRequest1, JdbcResponse1>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GetJdbc", "getJdbc"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              JdbcRequest1.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              JdbcResponse1.getDefaultInstance()))
          .build();

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
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
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
    public void getJdbc(JdbcRequest1 request,
        io.grpc.stub.StreamObserver<JdbcResponse1> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_JDBC, responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_JDBC,
            asyncUnaryCall(
              new MethodHandlers<
                JdbcRequest1,
                JdbcResponse1>(
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
    public void getJdbc(JdbcRequest1 request,
        io.grpc.stub.StreamObserver<JdbcResponse1> responseObserver) {
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
    public JdbcResponse1 getJdbc(JdbcRequest1 request) {
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
    public com.google.common.util.concurrent.ListenableFuture<JdbcResponse1> getJdbc(
        JdbcRequest1 request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_JDBC, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_JDBC = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GetJdbcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GetJdbcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_JDBC:
          serviceImpl.getJdbc((JdbcRequest1) request,
              (io.grpc.stub.StreamObserver<JdbcResponse1>) responseObserver);
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

  private static final class GetJdbcDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Mysqljdbc.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GetJdbcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GetJdbcDescriptorSupplier())
              .addMethod(METHOD_GET_JDBC)
              .build();
        }
      }
    }
    return result;
  }
}
