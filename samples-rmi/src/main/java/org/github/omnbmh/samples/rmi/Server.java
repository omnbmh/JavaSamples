package org.github.omnbmh.samples.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @version 2017/4/26 上午11:23
 * @since 1.7
 */
public class Server {

  public static void main(String[] args) {
    try {
      String name = "BusinessDemo";
      Business business = new BusinessImpl();
      UnicastRemoteObject.exportObject(business, 8888);

      Registry registry = LocateRegistry.createRegistry(1099);
      registry.rebind(name, business);
      System.out.println("Server has been started!");
    } catch (RemoteException e) {
      System.out.println(e);
    }
  }
}
