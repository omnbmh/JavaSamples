package org.github.omnbmh.commons.config;

/**
 * Created With IntelliJ IDEA CE
 * SFTP 配置!
 * <p>More Info!</p>
 *
 */
public class SFTPConfig {

  private String ip;
  private int port;
  private String user;
  private String pwd;
  private String rootPath;


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

  public String getRootPath() {
    return rootPath;
  }

  public void setRootPath(String rootPath) {
    this.rootPath = rootPath;
  }
}
