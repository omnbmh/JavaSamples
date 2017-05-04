package org.github.omnbmh.jvm;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @author *_*
 * @version 2017/4/28 下午4:02
 * @since 1.7
 */
public class Demo {

  public void execute() {
    A.execute();

    A a = new A();
    a.bar();

    IFoo b = new B();
    b.bar();
  }
}

class A {

  public static int execute() {
    return 1 + 2;
  }

  public int bar() {
    return 1 + 2;
  }
}

class B implements IFoo {

  public int bar() {
    return 1 + 2;
  }
}