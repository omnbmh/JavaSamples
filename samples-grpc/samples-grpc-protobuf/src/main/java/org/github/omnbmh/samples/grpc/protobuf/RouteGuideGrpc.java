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
 * <pre>
 * 服务端生成的接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: routeguide.proto")
public final class RouteGuideGrpc {

  private RouteGuideGrpc() {}

  public static final String SERVICE_NAME = "routeguide.RouteGuide";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.github.omnbmh.samples.grpc.protobuf.Point,
      org.github.omnbmh.samples.grpc.protobuf.Feature> METHOD_GET_FEATURE =
      io.grpc.MethodDescriptor.<org.github.omnbmh.samples.grpc.protobuf.Point, org.github.omnbmh.samples.grpc.protobuf.Feature>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "routeguide.RouteGuide", "GetFeature"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.github.omnbmh.samples.grpc.protobuf.Point.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.github.omnbmh.samples.grpc.protobuf.Feature.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.github.omnbmh.samples.grpc.protobuf.Rectangle,
      org.github.omnbmh.samples.grpc.protobuf.Feature> METHOD_LIST_FEATURES =
      io.grpc.MethodDescriptor.<org.github.omnbmh.samples.grpc.protobuf.Rectangle, org.github.omnbmh.samples.grpc.protobuf.Feature>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "routeguide.RouteGuide", "ListFeatures"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.github.omnbmh.samples.grpc.protobuf.Rectangle.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.github.omnbmh.samples.grpc.protobuf.Feature.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.github.omnbmh.samples.grpc.protobuf.Point,
      org.github.omnbmh.samples.grpc.protobuf.RouteSummary> METHOD_RECORD_ROUTE =
      io.grpc.MethodDescriptor.<org.github.omnbmh.samples.grpc.protobuf.Point, org.github.omnbmh.samples.grpc.protobuf.RouteSummary>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "routeguide.RouteGuide", "RecordRoute"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.github.omnbmh.samples.grpc.protobuf.Point.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.github.omnbmh.samples.grpc.protobuf.RouteSummary.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.github.omnbmh.samples.grpc.protobuf.RouteNote,
      org.github.omnbmh.samples.grpc.protobuf.RouteNote> METHOD_ROUTE_CHAT =
      io.grpc.MethodDescriptor.<org.github.omnbmh.samples.grpc.protobuf.RouteNote, org.github.omnbmh.samples.grpc.protobuf.RouteNote>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "routeguide.RouteGuide", "RouteChat"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.github.omnbmh.samples.grpc.protobuf.RouteNote.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.github.omnbmh.samples.grpc.protobuf.RouteNote.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RouteGuideStub newStub(io.grpc.Channel channel) {
    return new RouteGuideStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RouteGuideBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RouteGuideBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RouteGuideFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RouteGuideFutureStub(channel);
  }

