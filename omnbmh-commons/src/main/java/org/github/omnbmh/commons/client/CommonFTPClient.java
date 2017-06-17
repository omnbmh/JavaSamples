package org.github.omnbmh.commons.client;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.StringTokenizer;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPHTTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.github.omnbmh.commons.config.FTPConfig;
import org.github.omnbmh.commons.tools.GsonTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created With IntelliJ IDEA CE
 * Desc: FTP客户端!
 */
public final class CommonFTPClient {

  private static Logger logger = LoggerFactory.getLogger(CommonFTPClient.class);


  public static boolean uploadFile(FTPConfig config, String sourceFile, String targetPath,
      String targetFileName) {
    String encoding = System.getProperty("file.encoding");

    boolean result = false;
    logger.info("[FTP Client] connect - " + GsonTools.toJsonString(config));

    FTPClient ftpClient = new FTPClient();
//    FTPClient ftpClient = new FTPHTTPClient("192.168.0.254", 8808);

//    InetSocketAddress addr = new InetSocketAddress("192.168.0.254", 8808);
//    Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
//    ftpClient.setProxy(proxy);
    try {
      int reply;
      ftpClient.connect(config.getIp(), config.getPort());// 连接FTP服务器
      // 登录
      ftpClient.login(config.getUser(), config.getPwd());
      //ftpClient.enterLocalPassiveMode();
      ftpClient.setControlEncoding(encoding);
      // 检验是否连接成功
      reply = ftpClient.getReplyCode();
      logger.info("[FTP Client] replyCode - " + reply);
      if (!FTPReply.isPositiveCompletion(reply)) {
        logger.warn("[FTP Client] connect error");
        ftpClient.disconnect();
        return result;
      }

      // 转移工作目录至指定目录下
      boolean change = ftpClient.changeWorkingDirectory(targetPath);
      logger.info("[FTP Client] change directory " + targetPath);
      if (!change) {
        logger.info("[FTP Client] target " + targetPath + " not found!");
        // 不能创建多级目录
//        ftpClient.makeDirectory(targetPath);

        //保证可以创建多层目录
        StringTokenizer s = new StringTokenizer(targetPath, "/");
        s.countTokens();
        String pathName = "";
        while (s.hasMoreElements()) {
          if ("".equals(pathName)) {
            pathName = s.nextElement() + "/";
          } else {
            pathName = pathName + s.nextElement()+"/";
          }
          try {
            int code = ftpClient.mkd(pathName);
            logger.info("[FTP Client] create directory " + pathName + " success! code " + code);
          } catch (Exception e) {
            logger.error("[FTP Client] create directory error! " + e.getMessage(), e);
          }

        }
        ftpClient.changeWorkingDirectory(targetPath);
        logger.info("[FTP Client] change directory " + targetPath);
      }
      ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
      result = ftpClient.storeFile(new String(targetFileName.getBytes(encoding), "UTF-8"),
          new FileInputStream(sourceFile));
      if (result) {
        logger.info("[FTP Client] file " + sourceFile + " upload to "+targetFileName+ " succuess!");
      }
      ftpClient.logout();
      logger.info("[FTP Client] logout");

    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    } finally {
      if (ftpClient.isConnected()) {
        try {
          ftpClient.disconnect();
        } catch (IOException ioe) {
          logger.error(ioe.getMessage(), ioe);
        }
      }
    }
    return result;
  }

  public static boolean downloadFile(FTPConfig config,String remoteFile, String targetPath,String targetFileName){
    String encoding = System.getProperty("file.encoding");
    boolean result = false;
    logger.info("[FTP Client] connect - " + new Gson().toJson(config));
    FTPClient ftpClient  = new FTPHTTPClient("10.143.128.211", 3128);
//    FTPClient ftpClient = new FTPClient();
    File DownFileEle = new File(targetPath);
    if(!DownFileEle.exists()){
      DownFileEle.mkdirs();
    }
    try {
      int reply;
      ftpClient.setControlEncoding(encoding);
      ftpClient.connect(config.getIp(),config.getPort());

      ftpClient.login(config.getUser(),config.getPwd());
      ftpClient.enterLocalPassiveMode();
//      ftpClient.enterRemotePassiveMode();
      ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
      reply = ftpClient.getReplyCode();
      logger.info("[FTP Client] replyCode - " + reply);
      if(!FTPReply.isPositiveCompletion(reply)){
        logger.warn("[FTP Client] connect error");
        ftpClient.disconnect();
        return result;
      }
      File remoteF = new File(remoteFile);
      System.out.println(remoteF.getParent());
      boolean b = ftpClient.changeWorkingDirectory(new String(remoteF.getParent().getBytes(encoding),"iso-8859-1"));
      if (b) {
        File targetFile = new File(targetPath+"/"+targetFileName);
        OutputStream is = new FileOutputStream(targetFile);
        result = ftpClient.retrieveFile(remoteF.getName(),is);
        is.close();
        if (result) {
          logger.info("[FTP Client] file " + remoteFile + " download to "+ targetFileName + " succuess!");
        }
      }else{
        logger.info("[FTP Client] dictory not contains " + remoteFile);
      }
      ftpClient.logout();
    } catch (Exception e) {
      logger.error(e.getMessage(),e);

    }finally {
      if(ftpClient.isConnected()){
        try {
          ftpClient.disconnect();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return result;
  }
}
