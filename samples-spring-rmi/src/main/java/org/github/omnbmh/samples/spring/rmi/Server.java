package org.github.omnbmh.samples.spring.rmi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @author *_*
 * @version 2017/4/27 上午11:34
 * @since 1.7
 */
public class Server {

  public static void main(String[] args) {
    new ClassPathXmlApplicationContext("server.xml");
    System.out.println("Server has been started!");
  }
}
