package org.github.omnbmh.samples.cxf;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.jws.WebService;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @version 2017/4/26 上午11:18
 * @since 1.7
 */
@WebService
public interface Business {

  public String echo(String message);
}
