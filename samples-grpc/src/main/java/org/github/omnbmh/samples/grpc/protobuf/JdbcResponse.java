// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: mysqljdbc.proto

package org.github.omnbmh.samples.grpc.protobuf;

/**
 * Protobuf type {@code JdbcResponse}
 */
public  final class JdbcResponse extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:JdbcResponse)
    JdbcResponseOrBuilder {
  // Use JdbcResponse.newBuilder() to construct.
  private JdbcResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private JdbcResponse() {
    jdbcurl_ = "";
    username_ = "";
    userpassword_ = "";
    driverclassname_ = "";
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private JdbcResponse(
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
            String s = input.readStringRequireUtf8();

            jdbcurl_ = s;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            username_ = s;
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

            userpassword_ = s;
            break;
          }
          case 34: {
            String s = input.readStringRequireUtf8();

            driverclassname_ = s;
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
    return Mysqljdbc.internal_static_JdbcResponse_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return Mysqljdbc.internal_static_JdbcResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            JdbcResponse.class, Builder.class);
  }

  public static final int JDBCURL_FIELD_NUMBER = 1;
  private volatile Object jdbcurl_;
  /**
   * <code>optional string jdbcurl = 1;</code>
   */
  public String getJdbcurl() {
    Object ref = jdbcurl_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      jdbcurl_ = s;
      return s;
    }
  }
  /**
   * <code>optional string jdbcurl = 1;</code>
   */
  public com.google.protobuf.ByteString
      getJdbcurlBytes() {
    Object ref = jdbcurl_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      jdbcurl_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int USERNAME_FIELD_NUMBER = 2;
  private volatile Object username_;
  /**
   * <code>optional string username = 2;</code>
   */
  public String getUsername() {
    Object ref = username_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      username_ = s;
      return s;
    }
  }
  /**
   * <code>optional string username = 2;</code>
   */
  public com.google.protobuf.ByteString
      getUsernameBytes() {
    Object ref = username_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      username_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int USERPASSWORD_FIELD_NUMBER = 3;
  private volatile Object userpassword_;
  /**
   * <code>optional string userpassword = 3;</code>
   */
  public String getUserpassword() {
    Object ref = userpassword_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      userpassword_ = s;
      return s;
    }
  }
  /**
   * <code>optional string userpassword = 3;</code>
   */
  public com.google.protobuf.ByteString
      getUserpasswordBytes() {
    Object ref = userpassword_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      userpassword_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DRIVERCLASSNAME_FIELD_NUMBER = 4;
  private volatile Object driverclassname_;
  /**
   * <code>optional string driverclassname = 4;</code>
   */
  public String getDriverclassname() {
    Object ref = driverclassname_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      driverclassname_ = s;
      return s;
    }
  }
  /**
   * <code>optional string driverclassname = 4;</code>
   */
  public com.google.protobuf.ByteString
      getDriverclassnameBytes() {
    Object ref = driverclassname_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      driverclassname_ = b;
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
    if (!getJdbcurlBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, jdbcurl_);
    }
    if (!getUsernameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 2, username_);
    }
    if (!getUserpasswordBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 3, userpassword_);
    }
    if (!getDriverclassnameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 4, driverclassname_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getJdbcurlBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, jdbcurl_);
    }
    if (!getUsernameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(2, username_);
    }
    if (!getUserpasswordBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(3, userpassword_);
    }
    if (!getDriverclassnameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(4, driverclassname_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  public static JdbcResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static JdbcResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static JdbcResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static JdbcResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static JdbcResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static JdbcResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static JdbcResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static JdbcResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static JdbcResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static JdbcResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(JdbcResponse prototype) {
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
   * Protobuf type {@code JdbcResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:JdbcResponse)
      org.github.omnbmh.samples.grpc.protobuf.JdbcResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Mysqljdbc.internal_static_JdbcResponse_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Mysqljdbc.internal_static_JdbcResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              JdbcResponse.class, Builder.class);
    }

    // Construct using org.github.omnbmh.samples.grpc.protobuf.JdbcResponse.newBuilder()
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
      jdbcurl_ = "";

      username_ = "";

      userpassword_ = "";

      driverclassname_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return Mysqljdbc.internal_static_JdbcResponse_descriptor;
    }

    public JdbcResponse getDefaultInstanceForType() {
      return JdbcResponse.getDefaultInstance();
    }

    public JdbcResponse build() {
      JdbcResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public JdbcResponse buildPartial() {
      JdbcResponse result = new JdbcResponse(this);
      result.jdbcurl_ = jdbcurl_;
      result.username_ = username_;
      result.userpassword_ = userpassword_;
      result.driverclassname_ = driverclassname_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof JdbcResponse) {
        return mergeFrom((JdbcResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(JdbcResponse other) {
      if (other == JdbcResponse.getDefaultInstance()) return this;
      if (!other.getJdbcurl().isEmpty()) {
        jdbcurl_ = other.jdbcurl_;
        onChanged();
      }
      if (!other.getUsername().isEmpty()) {
        username_ = other.username_;
        onChanged();
      }
      if (!other.getUserpassword().isEmpty()) {
        userpassword_ = other.userpassword_;
        onChanged();
      }
      if (!other.getDriverclassname().isEmpty()) {
        driverclassname_ = other.driverclassname_;
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
      JdbcResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (JdbcResponse) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object jdbcurl_ = "";
    /**
     * <code>optional string jdbcurl = 1;</code>
     */
    public String getJdbcurl() {
      Object ref = jdbcurl_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        jdbcurl_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>optional string jdbcurl = 1;</code>
     */
    public com.google.protobuf.ByteString
        getJdbcurlBytes() {
      Object ref = jdbcurl_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        jdbcurl_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string jdbcurl = 1;</code>
     */
    public Builder setJdbcurl(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      jdbcurl_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string jdbcurl = 1;</code>
     */
    public Builder clearJdbcurl() {
      
      jdbcurl_ = getDefaultInstance().getJdbcurl();
      onChanged();
      return this;
    }
    /**
     * <code>optional string jdbcurl = 1;</code>
     */
    public Builder setJdbcurlBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      jdbcurl_ = value;
      onChanged();
      return this;
    }

    private Object username_ = "";
    /**
     * <code>optional string username = 2;</code>
     */
    public String getUsername() {
      Object ref = username_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        username_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>optional string username = 2;</code>
     */
    public com.google.protobuf.ByteString
        getUsernameBytes() {
      Object ref = username_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        username_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string username = 2;</code>
     */
    public Builder setUsername(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      username_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string username = 2;</code>
     */
    public Builder clearUsername() {
      
      username_ = getDefaultInstance().getUsername();
      onChanged();
      return this;
    }
    /**
     * <code>optional string username = 2;</code>
     */
    public Builder setUsernameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      username_ = value;
      onChanged();
      return this;
    }

    private Object userpassword_ = "";
    /**
     * <code>optional string userpassword = 3;</code>
     */
    public String getUserpassword() {
      Object ref = userpassword_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        userpassword_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>optional string userpassword = 3;</code>
     */
    public com.google.protobuf.ByteString
        getUserpasswordBytes() {
      Object ref = userpassword_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        userpassword_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string userpassword = 3;</code>
     */
    public Builder setUserpassword(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      userpassword_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string userpassword = 3;</code>
     */
    public Builder clearUserpassword() {
      
      userpassword_ = getDefaultInstance().getUserpassword();
      onChanged();
      return this;
    }
    /**
     * <code>optional string userpassword = 3;</code>
     */
    public Builder setUserpasswordBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      userpassword_ = value;
      onChanged();
      return this;
    }

    private Object driverclassname_ = "";
    /**
     * <code>optional string driverclassname = 4;</code>
     */
    public String getDriverclassname() {
      Object ref = driverclassname_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        driverclassname_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>optional string driverclassname = 4;</code>
     */
    public com.google.protobuf.ByteString
        getDriverclassnameBytes() {
      Object ref = driverclassname_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        driverclassname_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string driverclassname = 4;</code>
     */
    public Builder setDriverclassname(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      driverclassname_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string driverclassname = 4;</code>
     */
    public Builder clearDriverclassname() {
      
      driverclassname_ = getDefaultInstance().getDriverclassname();
      onChanged();
      return this;
    }
    /**
     * <code>optional string driverclassname = 4;</code>
     */
    public Builder setDriverclassnameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      driverclassname_ = value;
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


    // @@protoc_insertion_point(builder_scope:JdbcResponse)
  }

  // @@protoc_insertion_point(class_scope:JdbcResponse)
  private static final JdbcResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new JdbcResponse();
  }

  public static JdbcResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<JdbcResponse>
      PARSER = new com.google.protobuf.AbstractParser<JdbcResponse>() {
    public JdbcResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      try {
        return new JdbcResponse(input, extensionRegistry);
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

  public static com.google.protobuf.Parser<JdbcResponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<JdbcResponse> getParserForType() {
    return PARSER;
  }

  public JdbcResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
