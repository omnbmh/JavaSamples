// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: helloworld.proto

package org.github.omnbmh.grpc.examples.helloworld;

public final class Helloworld {
  private Helloworld() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_HelloRequest_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_HelloRequest_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_HelloReply_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_HelloReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020helloworld.proto\"\034\n\014HelloRequest\022\014\n\004na" +
      "me\030\001 \001(\t\"\035\n\nHelloReply\022\017\n\007message\030\001 \001(\t2" +
      "3\n\007Greeter\022(\n\010SayHello\022\r.HelloRequest\032\013." +
      "HelloReply\"\000B.\n*org.github.omnbmh.grpc.e" +
      "xamples.helloworldP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_HelloRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_HelloRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_HelloRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_HelloReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_HelloReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_HelloReply_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
