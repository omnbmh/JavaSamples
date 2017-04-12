// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: routeguide.proto

package org.github.omnbmh.samples.grpc.protobuf;

/**
 * Protobuf type {@code routeguide.RouteNote}
 */
public  final class RouteNote extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:routeguide.RouteNote)
    RouteNoteOrBuilder {
  // Use RouteNote.newBuilder() to construct.
  private RouteNote(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private RouteNote() {
    message_ = "";
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private RouteNote(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry) {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            Point.Builder subBuilder = null;
            if (location_ != null) {
              subBuilder = location_.toBuilder();
            }
            location_ = input.readMessage(Point.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(location_);
              location_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            message_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw new RuntimeException(e.setUnfinishedMessage(this));
    } catch (java.io.IOException e) {
      throw new RuntimeException(
          new com.google.protobuf.InvalidProtocolBufferException(
              e.getMessage()).setUnfinishedMessage(this));
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.github.omnbmh.samples.grpc.protobuf.RouteGuideProto.internal_static_routeguide_RouteNote_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.github.omnbmh.samples.grpc.protobuf.RouteGuideProto.internal_static_routeguide_RouteNote_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            RouteNote.class, Builder.class);
  }

  public static final int LOCATION_FIELD_NUMBER = 1;
  private Point location_;
  /**
   * <code>optional .routeguide.Point location = 1;</code>
   */
  public boolean hasLocation() {
    return location_ != null;
  }
  /**
   * <code>optional .routeguide.Point location = 1;</code>
   */
  public Point getLocation() {
    return location_ == null ? Point.getDefaultInstance() : location_;
  }
  /**
   * <code>optional .routeguide.Point location = 1;</code>
   */
  public org.github.omnbmh.samples.grpc.protobuf.PointOrBuilder getLocationOrBuilder() {
    return getLocation();
  }

  public static final int MESSAGE_FIELD_NUMBER = 2;
  private volatile Object message_;
  /**
   * <code>optional string message = 2;</code>
   */
  public String getMessage() {
    Object ref = message_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      message_ = s;
      return s;
    }
  }
  /**
   * <code>optional string message = 2;</code>
   */
  public com.google.protobuf.ByteString
      getMessageBytes() {
    Object ref = message_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      message_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (location_ != null) {
      output.writeMessage(1, getLocation());
    }
    if (!getMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 2, message_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (location_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getLocation());
    }
    if (!getMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(2, message_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  public static RouteNote parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static RouteNote parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static RouteNote parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static RouteNote parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static RouteNote parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static RouteNote parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static RouteNote parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static RouteNote parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static RouteNote parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static RouteNote parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(RouteNote prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code routeguide.RouteNote}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:routeguide.RouteNote)
      org.github.omnbmh.samples.grpc.protobuf.RouteNoteOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.github.omnbmh.samples.grpc.protobuf.RouteGuideProto.internal_static_routeguide_RouteNote_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.github.omnbmh.samples.grpc.protobuf.RouteGuideProto.internal_static_routeguide_RouteNote_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              RouteNote.class, Builder.class);
    }

    // Construct using org.github.omnbmh.samples.grpc.protobuf.RouteNote.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      if (locationBuilder_ == null) {
        location_ = null;
      } else {
        location_ = null;
        locationBuilder_ = null;
      }
      message_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.github.omnbmh.samples.grpc.protobuf.RouteGuideProto.internal_static_routeguide_RouteNote_descriptor;
    }

    public RouteNote getDefaultInstanceForType() {
      return RouteNote.getDefaultInstance();
    }

    public RouteNote build() {
      RouteNote result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public RouteNote buildPartial() {
      RouteNote result = new RouteNote(this);
      if (locationBuilder_ == null) {
        result.location_ = location_;
      } else {
        result.location_ = locationBuilder_.build();
      }
      result.message_ = message_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof RouteNote) {
        return mergeFrom((RouteNote)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(RouteNote other) {
      if (other == RouteNote.getDefaultInstance()) return this;
      if (other.hasLocation()) {
        mergeLocation(other.getLocation());
      }
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      RouteNote parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (RouteNote) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Point location_ = null;
    private com.google.protobuf.SingleFieldBuilder<
        Point, Point.Builder, org.github.omnbmh.samples.grpc.protobuf.PointOrBuilder> locationBuilder_;
    /**
     * <code>optional .routeguide.Point location = 1;</code>
     */
    public boolean hasLocation() {
      return locationBuilder_ != null || location_ != null;
    }
    /**
     * <code>optional .routeguide.Point location = 1;</code>
     */
    public Point getLocation() {
      if (locationBuilder_ == null) {
        return location_ == null ? Point.getDefaultInstance() : location_;
      } else {
        return locationBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .routeguide.Point location = 1;</code>
     */
    public Builder setLocation(Point value) {
      if (locationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        location_ = value;
        onChanged();
      } else {
        locationBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>optional .routeguide.Point location = 1;</code>
     */
    public Builder setLocation(
        Point.Builder builderForValue) {
      if (locationBuilder_ == null) {
        location_ = builderForValue.build();
        onChanged();
      } else {
        locationBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>optional .routeguide.Point location = 1;</code>
     */
    public Builder mergeLocation(Point value) {
      if (locationBuilder_ == null) {
        if (location_ != null) {
          location_ =
            Point.newBuilder(location_).mergeFrom(value).buildPartial();
        } else {
          location_ = value;
        }
        onChanged();
      } else {
        locationBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>optional .routeguide.Point location = 1;</code>
     */
    public Builder clearLocation() {
      if (locationBuilder_ == null) {
        location_ = null;
        onChanged();
      } else {
        location_ = null;
        locationBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>optional .routeguide.Point location = 1;</code>
     */
    public Point.Builder getLocationBuilder() {
      
      onChanged();
      return getLocationFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .routeguide.Point location = 1;</code>
     */
    public org.github.omnbmh.samples.grpc.protobuf.PointOrBuilder getLocationOrBuilder() {
      if (locationBuilder_ != null) {
        return locationBuilder_.getMessageOrBuilder();
      } else {
        return location_ == null ?
            Point.getDefaultInstance() : location_;
      }
    }
    /**
     * <code>optional .routeguide.Point location = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        Point, Point.Builder, org.github.omnbmh.samples.grpc.protobuf.PointOrBuilder>
        getLocationFieldBuilder() {
      if (locationBuilder_ == null) {
        locationBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            Point, Point.Builder, org.github.omnbmh.samples.grpc.protobuf.PointOrBuilder>(
                getLocation(),
                getParentForChildren(),
                isClean());
        location_ = null;
      }
      return locationBuilder_;
    }

    private Object message_ = "";
    /**
     * <code>optional string message = 2;</code>
     */
    public String getMessage() {
      Object ref = message_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        message_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>optional string message = 2;</code>
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      Object ref = message_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string message = 2;</code>
     */
    public Builder setMessage(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      message_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string message = 2;</code>
     */
    public Builder clearMessage() {
      
      message_ = getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    /**
     * <code>optional string message = 2;</code>
     */
    public Builder setMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      message_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:routeguide.RouteNote)
  }

  // @@protoc_insertion_point(class_scope:routeguide.RouteNote)
  private static final RouteNote DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new RouteNote();
  }

  public static RouteNote getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RouteNote>
      PARSER = new com.google.protobuf.AbstractParser<RouteNote>() {
    public RouteNote parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      try {
        return new RouteNote(input, extensionRegistry);
      } catch (RuntimeException e) {
        if (e.getCause() instanceof
            com.google.protobuf.InvalidProtocolBufferException) {
          throw (com.google.protobuf.InvalidProtocolBufferException)
              e.getCause();
        }
        throw e;
      }
    }
  };

  public static com.google.protobuf.Parser<RouteNote> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<RouteNote> getParserForType() {
    return PARSER;
  }

  public RouteNote getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
