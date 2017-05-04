package org.github.omnbmh.jvm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created With IntelliJ IDEA CE
 * org.github.omnbmh.jvm TODO Write Something!
 * <p>More Info!</p>
 *
 * @date 2017/5/4
 * @time 下午12:49 </PRE>
 * @since 1.7
 *
 * <PRE>
 */
public class ReflectDemo {

  // Server OSR 编译阀值
  private static final int WARMUP_COUNT = 10700;
  private ForReflection testClass = new ForReflection();
  private static Method method = null;

  public static void main(String[] args) throws Exception {
    method = ForReflection.class.getMethod("execute", String.class);
    ReflectDemo demo = new ReflectDemo();
    // 保证 能生成 字节码 及相关的测试代码 能够被 JIT 编译
    for (int i = 0; i < 20; i++) {
      demo.testDirectCall();
      demo.testCacheMethodCall();
      demo.testNoCacheMethodCall();
    }

    long beginTime = System.currentTimeMillis();
    demo.testDirectCall();
    long endTime = System.currentTimeMillis();
    System.out.println("直接调用消耗的时间为: "+(endTime - beginTime)+"毫秒");

    beginTime = System.currentTimeMillis();
    demo.testNoCacheMethodCall();
    endTime = System.currentTimeMillis();
    System.out.println("不缓存调用消耗的时间为: "+(endTime - beginTime)+"毫秒");

    beginTime = System.currentTimeMillis();
    demo.testCacheMethodCall();
    endTime = System.currentTimeMillis();
    System.out.println("缓存调用消耗的时间为: "+(endTime - beginTime)+"毫秒");
  }

  public void testDirectCall() {
    for (int i = 0; i < WARMUP_COUNT; i++) {
      testClass.execute("hello");
    }
  }

  public void testCacheMethodCall() throws InvocationTargetException, IllegalAccessException {
    for (int i = 0; i < WARMUP_COUNT; i++) {
      method.invoke(testClass, new Object[]{"hello"});
    }
  }

  public void testNoCacheMethodCall()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    for (int i = 0; i < WARMUP_COUNT; i++) {
      Method testMethod = ForReflection.class.getMethod("execute", new Class<?>[]{String.class});
      method.invoke(testClass, new Object[]{"hello"});
    }
  }

}

class ForReflection {

  private Map<String, String> caches = new HashMap<String, String>();

  public void execute(String message) {
    String b = this.toString() + message;
    caches.put(b, message);
  }
}
