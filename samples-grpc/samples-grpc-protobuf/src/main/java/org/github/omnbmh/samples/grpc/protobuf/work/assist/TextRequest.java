// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: work_assist.proto

package org.github.omnbmh.samples.grpc.protobuf.work.assist;

/**
 * Protobuf type {@code protobuf.work.assist.TextRequest}
 */
public  final class TextRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:protobuf.work.assist.TextRequest)
    TextRequestOrBuilder {
  // Use TextRequest.newBuilder() to construct.
  private TextRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TextRequest() {
    text_ = "";
    key_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private TextRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
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
            java.lang.String s = input.readStringRequireUtf8();

            text_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            key_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.github.omnbmh.samples.grpc.protobuf.work.assist.WorkAssistProto.internal_static_protobuf_work_assist_TextRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.github.omnbmh.samples.grpc.protobuf.work.assist.WorkAssistProto.internal_static_protobuf_work_assist_TextRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest.class, org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest.Builder.class);
  }

  public static final int TEXT_FIELD_NUMBER = 1;
  private volatile java.lang.Object text_;
  /**
   * <code>string text = 1;</code>
   */
  public java.lang.String getText() {
    java.lang.Object ref = text_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      text_ = s;
      return s;
    }
  }
  /**
   * <code>string text = 1;</code>
   */
  public com.google.protobuf.ByteString
      getTextBytes() {
    java.lang.Object ref = text_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      text_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int KEY_FIELD_NUMBER = 2;
  private volatile java.lang.Object key_;
  /**
   * <code>string key = 2;</code>
   */
  public java.lang.String getKey() {
    java.lang.Object ref = key_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      key_ = s;
      return s;
    }
  }
  /**
   * <code>string key = 2;</code>
   */
  public com.google.protobuf.ByteString
      getKeyBytes() {
    java.lang.Object ref = key_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      key_ = b;
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
    if (!getTextBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, text_);
    }
    if (!getKeyBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, key_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getTextBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, text_);
    }
    if (!getKeyBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, key_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest)) {
      return super.equals(obj);
    }
    org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest other = (org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest) obj;

    boolean result = true;
    result = result && getText()
        .equals(other.getText());
    result = result && getKey()
        .equals(other.getKey());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TEXT_FIELD_NUMBER;
    hash = (53 * hash) + getText().hashCode();
    hash = (37 * hash) + KEY_FIELD_NUMBER;
    hash = (53 * hash) + getKey().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code protobuf.work.assist.TextRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:protobuf.work.assist.TextRequest)
      org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.github.omnbmh.samples.grpc.protobuf.work.assist.WorkAssistProto.internal_static_protobuf_work_assist_TextRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.github.omnbmh.samples.grpc.protobuf.work.assist.WorkAssistProto.internal_static_protobuf_work_assist_TextRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest.class, org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest.Builder.class);
    }

    // Construct using org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      text_ = "";

      key_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.github.omnbmh.samples.grpc.protobuf.work.assist.WorkAssistProto.internal_static_protobuf_work_assist_TextRequest_descriptor;
    }

    public org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest getDefaultInstanceForType() {
      return org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest.getDefaultInstance();
    }

    public org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest build() {
      org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest buildPartial() {
      org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest result = new org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest(this);
      result.text_ = text_;
      result.key_ = key_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest) {
        return mergeFrom((org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest other) {
      if (other == org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest.getDefaultInstance()) return this;
      if (!other.getText().isEmpty()) {
        text_ = other.text_;
        onChanged();
      }
      if (!other.getKey().isEmpty()) {
        key_ = other.key_;
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
      org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object text_ = "";
    /**
     * <code>string text = 1;</code>
     */
    public java.lang.String getText() {
      java.lang.Object ref = text_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        text_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string text = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTextBytes() {
      java.lang.Object ref = text_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        text_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string text = 1;</code>
     */
    public Builder setText(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      text_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string text = 1;</code>
     */
    public Builder clearText() {
      
      text_ = getDefaultInstance().getText();
      onChanged();
      return this;
    }
    /**
     * <code>string text = 1;</code>
     */
    public Builder setTextBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      text_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object key_ = "";
    /**
     * <code>string key = 2;</code>
     */
    public java.lang.String getKey() {
      java.lang.Object ref = key_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        key_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string key = 2;</code>
     */
    public com.google.protobuf.ByteString
        getKeyBytes() {
      java.lang.Object ref = key_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        key_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string key = 2;</code>
     */
    public Builder setKey(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      key_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string key = 2;</code>
     */
    public Builder clearKey() {
      
      key_ = getDefaultInstance().getKey();
      onChanged();
      return this;
    }
    /**
     * <code>string key = 2;</code>
     */
    public Builder setKeyBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      key_ = value;
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


    // @@protoc_insertion_point(builder_scope:protobuf.work.assist.TextRequest)
  }

  // @@protoc_insertion_point(class_scope:protobuf.work.assist.TextRequest)
  private static final org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest();
  }

  public static org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TextRequest>
      PARSER = new com.google.protobuf.AbstractParser<TextRequest>() {
    public TextRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new TextRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TextRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TextRequest> getParserForType() {
    return PARSER;
  }

  public org.github.omnbmh.samples.grpc.protobuf.work.assist.TextRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
