package org.github.omnbmh.samples.zookeeper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Constants {

  public static String zkHost;

  static {
    try {
      Properties prop = new Properties();
      FileInputStream fis = new FileInputStream(
          Constants.class.getResource("/").getPath() + "config.properties");
      //将属性文件流装载到Properties对象中
      prop.load(fis);

      zkHost = prop.getProperty("zkHost", "");

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    System.out.println(Constants.zkHost);
  }
}
