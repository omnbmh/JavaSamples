package org.github.omnbmh.samples.webservice;

import java.rmi.RemoteException;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @version 2017/4/26 上午11:20
 * @since 1.7
 */
@WebService(name = "Business" ,serviceName = "BusinessService",targetNamespace = "http://webservice.samples.omnbmh.github.org/client")
@SOAPBinding(style = Style.RPC)
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
