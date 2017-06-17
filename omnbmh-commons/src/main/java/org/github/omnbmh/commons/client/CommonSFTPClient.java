package org.github.omnbmh.commons.client;

import com.google.gson.Gson;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.SftpProgressMonitor;
import java.io.File;
import java.util.Properties;
import org.github.omnbmh.commons.config.SFTPConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created With IntelliJ IDEA CE
 * Desc: SFTP客户端!
 *
 * 2017/6/17 上午11:13
 */
public final class CommonSFTPClient {

  private static Logger logger = LoggerFactory.getLogger(CommonSFTPClient.class);

  private static final int DEFAULT_PORT = 22;

//  private CommonSFTPClient() {
//
//  }

  Session session = null;
  Channel channel = null;

  public void closeChannel() throws Exception {
    if (channel != null) {
      channel.disconnect();
    }
    if (session != null) {
      session.disconnect();
    }
  }

  public ChannelSftp getChannel(SFTPConfig config, int timeout) throws JSchException {
    // 设置主机ip，端口，用户名，密码
    String ftpHost = config.getIp();
    int port = config.getPort();
    String ftpUserName = config.getUser();
    String ftpPassword = config.getPwd();

    int ftpPort = DEFAULT_PORT;
    if (port != 0) {
      ftpPort = port;
    }
    logger.info("[SFTP Client] connect - " + new Gson().toJson(config));
    JSch jsch = new JSch();
    session = jsch.getSession(ftpUserName, ftpHost, ftpPort);
    logger.debug("[SFTP Client] Session created.");
    if (ftpPassword != null) {
      session.setPassword(ftpPassword); // 设置密码
    }
    Properties configP = new Properties();
    configP.put("StrictHostKeyChecking", "no");
    session.setConfig(configP); // 为Session对象设置properties
    session.setTimeout(timeout); // 设置timeout时间
    session.connect(); // 通过Session建立链接
    logger.debug("[SFTP Client] Session connected.");

    logger.debug("[SFTP Client] Opening Channel.");
    channel = session.openChannel("sftp"); // 打开SFTP通道
    channel.connect(); // 建立SFTP通道的连接
    logger
        .debug("[SFTP Client] Connected successfully to ftpHost = " + ftpHost + ",as ftpUserName = "
            + ftpUserName
            + ", returning: " + channel);
    return (ChannelSftp) channel;
  }

  public static boolean ls(SFTPConfig config, String sourceFile) {
    try {
      logger.info("[SFTP Client] ls " + sourceFile);
      CommonSFTPClient channel = new CommonSFTPClient();
      ChannelSftp chSftp = channel.getChannel(config, 60000);
      chSftp.ls(sourceFile);
      chSftp.quit();
      channel.closeChannel();
    } catch (JSchException e) {
      logger.error(e.getMessage(), e);
      return false;
    } catch (SftpException e) {
      // 文件不存在 会 跑出异常
      logger.error(e.getMessage(), e);
      return false;
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return false;
    }
    return true;
  }

  public static boolean cd() {
    return true;
  }

  public static boolean put(SFTPConfig config, String srcFile, String dstFile) {
    try {
      logger.info("[SFTP Client] put srcFile " + srcFile);
      logger.info("[SFTP Client] put dstFile " + dstFile);
      CommonSFTPClient channel = new CommonSFTPClient();
      ChannelSftp chSftp = channel.getChannel(config, 60000);
      chSftp.put(srcFile, dstFile, new SFTPProgressMonitor(), ChannelSftp.OVERWRITE);
      chSftp.quit();
      channel.closeChannel();
    } catch (JSchException e) {
      logger.error(e.getMessage(), e);
      return false;
    } catch (SftpException e) {
      logger.error(e.getMessage(), e);
      return false;
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return false;
    }
    return true;
  }

  public static boolean get(SFTPConfig config, String srcFile, String dstFile) {
    try {
      logger.info("[SFTP Client] get srcFile " + srcFile);
      logger.info("[SFTP Client] get dstFile " + dstFile);
      File DownFileEle = new File(dstFile);
      if (!DownFileEle.getParentFile().exists()) {
        DownFileEle.getParentFile().mkdirs();
      }
      CommonSFTPClient channel = new CommonSFTPClient();
      ChannelSftp chSftp = channel.getChannel(config, 60000);
      chSftp.get(srcFile, dstFile, new SFTPProgressMonitor(), ChannelSftp.OVERWRITE);
      chSftp.quit();
      channel.closeChannel();
    } catch (JSchException e) {
      logger.error(e.getMessage(), e);
      return false;
    } catch (SftpException e) {
      logger.error(e.getMessage(), e);
      return false;
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return false;
    }
    return true;
  }
}
class SFTPProgressMonitor implements SftpProgressMonitor {

  private long transfered;

  @Override
  public boolean count(long count) {
    transfered = transfered + count;
    // 输出已传输字节🌲
    System.out.println("Currently transferred total size: " + transfered + " bytes");
    return true;
  }

  @Override
  public void end() {
    System.out.println("Transferring done.");
  }

  @Override
  public void init(int op, String src, String dest, long max) {
    System.out.println("Transferring begin.");
  }
}

