package org.github.omnbmh.samples;

import java.rmi.RemoteException;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @author *_*
 * @version 2017/4/26 上午11:20
 * @since 1.7
 */
public class BusinessImpl implements Business {

  public String echo(String message) throws RemoteException {
    if ("quit".equalsIgnoreCase(message.toString())) {
      System.out.println("Server will be shutdown!");
      System.exit(0);
    }
    System.out.println("Message from client:" + message);
    return "Server response:" + message;
  }
}
