package org.github.omnbmh.samples.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.github.omnbmh.samples.Business;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @author *_*
 * @version 2017/4/26 上午11:27
 * @since 1.7
 */
public class Client {

  public static void main(String[] args) {
    try {
      String name = "BusinessDemo";
      Registry registry = LocateRegistry.getRegistry("127.0.0.1");
      Business business = (Business) registry.lookup(name);
      business.echo("hello");
      business.echo("quit");
    } catch (RemoteException e) {
      System.out.println(e);
    } catch (NotBoundException e) {
      System.out.println(e);
    }
  }
}
