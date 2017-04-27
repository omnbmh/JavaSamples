package org.github.omnbmh.samples.cxf;

import java.rmi.RemoteException;
import javax.jws.WebService;

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
@WebService(serviceName = "BusinessService",endpointInterface = "org.github.omnbmh.samples.cxf.Business")
public class BusinessImpl implements Business {

  public String echo(String message) {
    if ("quit".equalsIgnoreCase(message.toString())) {
      System.out.println("Server will be shutdown!");
      System.exit(0);
    }
    System.out.println("Message from client:" + message);
    return "Server response:" + message;
  }
}
