package org.github.omnbmh.samples.webservice;

import javax.xml.ws.Endpoint;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @version 2017/4/27 上午10:07
 * @since 1.7
 */
public class Server {

  public static void main(String[] args) {
    Endpoint.publish("http://127.0.0.1:8888/BusineeService",new BusinessImpl());
    System.out.println("Server has been started!");
  }
}
