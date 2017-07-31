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
    comments = "Source: searchdbdata.proto")
public final class SearchDbDataGrpc {

  private SearchDbDataGrpc() {}

  public static final String SERVICE_NAME = "SearchDbData";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<JdbcRequest,
      JdbcResponse> METHOD_SEARCH_DB_DATA_BY_JDBC =
      io.grpc.MethodDescriptor.<JdbcRequest, JdbcResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "SearchDbData", "searchDbDataByJdbc"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              JdbcRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              JdbcResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<DruidRequest,
      DruidResponse> METHOD_SEARCH_DB_DATA_BY_DRUID =
      io.grpc.MethodDescriptor.<DruidRequest, DruidResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "SearchDbData", "searchDbDataByDruid"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              DruidRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              DruidResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SearchDbDataStub newStub(io.grpc.Channel channel) {
    return new SearchDbDataStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SearchDbDataBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SearchDbDataBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SearchDbDataFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SearchDbDataFutureStub(channel);
  }

  /**
   */
  public static abstract class SearchDbDataImplBase implements io.grpc.BindableService {

    /**
     */
    public void searchDbDataByJdbc(JdbcRequest request,
        io.grpc.stub.StreamObserver<JdbcResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEARCH_DB_DATA_BY_JDBC, responseObserver);
    }

    /**
     */
    public void searchDbDataByDruid(DruidRequest request,
        io.grpc.stub.StreamObserver<DruidResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEARCH_DB_DATA_BY_DRUID, responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SEARCH_DB_DATA_BY_JDBC,
            asyncUnaryCall(
              new MethodHandlers<
                JdbcRequest,
                JdbcResponse>(
                  this, METHODID_SEARCH_DB_DATA_BY_JDBC)))
          .addMethod(
            METHOD_SEARCH_DB_DATA_BY_DRUID,
            asyncUnaryCall(
              new MethodHandlers<
                DruidRequest,
                DruidResponse>(
                  this, METHODID_SEARCH_DB_DATA_BY_DRUID)))
          .build();
    }
  }

  /**
   */
  public static final class SearchDbDataStub extends io.grpc.stub.AbstractStub<SearchDbDataStub> {
    private SearchDbDataStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SearchDbDataStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SearchDbDataStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SearchDbDataStub(channel, callOptions);
    }

    /**
     */
    public void searchDbDataByJdbc(JdbcRequest request,
        io.grpc.stub.StreamObserver<JdbcResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEARCH_DB_DATA_BY_JDBC, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchDbDataByDruid(DruidRequest request,
        io.grpc.stub.StreamObserver<DruidResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEARCH_DB_DATA_BY_DRUID, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SearchDbDataBlockingStub extends io.grpc.stub.AbstractStub<SearchDbDataBlockingStub> {
    private SearchDbDataBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SearchDbDataBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SearchDbDataBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SearchDbDataBlockingStub(channel, callOptions);
    }

    /**
     */
    public JdbcResponse searchDbDataByJdbc(JdbcRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEARCH_DB_DATA_BY_JDBC, getCallOptions(), request);
    }

    /**
     */
    public DruidResponse searchDbDataByDruid(DruidRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEARCH_DB_DATA_BY_DRUID, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SearchDbDataFutureStub extends io.grpc.stub.AbstractStub<SearchDbDataFutureStub> {
    private SearchDbDataFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SearchDbDataFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SearchDbDataFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SearchDbDataFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<JdbcResponse> searchDbDataByJdbc(
        JdbcRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEARCH_DB_DATA_BY_JDBC, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<DruidResponse> searchDbDataByDruid(
        DruidRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEARCH_DB_DATA_BY_DRUID, getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH_DB_DATA_BY_JDBC = 0;
  private static final int METHODID_SEARCH_DB_DATA_BY_DRUID = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SearchDbDataImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SearchDbDataImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEARCH_DB_DATA_BY_JDBC:
          serviceImpl.searchDbDataByJdbc((JdbcRequest) request,
              (io.grpc.stub.StreamObserver<JdbcResponse>) responseObserver);
          break;
        case METHODID_SEARCH_DB_DATA_BY_DRUID:
          serviceImpl.searchDbDataByDruid((DruidRequest) request,
              (io.grpc.stub.StreamObserver<DruidResponse>) responseObserver);
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

  private static final class SearchDbDataDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Searchdbdata.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SearchDbDataGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SearchDbDataDescriptorSupplier())
              .addMethod(METHOD_SEARCH_DB_DATA_BY_JDBC)
              .addMethod(METHOD_SEARCH_DB_DATA_BY_DRUID)
              .build();
        }
      }
    }
    return result;
  }
}
