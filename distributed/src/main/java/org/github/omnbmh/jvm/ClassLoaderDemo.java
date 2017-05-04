package org.github.omnbmh.jvm;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @author *_*
 * @version 2017/4/28 下午3:47
 * @since 1.7
 */
public class ClassLoaderDemo {

  public static void main(String[] args) {
    System.out.println(ClassLoaderDemo.class.getClassLoader());
    System.out.println(ClassLoaderDemo.class.getClassLoader().getParent());
    System.out.println(ClassLoaderDemo.class.getClassLoader().getParent().getParent());
  }
}
