package org.github.omnbmh.samples.grpc.protobuf.test;

import com.google.protobuf.InvalidProtocolBufferException;
import junit.framework.TestCase;
import org.github.omnbmh.commons.tools.GsonTools;
import org.github.omnbmh.samples.grpc.protobuf.msg01.Message;

/**
 * Created With IntelliJ IDEA CE
 * Desc: 当Message属性有变化时 能否 反序列化!
 * 结论 Message 的属性 不影响序列化
 * 2017/8/4 下午1:19
 */
public class MessagePropertyTest extends TestCase {

  public void testToByteArray() throws InvalidProtocolBufferException {
    Message mm01 = Message.newBuilder().setName("Wang").build();

    org.github.omnbmh.samples.grpc.protobuf.msg02.Message mm02 = org.github.omnbmh.samples.grpc.protobuf.msg02.Message
        .parseFrom(mm01.toByteArray());
    org.github.omnbmh.samples.grpc.protobuf.msg03.Message mm03 = org.github.omnbmh.samples.grpc.protobuf.msg03.Message
        .parseFrom(mm02.toByteArray());
    System.out.println("mm1 ");
    System.out.println(GsonTools.getJsonStringFromObject(mm01));
    System.out.println(GsonTools.getJsonStringFromObject(mm01.toBuilder().build()));
    System.out.println("mm2 ");
    System.out.println(GsonTools.getJsonStringFromObject(mm02));
    System.out.println(GsonTools.getJsonStringFromObject(mm02.toBuilder().build()));
    System.out.println("mm3 ");
    System.out.println(GsonTools.getJsonStringFromObject(mm03));
    System.out.println(GsonTools.getJsonStringFromObject(mm03.toBuilder().build()));
  }

  public void testParseForm() throws InvalidProtocolBufferException {
    org.github.omnbmh.samples.grpc.protobuf.msg03.Message mm03 = org.github.omnbmh.samples.grpc.protobuf.msg03.Message
        .newBuilder()
        .setName("Wang").setAge("18").setSex("Nv").build();

    org.github.omnbmh.samples.grpc.protobuf.msg02.Message mm02 = org.github.omnbmh.samples.grpc.protobuf.msg02.Message
        .parseFrom(mm03.toByteArray());
    Message mm01 = Message
        .parseFrom(mm02.toByteArray());
    System.out.println("mm1 ");
    System.out.println(GsonTools.getJsonStringFromObject(mm01));
    System.out.println(GsonTools.getJsonStringFromObject(mm01.toBuilder().build()));
    System.out.println("mm2 ");
    System.out.println(GsonTools.getJsonStringFromObject(mm02));
    System.out.println(GsonTools.getJsonStringFromObject(mm02.toBuilder().build()));
    System.out.println("mm3 ");
    System.out.println(GsonTools.getJsonStringFromObject(mm03));
    System.out.println(GsonTools.getJsonStringFromObject(mm03.toBuilder().build()));
  }

}
