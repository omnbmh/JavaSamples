// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: routeguide.proto

package org.github.omnbmh.grpc.examples.routeguide;

public interface RectangleOrBuilder extends
    // @@protoc_insertion_point(interface_extends:routeguide.Rectangle)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .routeguide.Point lo = 1;</code>
   */
  boolean hasLo();
  /**
   * <code>optional .routeguide.Point lo = 1;</code>
   */
  org.github.omnbmh.grpc.examples.routeguide.Point getLo();
  /**
   * <code>optional .routeguide.Point lo = 1;</code>
   */
  org.github.omnbmh.grpc.examples.routeguide.PointOrBuilder getLoOrBuilder();

  /**
   * <code>optional .routeguide.Point hi = 2;</code>
   */
  boolean hasHi();
  /**
   * <code>optional .routeguide.Point hi = 2;</code>
   */
  org.github.omnbmh.grpc.examples.routeguide.Point getHi();
  /**
   * <code>optional .routeguide.Point hi = 2;</code>
   */
  org.github.omnbmh.grpc.examples.routeguide.PointOrBuilder getHiOrBuilder();
}