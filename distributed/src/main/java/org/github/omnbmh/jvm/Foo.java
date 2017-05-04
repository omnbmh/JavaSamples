package org.github.omnbmh.jvm;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @author *_*
 * @version 2017/4/28 下午3:25
 * @since 1.7
 */
public class Foo {

  public static final int MAX_COUNT = 1000;
  public static int count = 0;

  public int bar() throws Exception {
    if (++count >= MAX_COUNT) {
      count = 0;
      throw new Exception("count overflow!");
    }
    return count;
  }
}
