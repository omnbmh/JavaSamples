package org.github.omnbmh.samples.grpc.protobuf.test;

import junit.framework.TestCase;
import org.github.omnbmh.samples.grpc.protobuf.zookeeper.protobuf.RType;

/**
 * Created With IntelliJ IDEA CE
 * Desc: Write Something!
 *
 * 2017/8/11 下午5:35
 */
public class EnumTest extends TestCase {

  public void test() {
    System.out.println(RType.pingping);
    System.out.println(RType.pingping + "");
    System.out.println(RType.pingping.toString());
    System.out.println(RType.pingping_VALUE);
  }
}
