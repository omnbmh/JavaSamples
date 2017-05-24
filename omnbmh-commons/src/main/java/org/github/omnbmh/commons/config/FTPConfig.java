package org.github.omnbmh.commons.config;

/**
 * Created With IntelliJ IDEA CE
 * org.github.omnbmh.commons.config FTP 配置!
 * <p>More Info!</p>
 *
 */
public class FTPConfig {

  private String ip;
  private int port;
  private String user;
  private String pwd;

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
}
