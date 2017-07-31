package org.github.omnbmh.samples.grpc.protobuf.work.assist;

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
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: work_assist.proto")
public final class TextCodecGrpc {

  private TextCodecGrpc() {}

  public static final String SERVICE_NAME = "protobuf.work.assist.TextCodec";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest,
      org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse> METHOD_ENCRYPT_TEXT =
      io.grpc.MethodDescriptor.<org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest, org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "protobuf.work.assist.TextCodec", "encryptText"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest,
      org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse> METHOD_DECRYPT_TEXT =
      io.grpc.MethodDescriptor.<org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest, org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "protobuf.work.assist.TextCodec", "decryptText"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TextCodecStub newStub(io.grpc.Channel channel) {
    return new TextCodecStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TextCodecBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TextCodecBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TextCodecFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TextCodecFutureStub(channel);
  }

  /**
   */
  public static abstract class TextCodecImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * DES加密
     * </pre>
     */
    public void encryptText(org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest request,
        io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ENCRYPT_TEXT, responseObserver);
    }

    /**
     * <pre>
     * DES解密
     * </pre>
     */
    public void decryptText(org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest request,
        io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DECRYPT_TEXT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ENCRYPT_TEXT,
            asyncUnaryCall(
              new MethodHandlers<
                org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest,
                org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse>(
                  this, METHODID_ENCRYPT_TEXT)))
          .addMethod(
            METHOD_DECRYPT_TEXT,
            asyncUnaryCall(
              new MethodHandlers<
                org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest,
                org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse>(
                  this, METHODID_DECRYPT_TEXT)))
          .build();
    }
  }

  /**
   */
  public static final class TextCodecStub extends io.grpc.stub.AbstractStub<TextCodecStub> {
    private TextCodecStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TextCodecStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextCodecStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TextCodecStub(channel, callOptions);
    }

    /**
     * <pre>
     * DES加密
     * </pre>
     */
    public void encryptText(org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest request,
        io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ENCRYPT_TEXT, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * DES解密
     * </pre>
     */
    public void decryptText(org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest request,
        io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DECRYPT_TEXT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TextCodecBlockingStub extends io.grpc.stub.AbstractStub<TextCodecBlockingStub> {
    private TextCodecBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TextCodecBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextCodecBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TextCodecBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * DES加密
     * </pre>
     */
    public org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse encryptText(org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ENCRYPT_TEXT, getCallOptions(), request);
    }

    /**
     * <pre>
     * DES解密
     * </pre>
     */
    public org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse decryptText(org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DECRYPT_TEXT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TextCodecFutureStub extends io.grpc.stub.AbstractStub<TextCodecFutureStub> {
    private TextCodecFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TextCodecFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextCodecFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TextCodecFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * DES加密
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse> encryptText(
        org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ENCRYPT_TEXT, getCallOptions()), request);
    }

    /**
     * <pre>
     * DES解密
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse> decryptText(
        org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DECRYPT_TEXT, getCallOptions()), request);
    }
  }

  private static final int METHODID_ENCRYPT_TEXT = 0;
  private static final int METHODID_DECRYPT_TEXT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TextCodecImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TextCodecImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ENCRYPT_TEXT:
          serviceImpl.encryptText((org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest) request,
              (io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse>) responseObserver);
          break;
        case METHODID_DECRYPT_TEXT:
          serviceImpl.decryptText((org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest) request,
              (io.grpc.stub.StreamObserver<org.github.omnbmh.samples.grpc.protobuf.work.assist.TextResponse>) responseObserver);
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

  private static final class TextCodecDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.github.omnbmh.samples.grpc.protobuf.work.assist.WorkAssistProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TextCodecGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TextCodecDescriptorSupplier())
              .addMethod(METHOD_ENCRYPT_TEXT)
              .addMethod(METHOD_DECRYPT_TEXT)
              .build();
        }
      }
    }
    return result;
  }
}
