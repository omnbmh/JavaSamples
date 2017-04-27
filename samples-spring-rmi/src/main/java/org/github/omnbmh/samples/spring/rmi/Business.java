package org.github.omnbmh.samples.spring.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @version 2017/4/26 上午11:18
 * @since 1.7
 */

public interface Business {

  public String echo(String message);
}
