// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: mysqljdbc.proto

package org.github.omnbmh.samples.grpc.protobuf;

public final class Mysqljdbc {
  private Mysqljdbc() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_JdbcRequest_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_JdbcRequest_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_JdbcResponse_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_JdbcResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\017mysqljdbc.proto\"\033\n\013JdbcRequest\022\014\n\004name" +
      "\030\001 \001(\t\"`\n\014JdbcResponse\022\017\n\007jdbcurl\030\001 \001(\t\022" +
      "\020\n\010username\030\002 \001(\t\022\024\n\014userpassword\030\003 \001(\t\022" +
      "\027\n\017driverclassname\030\004 \001(\t23\n\007GetJdbc\022(\n\007g" +
      "etJdbc\022\014.JdbcRequest\032\r.JdbcResponse\"\000B+\n" +
      "\'org.github.omnbmh.samples.grpc.protobuf" +
      "P\001b\006proto3"
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
    internal_static_JdbcRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_JdbcRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_JdbcRequest_descriptor,
        new String[] { "Name", });
    internal_static_JdbcResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_JdbcResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_JdbcResponse_descriptor,
        new String[] { "Jdbcurl", "Username", "Userpassword", "Driverclassname", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
