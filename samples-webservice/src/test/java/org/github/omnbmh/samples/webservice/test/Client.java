package org.github.omnbmh.samples.webservice.test;


import org.github.omnbmh.samples.webservice.client.Business;
import org.github.omnbmh.samples.webservice.client.BusinessService;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @author *_*
 * @version 2017/4/27 上午10:16
 * @since 1.7
 */
public class Client {

  public static void main(String[] args) {
    BusinessService businessImplService = new BusinessService();
    Business business = businessImplService.getBusinessPort();
    business.echo("hello");
    business.echo("quit");
  }
}
