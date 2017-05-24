package org.github.omnbmh.commons.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.github.omnbmh.commons.config.FTPConfig;
import org.github.omnbmh.commons.utils.GsonTools;
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
      }
      ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
      result = ftpClient.storeFile(new String(targetFileName.getBytes(encoding), "UTF-8"),
          new FileInputStream(sourceFile));
      if (result) {
        logger.info("[FTP Client] file " + sourceFile + " upload succuess!");
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
}
