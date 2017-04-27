package org.github.omnbmh.samples.spring.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @author *_*
 * @version 2017/4/27 上午11:35
 * @since 1.7
 */
public class Client {

  public static void main(String[] args) {
    ApplicationContext ac = new ClassPathXmlApplicationContext("client.xml");
    Business business = (Business) ac.getBean("businessService");
    business.echo("hello");
//    business.echo("quit");

  }
}