  /**
   * <pre>
   * 服务端生成的接口
   * </pre>
   */
  public static abstract class RouteGuideImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 简单 RPC
     * </pre>
     */
    public void getFeature(org.github.omnbmh.samples.grpc.protobuf.Point request,
        io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.Feature> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FEATURE, responseObserver);
    }

    /**
     * <pre>
     * 服务端 到 客户端 的流 RPC
     * </pre>
     */
    public void listFeatures(org.github.omnbmh.samples.grpc.protobuf.Rectangle request,
        io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.Feature> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_FEATURES, responseObserver);
    }

    /**
     * <pre>
     * 客户端 到 服务端 的流 RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.Point> recordRoute(
        io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.RouteSummary> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_RECORD_ROUTE, responseObserver);
    }

    /**
     * <pre>
     *  双向的流 RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.RouteNote> routeChat(
        io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.RouteNote> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_ROUTE_CHAT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_FEATURE,
            asyncUnaryCall(
              new MethodHandlers<
                org.github.omnbmh.samples.grpc.protobuf.Point,
                org.github.omnbmh.samples.grpc.protobuf.Feature>(
                  this, METHODID_GET_FEATURE)))
          .addMethod(
            METHOD_LIST_FEATURES,
            asyncServerStreamingCall(
              new MethodHandlers<
                org.github.omnbmh.samples.grpc.protobuf.Rectangle,
                org.github.omnbmh.samples.grpc.protobuf.Feature>(
                  this, METHODID_LIST_FEATURES)))
          .addMethod(
            METHOD_RECORD_ROUTE,
            asyncClientStreamingCall(
              new MethodHandlers<
                org.github.omnbmh.samples.grpc.protobuf.Point,
                org.github.omnbmh.samples.grpc.protobuf.RouteSummary>(
                  this, METHODID_RECORD_ROUTE)))
          .addMethod(
            METHOD_ROUTE_CHAT,
            asyncBidiStreamingCall(
              new MethodHandlers<
                org.github.omnbmh.samples.grpc.protobuf.RouteNote,
                org.github.omnbmh.samples.grpc.protobuf.RouteNote>(
                  this, METHODID_ROUTE_CHAT)))
          .build();
    }
  }

  /**
   * <pre>
   * 服务端生成的接口
   * </pre>
   */
  public static final class RouteGuideStub extends io.grpc.stub.AbstractStub<RouteGuideStub> {
    private RouteGuideStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideStub(channel, callOptions);
    }

    /**
     * <pre>
     * 简单 RPC
     * </pre>
     */
    public void getFeature(org.github.omnbmh.samples.grpc.protobuf.Point request,
        io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.Feature> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FEATURE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 服务端 到 客户端 的流 RPC
     * </pre>
     */
    public void listFeatures(org.github.omnbmh.samples.grpc.protobuf.Rectangle request,
        io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.Feature> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_LIST_FEATURES, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 客户端 到 服务端 的流 RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.Point> recordRoute(
        io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.RouteSummary> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_RECORD_ROUTE, getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *  双向的流 RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.RouteNote> routeChat(
        io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.RouteNote> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_ROUTE_CHAT, getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * 服务端生成的接口
   * </pre>
   */
  public static final class RouteGuideBlockingStub extends io.grpc.stub.AbstractStub<RouteGuideBlockingStub> {
    private RouteGuideBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 简单 RPC
     * </pre>
     */
    public org.github.omnbmh.samples.grpc.protobuf.Feature getFeature(org.github.omnbmh.samples.grpc.protobuf.Point request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FEATURE, getCallOptions(), request);
    }

    /**
     * <pre>
     * 服务端 到 客户端 的流 RPC
     * </pre>
     */
    public java.util.Iterator<org.github.omnbmh.samples.grpc.protobuf.Feature> listFeatures(
        org.github.omnbmh.samples.grpc.protobuf.Rectangle request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_LIST_FEATURES, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 服务端生成的接口
   * </pre>
   */
  public static final class RouteGuideFutureStub extends io.grpc.stub.AbstractStub<RouteGuideFutureStub> {
    private RouteGuideFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 简单 RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.github.omnbmh.samples.grpc.protobuf.Feature> getFeature(
        org.github.omnbmh.samples.grpc.protobuf.Point request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FEATURE, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FEATURE = 0;
  private static final int METHODID_LIST_FEATURES = 1;
  private static final int METHODID_RECORD_ROUTE = 2;
  private static final int METHODID_ROUTE_CHAT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RouteGuideImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RouteGuideImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FEATURE:
          serviceImpl.getFeature((org.github.omnbmh.samples.grpc.protobuf.Point) request,
              (io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.Feature>) responseObserver);
          break;
        case METHODID_LIST_FEATURES:
          serviceImpl.listFeatures((org.github.omnbmh.samples.grpc.protobuf.Rectangle) request,
              (io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.Feature>) responseObserver);
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
        case METHODID_RECORD_ROUTE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.recordRoute(
              (io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.RouteSummary>) responseObserver);
        case METHODID_ROUTE_CHAT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.routeChat(
              (io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.RouteNote>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class RouteGuideDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.github.omnbmh.samples.grpc.protobuf.RouteGuideProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RouteGuideGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RouteGuideDescriptorSupplier())
              .addMethod(METHOD_GET_FEATURE)
              .addMethod(METHOD_LIST_FEATURES)
              .addMethod(METHOD_RECORD_ROUTE)
              .addMethod(METHOD_ROUTE_CHAT)
              .build();
        }
      }
    }
    return result;
  }
}
