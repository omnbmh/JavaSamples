// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: routeguide.proto

package org.github.omnbmh.grpc.examples.routeguide;

public interface RouteSummaryOrBuilder extends
    // @@protoc_insertion_point(interface_extends:routeguide.RouteSummary)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int32 point_count = 1;</code>
   */
  int getPointCount();

  /**
   * <code>optional int32 feature_count = 2;</code>
   */
  int getFeatureCount();

  /**
   * <code>optional int32 distance = 3;</code>
   */
  int getDistance();

  /**
   * <code>optional int32 elapsed_time = 4;</code>
   */
  int getElapsedTime();
}